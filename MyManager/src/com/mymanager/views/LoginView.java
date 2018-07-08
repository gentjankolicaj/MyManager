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
import com.mymanager.controllers.AdminController;
import com.mymanager.controllers.AssistantController;
import com.mymanager.controllers.FinanceController;
import com.mymanager.controllers.HumanResourceController;
import com.mymanager.controllers.ManagerController;
import com.mymanager.controllers.UserController;
import com.mymanager.data.data_access.UserAccessObject;
import com.mymanager.data.data_access.interfaces.UserAccess;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;
import com.mymanager.utils.AppUtil;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;
import com.mymanager.utils.UtilWindow;

public class LoginView extends JPanel {
	private JFrame jframe;
	private MainView mainView;

	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JButton btnClose;
	private JButton btnLogin;

	private UserController userController;
	private UserAccess userAccess;
	private JPanel infoPanel;
	private JPanel loginPanel;
	private JLabel lblPassword;
	private JLabel lblUser;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public LoginView(JFrame jframe) {
		this.jframe = jframe;
		mainView = new MainView(jframe);
		initDao();
		initComponents();
		initButtonEvents();
		initKeyEvents();

	}

	public void initComponents() {
		setBorder(new LineBorder(new Color(0, 206, 209)));
		setLayout(null);

		loginPanel = new JPanel();
		loginPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
		loginPanel.setBackground(Color.WHITE);
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

	public void initDao() {
		userAccess = new UserAccessObject();
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
				// test user
				// user:1
				// password: 1
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
		boolean auth = false;
		String userId = textFieldUsername.getText();
		char[] pass = textFieldPassword.getPassword();
		String password = String.valueOf(pass);
		try {
			User user = userAccess.readUser(userId);
			if (user != null) {
				if (validateUser(user, userId, password)) {
					userController = decideController(user);
					auth = true;
				} else {
					UtilWindow.showMessage(jframe, "User and password don't match.", MessageType.WARNING);
				}
			} else {
				UtilWindow.showMessage(jframe, "User with ID :" + userId + " not found in database.",
						MessageType.WARNING);
			}

		} catch (Exception e1) {
			UtilWindow.showMessage(jframe, "User with ID : " + userId + " not found in database.", MessageType.WARNING);
			PrintUtils.print(e1, PrintType.DATABASE_QUERY);
			return false;
		}

		return auth;
	}

	private boolean validateUser(User user, String userId, String password) {
		boolean status = false;
		String userIdTemp = user.getUserId();
		String userPassTemp = user.getPassword();
		if ((userIdTemp.equals(userId)) && (userPassTemp.equals(password))) {
			status = true;
		}

		return status;
	}

	private UserController decideController(User user) {
		if (user.getUserType().equals(UserType.ADMIN)) {
			return new AdminController(user, this);
		} else if (user.getUserType().equals(UserType.ASSISTANT)) {
			return new AssistantController(user, this);
		} else if (user.getUserType().equals(UserType.FINANCE)) {
			return new FinanceController(user, this);
		} else if (user.getUserType().equals(UserType.HR)) {
			return new HumanResourceController(user, this);
		} else {
			return new ManagerController(user, this);
		}
	}

}
