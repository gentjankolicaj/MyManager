package io.mymanager.desktop.view.subviews.edit;

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

public class EditDepartment extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7073986236252726976L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final Department oldDepartment;
  private final DepartmentService departmentService;
  private final User user;
  private JPanel buttonPane;
  private JButton okButton;
  private JButton cancelButton;
  private JTextField textFieldDepName;
  private JLabel lblCreatedBy;
  private JTextField textFieldCreatedBy;
  private JTextField textFieldManId;

  /**
   * Create the dialog.
   */
  public EditDepartment(DepartmentService departmentService, User user, Department oldDepartment) {
    this.selfReference = this;
    this.departmentService = departmentService;
    this.user = user;
    this.oldDepartment = oldDepartment;

    initComponents();
    initEvents();
    fillDetails();

  }

  private void initComponents() {
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 600, 275);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblEditExistingJob = new JLabel("Edit existing department :");
      lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
      lblEditExistingJob.setBounds(129, 13, 270, 26);
      contentPanel.add(lblEditExistingJob);
    }
    {
      JLabel lblDepName = new JLabel("Dep name :");
      lblDepName.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblDepName.setBounds(10, 51, 81, 26);
      contentPanel.add(lblDepName);
    }
    {
      textFieldDepName = new JTextField();
      textFieldDepName.setColumns(10);
      textFieldDepName.setBounds(103, 50, 301, 30);
      contentPanel.add(textFieldDepName);
    }
    {
      lblCreatedBy = new JLabel("Created by  :");
      lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCreatedBy.setBounds(10, 159, 93, 26);
      contentPanel.add(lblCreatedBy);
    }
    {
      textFieldCreatedBy = new JTextField();
      textFieldCreatedBy.setColumns(10);
      textFieldCreatedBy.setBounds(103, 159, 301, 30);
      contentPanel.add(textFieldCreatedBy);
    }

    JLabel lblManId = new JLabel("Manager Id  :");
    lblManId.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblManId.setBounds(10, 101, 93, 26);
    contentPanel.add(lblManId);

    textFieldManId = new JTextField();
    textFieldManId.setColumns(10);
    textFieldManId.setBounds(113, 101, 291, 30);
    contentPanel.add(textFieldManId);
    {
      buttonPane = new JPanel();
      buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        okButton = new JButton("Save");
        okButton.setActionCommand("Save");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
      }
      {
        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
      }
    }
  }

  private void initEvents() {
    okButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        Department newDepartment = new Department(oldDepartment.getDepartmentId(),
            textFieldDepName.getText(),
            textFieldManId.getText(), textFieldCreatedBy.getText(), user.getUserId(),
            oldDepartment.getCreatedDate(), LocalDateTime.now());
        try {

          departmentService.updateDepartment(oldDepartment, newDepartment);

        } catch (Exception e1) {

          e1.printStackTrace();
        }
        selfReference.dispose();

      }
    });

    cancelButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        selfReference.dispose();
      }
    });
  }

  private void fillDetails() {
    textFieldDepName.setText(oldDepartment.getDepartmentName());
    textFieldManId.setText(oldDepartment.getManagerId());
    textFieldCreatedBy.setText(oldDepartment.getCreatedBy());

  }
}
