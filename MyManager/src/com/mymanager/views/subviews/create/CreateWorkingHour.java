package com.mymanager.views.subviews.create;

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

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;
import com.mymanager.data.models.WorkingHour;

public class CreateWorkingHour extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041425686102020001L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField textFieldEmpId;
	private JTextField textFieldAmount;
	private JButton okButton;
	private JButton cancelButton;

	private UserController userController;
	private User user;

	public CreateWorkingHour(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();
		selfReference = this;

		setResizable(false);
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCreateNewType = new JLabel("Register working hour  :");
		lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCreateNewType.setBounds(129, 13, 270, 26);
		contentPanel.add(lblCreateNewType);

		JLabel lblEmpId = new JLabel("Emp ID :");
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpId.setBounds(12, 67, 81, 26);
		contentPanel.add(lblEmpId);

		JLabel lblAmount = new JLabel("Amount ( hours ) :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(12, 147, 135, 26);
		contentPanel.add(lblAmount);

		textFieldEmpId = new JTextField();
		textFieldEmpId.setBounds(105, 66, 326, 30);
		contentPanel.add(textFieldEmpId);
		textFieldEmpId.setColumns(10);

		textFieldAmount = new JTextField();
		textFieldAmount.setColumns(10);
		textFieldAmount.setBounds(147, 146, 284, 30);
		contentPanel.add(textFieldAmount);
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
				WorkingHour newWorkingHour = new WorkingHour(0, textFieldEmpId.getText(), LocalDate.now(),
						Float.parseFloat(textFieldAmount.getText()), user.getUserId(), user.getUserId(),
						LocalDateTime.now(), LocalDateTime.now());
				userController.saveWorkingHour(newWorkingHour);
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
