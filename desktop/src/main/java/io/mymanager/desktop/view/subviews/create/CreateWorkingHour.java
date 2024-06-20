package io.mymanager.desktop.view.subviews.create;

import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.data.models.WorkingHour;
import io.mymanager.desktop.service.WorkingHourService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import org.apache.commons.lang3.math.NumberUtils;

public class CreateWorkingHour extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -4041425686102020001L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final WorkingHourService workingHourService;
  private final User user;
  private JPanel buttonPane;
  private JTextField textFieldEmpId;
  private JTextField textFieldAmount;
  private JButton btnSave;
  private JButton btnCancel;

  public CreateWorkingHour(WorkingHourService workingHourService, User user) {
    this.selfReference = this;
    this.workingHourService = workingHourService;
    this.user = user;

    setResizable(false);
    initComponents();
    initEvents();
  }

  private void initComponents() {
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 560, 222);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    JLabel lblCreateNewType = new JLabel("Register working hour  :");
    lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    lblCreateNewType.setBounds(129, 13, 270, 26);
    contentPanel.add(lblCreateNewType);

    JLabel lblEmpId = new JLabel("Emp Id :");
    lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblEmpId.setBounds(20, 50, 73, 26);
    contentPanel.add(lblEmpId);

    JLabel lblAmount = new JLabel("Amount ( hours ) :");
    lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblAmount.setBounds(10, 103, 135, 26);
    contentPanel.add(lblAmount);

    textFieldEmpId = new JTextField();
    textFieldEmpId.setBounds(103, 50, 270, 30);
    contentPanel.add(textFieldEmpId);
    textFieldEmpId.setColumns(10);

    textFieldAmount = new JTextField();
    textFieldAmount.setColumns(10);
    textFieldAmount.setBounds(145, 102, 228, 30);
    contentPanel.add(textFieldAmount);

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
        String amount = textFieldAmount.getText();
        if (!NumberUtils.isParsable(amount)) {
          amount = "0";
        }

        WorkingHour newWorkingHour = new WorkingHour(0, textFieldEmpId.getText(), LocalDate.now(),
            Float.parseFloat(amount), user.getUserId(), user.getUserId(),
            LocalDateTime.now(), LocalDateTime.now());
        try {
          workingHourService.saveWorkingHour(newWorkingHour);
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
