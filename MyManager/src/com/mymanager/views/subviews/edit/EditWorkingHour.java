package com.mymanager.views.subviews.edit;

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
import com.mymanager.data.models.User;
import com.mymanager.data.models.WorkingHour;

public class EditWorkingHour extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073986236252726976L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldEmpId;
	private JTextField textFieldAmount;
	private JLabel lblCreatedBy;
	private JTextField textFieldCreatedBy;

	private UserController userController;
	private User user;
	private WorkingHour oldWorkingHour;

	/**
	 * Create the dialog.
	 */
	public EditWorkingHour(UserController userController, WorkingHour oldWorkingHour) {
		this.userController = userController;
		this.user = userController.getUser();
		this.oldWorkingHour = oldWorkingHour;
		selfReference = this;
		initComponents();
		initEvents();

		fillDetails();

	}

	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 299);
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
			JLabel lblEmpID = new JLabel("Emp ID :");
			lblEmpID.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEmpID.setBounds(14, 59, 81, 26);
			contentPanel.add(lblEmpID);
		}
		{
			textFieldEmpId = new JTextField();
			textFieldEmpId.setColumns(10);
			textFieldEmpId.setBounds(84, 58, 326, 30);
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
			textFieldAmount.setBounds(159, 119, 252, 30);
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
			textFieldCreatedBy.setBounds(103, 176, 311, 30);
			contentPanel.add(textFieldCreatedBy);
		}
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
				WorkingHour newWorkingHour = new WorkingHour(oldWorkingHour.getIndex(), textFieldEmpId.getText(),
						oldWorkingHour.getDate(), Float.parseFloat(textFieldAmount.getText()),
						textFieldCreatedBy.getText(), user.getUserId(), oldWorkingHour.getCreatedDate(),
						LocalDateTime.now());
				userController.editWorkingHour(oldWorkingHour, newWorkingHour);
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
		textFieldEmpId.setText(oldWorkingHour.getEmployeeId());
		textFieldAmount.setText(String.valueOf(oldWorkingHour.getAmount()));
		textFieldCreatedBy.setText(oldWorkingHour.getCreatedBy());
	}
}
