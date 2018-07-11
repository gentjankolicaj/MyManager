package com.mymanager.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.mymanager.config.AppText;
import com.mymanager.controllers.UserController;
import com.mymanager.data.data_access.UserAccessObject;
import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.models.User;
import com.mymanager.utils.AppUtil;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;
import com.mymanager.utils.UtilWindow;

public class LoginView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame jframe;
	private MainView mainView;

	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JButton btnClose;
	private JButton btnLogin;

	private JPanel infoPanel;
	private JPanel loginPanel;
	private JLabel lblPassword;
	private JLabel lblUser;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;

	private UserController userController;
	private UserAccess userAccess;

	/**
	 * Create the panel.
	 */
	public LoginView(JFrame jframe) {
		this.jframe = jframe;
		mainView = new MainView(jframe);
		userAccess = new UserAccessObject();
		initComponents();
		initButtonEvents();
		initKeyEvents();

	}

	public void initComponents() {
		setBorder(new LineBorder(new Color(0, 206, 209)));
		setLayout(null);

		loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		loginPanel.setBackground(UIManager.getColor("Button.background"));
		loginPanel.setBounds(0, 0, 392, 650);
		add(loginPanel);
		loginPanel.setLayout(null);

		lblUser = new JLabel("User ID :");
		lblUser.setIcon(new ImageIcon(LoginView.class
				.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-login-to-my-account.png")));
		lblUser.setBounds(49, 228, 83, 39);
		loginPanel.add(lblUser);

		textFieldUsername = new JTextField();
		textFieldUsername.setForeground(new Color(0, 0, 0));
		textFieldUsername.setBounds(129, 237, 183, 20);
		loginPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		lblPassword = new JLabel("Password :");
		lblPassword.setIcon(new ImageIcon(
				LoginView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-key.png")));
		lblPassword.setBounds(36, 300, 96, 24);
		loginPanel.add(lblPassword);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setForeground(Color.BLACK);
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(129, 302, 183, 20);
		loginPanel.add(textFieldPassword);

		btnLogin = new JButton(AppText.loginButtonText);
		btnLogin.setIcon(new ImageIcon(
				LoginView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-login-2.png")));
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.setBounds(56, 390, 106, 33);
		loginPanel.add(btnLogin);

		btnClose = new JButton(AppText.closeButtonText);
		btnClose.setIcon(new ImageIcon(LoginView.class
				.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-switch-power-off-2.png")));
		btnClose.setBackground(UIManager.getColor("Button.background"));
		btnClose.setBounds(206, 390, 106, 33);
		loginPanel.add(btnClose);

		infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		infoPanel.setBackground(new Color(0, 191, 255));
		infoPanel.setBounds(392, 0, 508, 650);
		add(infoPanel);
		infoPanel.setLayout(null);

		lblNewLabel = new JLabel(AppText.applicationTitle);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(65, 11, 215, 27);
		infoPanel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/com/mymanager/resources/icons/image.png")));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 39, 488, 512);
		infoPanel.add(lblNewLabel_1);
		jframe.setContentPane(this);
	}

	public void initKeyEvents() {
		textFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (authenticate()) {
						mainView.setUserController(userController);
						AppUtil.changePanel(jframe, mainView);

					}
				}
			}
		});

		textFieldUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (authenticate()) {
						mainView.setUserController(userController);
						AppUtil.changePanel(jframe, mainView);

					}
				}
			}
		});

	}

	public void initButtonEvents() {
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (authenticate()) {
					mainView.setUserController(userController);
					AppUtil.changePanel(jframe, mainView);

				}

			}
		});

		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private boolean authenticate() {

		String userId = textFieldUsername.getText();
		char[] pass = textFieldPassword.getPassword();
		String password = String.valueOf(pass);

		try {
			User user = userAccess.readUser(userId);
			if (user != null) {
				if (AppUtil.validateUser(user, userId, password)) {
					userController = AppUtil.decideController(user);
					return true;
				} else
					UtilWindow.showMessage(jframe, "User and password don't match.", MessageType.WARNING);

			} else
				UtilWindow.showMessage(jframe, "User with ID :" + userId + " not found in database.",
						MessageType.WARNING);

		} catch (Exception e1) {
			UtilWindow.showMessage(jframe, "User with ID : " + userId + " not found in database.", MessageType.WARNING);
			PrintUtils.print(e1, PrintType.DATABASE_QUERY);
			return false;
		}

		return false;
	}

}
