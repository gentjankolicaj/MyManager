package io.mymanager.desktop.view.subviews.create;

import io.mymanager.desktop.data.models.Department;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.DepartmentService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CreateDepartment extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -4041425686102020001L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final DepartmentService departmentService;
  private final User user;
  private JPanel buttonPane;
  private JTextField textFieldName;
  private JButton btnSave;
  private JButton btnCancel;
  private JTextField textFieldManId;

  public CreateDepartment(DepartmentService departmentService, User user) {
    this.selfReference = this;
    this.departmentService = departmentService;
    this.user = user;

    setResizable(false);

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 560, 264);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    JLabel lblDepartmentName = new JLabel("Dep name  :");
    lblDepartmentName.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDepartmentName.setBounds(12, 67, 93, 26);
    contentPanel.add(lblDepartmentName);

    textFieldName = new JTextField();
    textFieldName.setBounds(105, 66, 270, 30);
    contentPanel.add(textFieldName);
    textFieldName.setColumns(10);

    JLabel lblManId = new JLabel("Manager ID :");
    lblManId.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblManId.setBounds(12, 147, 93, 26);
    contentPanel.add(lblManId);

    JLabel lblCreateNewType = new JLabel("Create new department :");
    lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    lblCreateNewType.setBounds(129, 13, 270, 26);
    contentPanel.add(lblCreateNewType);

    textFieldManId = new JTextField();
    textFieldManId.setColumns(10);
    textFieldManId.setBounds(105, 147, 270, 30);
    contentPanel.add(textFieldManId);

    buttonPane = new JPanel();
    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
    getContentPane().add(buttonPane, BorderLayout.SOUTH);

    btnSave = new JButton("Save");
    btnSave.setActionCommand("Save");
    buttonPane.add(btnSave);
    getRootPane().setDefaultButton(btnSave);

    btnCancel = new JButton("Cancel");
    btnCancel.setActionCommand("Cancel");
    buttonPane.add(btnCancel);


  }

  private void initEvents() {
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        String managerId = textFieldManId.getText();
        Department newDepartment = new Department(1, textFieldName.getText(), managerId,
            user.getUserId(),
            user.getUserId(), LocalDateTime.now(), LocalDateTime.now());
        try {

          departmentService.saveDepartment(newDepartment);

        } catch (Exception e1) {

          e1.printStackTrace();
        }
        selfReference.dispose();
      }
    });

    btnCancel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        selfReference.dispose();

      }
    });
  }

}
