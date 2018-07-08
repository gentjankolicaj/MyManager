package com.mymanager.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mymanager.config.AppIcon;
import com.mymanager.config.AppText;

public class LoginView extends JPanel {
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnClose;
	private JButton btnLogin;

	/**
	 * Create the panel.
	 */
	public LoginView(JFrame jframe) {
		setBorder(new LineBorder(new Color(0, 206, 209)));
		setLayout(null);

		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBounds(0, 0, 317, 376);
		add(loginPanel);
		loginPanel.setLayout(null);

		JLabel lblUser = new JLabel("User :");
		lblUser.setIcon(new ImageIcon(LoginView.class
				.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-login-to-my-account.png")));
		lblUser.setBounds(16, 47, 73, 39);
		loginPanel.add(lblUser);

		textFieldUsername = new JTextField();
		textFieldUsername.setForeground(new Color(0, 0, 0));
		textFieldUsername.setBounds(99, 56, 183, 20);
		loginPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setIcon(new ImageIcon(
				LoginView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-key.png")));
		lblPassword.setBounds(10, 107, 96, 24);
		loginPanel.add(lblPassword);

		textFieldPassword = new JTextField();
		textFieldPassword.setForeground(Color.BLACK);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(99, 109, 183, 20);
		loginPanel.add(textFieldPassword);

		btnLogin = new JButton(AppText.loginButtonText);
		btnLogin.setIcon(new ImageIcon(
				LoginView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-login-2.png")));
		btnLogin.setBackground(new Color(0, 191, 255));
		btnLogin.setBounds(55, 221, 106, 33);
		loginPanel.add(btnLogin);

		btnClose = new JButton(AppText.closeButtonText);
		btnClose.setIcon(new ImageIcon(
				LoginView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-close-window-2.png")));
		btnClose.setBackground(new Color(0, 191, 255));
		btnClose.setBounds(176, 221, 106, 33);
		loginPanel.add(btnClose);

		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		infoPanel.setBackground(new Color(0, 191, 255));
		infoPanel.setBounds(319, 0, 331, 376);
		add(infoPanel);
		infoPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel(AppText.applicationTitle);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(65, 11, 215, 27);
		infoPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(AppIcon.getIcon(AppIcon.appImage));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(29, 89, 279, 227);
		infoPanel.add(lblNewLabel_1);

	}

	public void initButtonEvents() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
	}

}
