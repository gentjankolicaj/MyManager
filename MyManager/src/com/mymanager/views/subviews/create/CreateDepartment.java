package com.mymanager.views.subviews.create;

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

public class CreateDepartment extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041425686102020001L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField textFieldName;
	private JButton okButton;
	private JButton cancelButton;

	private UserController userController;
	private User user;
	private JTextField textFieldManId;

	public CreateDepartment(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();
		selfReference = this;
		setResizable(false);
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 264);
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
				String managerId = textFieldManId.getText();
				Department newDepartment = new Department(1, textFieldName.getText(), managerId, user.getUserId(),
						user.getUserId(), LocalDateTime.now(), LocalDateTime.now());
				userController.saveDepartment(newDepartment);
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
