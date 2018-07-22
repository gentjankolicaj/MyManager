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
import com.mymanager.data.models.Department;
import com.mymanager.data.models.User;

public class EditDepartment extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073986236252726976L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldDepName;
	private JTextField textFieldDepId;
	private JLabel lblCreatedBy;
	private JTextField textFieldCreatedBy;
	private JTextField textFieldManId;

	private Department oldDepartment;
	private UserController userController;
	private User user;

	/**
	 * Create the dialog.
	 */
	public EditDepartment(UserController userController, Department oldDepartment) {
		this.userController = userController;
		this.user = userController.getUser();
		this.oldDepartment = oldDepartment;
		selfReference = this;
		initComponents();
		initEvents();
		fillDetails();

	}

	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 469);
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
			JLabel lblDepartmentId = new JLabel("Dep Id :");
			lblDepartmentId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDepartmentId.setBounds(12, 72, 81, 26);
			contentPanel.add(lblDepartmentId);
		}
		{
			textFieldDepId = new JTextField();
			textFieldDepId.setColumns(10);
			textFieldDepId.setBounds(105, 71, 326, 30);
			contentPanel.add(textFieldDepId);
		}
		{
			JLabel lblDepName = new JLabel("Dep name :");
			lblDepName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDepName.setBounds(12, 129, 81, 26);
			contentPanel.add(lblDepName);
		}
		{
			textFieldDepName = new JTextField();
			textFieldDepName.setColumns(10);
			textFieldDepName.setBounds(105, 128, 326, 30);
			contentPanel.add(textFieldDepName);
		}
		{
			lblCreatedBy = new JLabel("Created by  :");
			lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCreatedBy.setBounds(12, 191, 93, 26);
			contentPanel.add(lblCreatedBy);
		}
		{
			textFieldCreatedBy = new JTextField();
			textFieldCreatedBy.setColumns(10);
			textFieldCreatedBy.setBounds(105, 190, 326, 30);
			contentPanel.add(textFieldCreatedBy);
		}

		JLabel lblManId = new JLabel("Manager Id  :");
		lblManId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblManId.setBounds(12, 254, 93, 26);
		contentPanel.add(lblManId);

		textFieldManId = new JTextField();
		textFieldManId.setColumns(10);
		textFieldManId.setBounds(115, 259, 316, 30);
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
				Department newDepartment = new Department(Integer.parseInt(textFieldDepId.getText()),
						textFieldDepName.getText(), textFieldManId.getText(), textFieldCreatedBy.getText(),
						user.getUserId(), oldDepartment.getCreatedDate(), LocalDateTime.now());
				userController.editDepartment(oldDepartment, newDepartment);
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
		textFieldDepId.setText(String.valueOf(oldDepartment.getDepartmentId()));
		textFieldDepName.setText(oldDepartment.getDepartmentName());
		textFieldManId.setText(oldDepartment.getManagerId());
		textFieldCreatedBy.setText(oldDepartment.getCreatedBy());

	}
}
