package com.mymanager.views.subviews.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;

public class CreateProject extends JDialog {

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
	private JLabel label;
	private JTextField textFieldDesc;
	private JLabel label_1;
	private JTextField textFieldCustomer;
	private JLabel label_2;
	private JComboBox comboBoxCountry;

	private UserController userController;
	private User user;

	public CreateProject(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();
		selfReference = this;

		setResizable(false);
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblJobTitle = new JLabel("Project name :");
		lblJobTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJobTitle.setBounds(12, 67, 105, 26);
		contentPanel.add(lblJobTitle);

		textFieldName = new JTextField();
		textFieldName.setBounds(129, 66, 326, 30);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblCreateNewType = new JLabel("Create new project :");
		lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCreateNewType.setBounds(129, 13, 270, 26);
		contentPanel.add(lblCreateNewType);

		label = new JLabel("Project desc :");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(12, 124, 105, 26);
		contentPanel.add(label);

		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(129, 123, 326, 30);
		contentPanel.add(textFieldDesc);

		label_1 = new JLabel("Customer  :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(12, 179, 81, 26);
		contentPanel.add(label_1);

		textFieldCustomer = new JTextField();
		textFieldCustomer.setColumns(10);
		textFieldCustomer.setBounds(129, 178, 326, 30);
		contentPanel.add(textFieldCustomer);

		label_2 = new JLabel("Country  :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(12, 239, 93, 26);
		contentPanel.add(label_2);

		comboBoxCountry = new JComboBox();
		comboBoxCountry.setBounds(142, 235, 257, 36);
		contentPanel.add(comboBoxCountry);
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
