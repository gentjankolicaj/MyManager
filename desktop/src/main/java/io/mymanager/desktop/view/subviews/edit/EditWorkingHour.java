package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.data.models.WorkingHour;
import io.mymanager.desktop.service.WorkingHourService;
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
import org.apache.commons.lang3.math.NumberUtils;

public class EditWorkingHour extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7073986236252726976L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final WorkingHourService workingHourService;
  private final User user;
  private final WorkingHour oldWorkingHour;
  private JPanel buttonPane;
  private JButton btnSave;
  private JButton btnCancel;
  private JTextField textFieldEmpId;
  private JTextField textFieldAmount;
  private JLabel lblCreatedBy;
  private JTextField textFieldCreatedBy;

  /**
   * Create the dialog.
   */
  public EditWorkingHour(WorkingHourService workingHourService, User user,
      WorkingHour oldWorkingHour) {
    this.selfReference = this;
    this.workingHourService = workingHourService;
    this.user = user;
    this.oldWorkingHour = oldWorkingHour;

    initComponents();
    initEvents();

    fillDetails();

  }

  private void initComponents() {
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 560, 299);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblEditExistingWH = new JLabel("Edit working hour :");
      lblEditExistingWH.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
      lblEditExistingWH.setBounds(129, 13, 270, 26);
      contentPanel.add(lblEditExistingWH);
    }
    {
      JLabel lblEmpID = new JLabel("Emp Id :");
      lblEmpID.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblEmpID.setBounds(14, 59, 81, 26);
      contentPanel.add(lblEmpID);
    }
    {
      textFieldEmpId = new JTextField();
      textFieldEmpId.setColumns(10);
      textFieldEmpId.setBounds(84, 58, 290, 30);
      contentPanel.add(textFieldEmpId);
    }
    {
      JLabel lblAmount = new JLabel("Amount ( hours )  :");
      lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblAmount.setBounds(14, 120, 133, 26);
      contentPanel.add(lblAmount);
    }
    {
      textFieldAmount = new JTextField();
      textFieldAmount.setColumns(10);
      textFieldAmount.setBounds(159, 119, 215, 30);
      contentPanel.add(textFieldAmount);
    }
    {
      lblCreatedBy = new JLabel("Created by  :");
      lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCreatedBy.setBounds(10, 177, 93, 26);
      contentPanel.add(lblCreatedBy);
    }
    {
      textFieldCreatedBy = new JTextField();
      textFieldCreatedBy.setColumns(10);
      textFieldCreatedBy.setBounds(103, 176, 271, 30);
      contentPanel.add(textFieldCreatedBy);
    }
    {
      buttonPane = new JPanel();
      buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      {
        btnSave = new JButton("Save");
        btnSave.setActionCommand("Save");
        buttonPane.add(btnSave);
        getRootPane().setDefaultButton(btnSave);
      }
      {
        btnCancel = new JButton("Cancel");
        btnCancel.setActionCommand("Cancel");
        buttonPane.add(btnCancel);
      }
    }
  }

  private void initEvents() {
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        String amount = textFieldAmount.getText();
        if (!NumberUtils.isParsable(amount)) {
          amount = "0";
        }

        WorkingHour newWorkingHour = new WorkingHour(oldWorkingHour.getIndex(),
            textFieldEmpId.getText(),
            oldWorkingHour.getDate(), Float.parseFloat(amount),
            textFieldCreatedBy.getText(), user.getUserId(), oldWorkingHour.getCreatedDate(),
            LocalDateTime.now());
        try {

          workingHourService.updateWorkingHour(oldWorkingHour, newWorkingHour);

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

  private void fillDetails() {
    textFieldEmpId.setText(oldWorkingHour.getEmployeeId());
    textFieldAmount.setText(String.valueOf(oldWorkingHour.getAmount()));
    textFieldCreatedBy.setText(oldWorkingHour.getCreatedBy());
  }
}
