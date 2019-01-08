package com.mymanager.desktop.views.subviews.create;

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

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.Job;
import com.mymanager.data.models.User;

public class CreateJob extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041425686102020001L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField textFieldTitle;
	private JTextField textFieldMaxSalary;
	private JTextField textFieldMinSalary;
	private JButton okButton;
	private JButton cancelButton;

	private UserController userController;
	private User user;

	public CreateJob(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();
		selfReference = this;
		setResizable(false);
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCreateNewType = new JLabel("Create new type of job :");
		lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCreateNewType.setBounds(129, 13, 270, 26);
		contentPanel.add(lblCreateNewType);

		JLabel lblJobTitle = new JLabel("Job Title :");
		lblJobTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJobTitle.setBounds(12, 67, 81, 26);
		contentPanel.add(lblJobTitle);

		JLabel lblMinSalary = new JLabel("Min salary  :");
		lblMinSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinSalary.setBounds(12, 116, 81, 26);
		contentPanel.add(lblMinSalary);

		JLabel lblMaxSalary = new JLabel("Max salary :");
		lblMaxSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaxSalary.setBounds(12, 167, 93, 26);
		contentPanel.add(lblMaxSalary);

		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(105, 66, 270, 30);
		contentPanel.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		textFieldMinSalary = new JTextField();
		textFieldMinSalary.setColumns(10);
		textFieldMinSalary.setBounds(105, 115, 270, 30);
		contentPanel.add(textFieldMinSalary);

		textFieldMaxSalary = new JTextField();
		textFieldMaxSalary.setColumns(10);
		textFieldMaxSalary.setBounds(105, 166, 270, 30);
		contentPanel.add(textFieldMaxSalary);
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
				Job newJob = new Job(1, textFieldTitle.getText(), Float.parseFloat(textFieldMaxSalary.getText()),
						Float.parseFloat(textFieldMinSalary.getText()), user.getUserId(), user.getUserId(),
						LocalDateTime.now(), LocalDateTime.now());
				userController.saveJob(newJob);
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
}
