package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.Job;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.JobService;
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

public class EditJob extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7073986236252726976L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final JobService jobService;
  private final User user;
  private final Job oldJob;
  private JPanel buttonPane;
  private JButton btnSave;
  private JButton btnCancel;
  private JTextField textFieldTitle;
  private JTextField textFieldMinSalary;
  private JTextField textFieldMaxSalary;
  private JLabel lblCreatedBy;
  private JTextField textFieldCreatedBy;

  /**
   * Create the dialog.
   */
  public EditJob(JobService jobService, User user, Job oldJob) {
    this.selfReference = this;
    this.jobService = jobService;
    this.user = user;
    this.oldJob = oldJob;

    initComponents();
    initEvents();
    fillDetails();

  }

  private void initComponents() {
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 560, 350);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblEditExistingJob = new JLabel("Edit existing job :");
      lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
      lblEditExistingJob.setBounds(129, 13, 270, 26);
      contentPanel.add(lblEditExistingJob);
    }
    {
      JLabel label = new JLabel("Job Title :");
      label.setFont(new Font("Tahoma", Font.BOLD, 14));
      label.setBounds(10, 51, 81, 26);
      contentPanel.add(label);
    }
    {
      textFieldTitle = new JTextField();
      textFieldTitle.setColumns(10);
      textFieldTitle.setBounds(103, 50, 286, 30);
      contentPanel.add(textFieldTitle);
    }
    {
      JLabel label = new JLabel("Min salary  :");
      label.setFont(new Font("Tahoma", Font.BOLD, 14));
      label.setBounds(10, 112, 81, 26);
      contentPanel.add(label);
    }
    {
      textFieldMinSalary = new JTextField();
      textFieldMinSalary.setColumns(10);
      textFieldMinSalary.setBounds(103, 111, 286, 30);
      contentPanel.add(textFieldMinSalary);
    }
    {
      JLabel label = new JLabel("Max salary :");
      label.setFont(new Font("Tahoma", Font.BOLD, 14));
      label.setBounds(10, 175, 93, 26);
      contentPanel.add(label);
    }
    {
      textFieldMaxSalary = new JTextField();
      textFieldMaxSalary.setColumns(10);
      textFieldMaxSalary.setBounds(103, 174, 286, 30);
      contentPanel.add(textFieldMaxSalary);
    }
    {
      lblCreatedBy = new JLabel("Created by  :");
      lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCreatedBy.setBounds(10, 237, 93, 26);
      contentPanel.add(lblCreatedBy);
    }
    {
      textFieldCreatedBy = new JTextField();
      textFieldCreatedBy.setColumns(10);
      textFieldCreatedBy.setBounds(103, 236, 286, 30);
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
        Job newJob = new Job(oldJob.getJobId(), textFieldTitle.getText(),
            Float.parseFloat(textFieldMaxSalary.getText()),
            Float.parseFloat(textFieldMinSalary.getText()),
            textFieldCreatedBy.getText(), user.getUserId(), LocalDateTime.now(),
            LocalDateTime.now());
        try {

          jobService.updateJob(oldJob, newJob);

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
    textFieldTitle.setText(oldJob.getJobTitle());
    textFieldMinSalary.setText(String.valueOf(oldJob.getMinSalary()));
    textFieldMaxSalary.setText(String.valueOf(oldJob.getMaxSalary()));
    textFieldCreatedBy.setText(oldJob.getCreatedBy());

  }

}
