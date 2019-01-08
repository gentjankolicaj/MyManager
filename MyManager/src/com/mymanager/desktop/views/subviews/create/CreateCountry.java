package com.mymanager.desktop.views.subviews.create;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.Country;
import com.mymanager.desktop.views.subviews.CurrencyView;

public class CreateCountry extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8373954310692448463L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldCountry;
	private UserController userController;

	/**
	 * Create the dialog.
	 */
	public CreateCountry(UserController userController) {
		selfReference = this;
		this.userController = userController;
		initComponents();
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newCountry = textFieldCountry.getText();
				userController.saveCountry(new Country(newCountry));
				selfReference.dispose();
			}
		});

		textFieldCountry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newCountry = textFieldCountry.getText();
					userController.saveCountry(new Country(newCountry));
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCurrencies = new JLabel("New country");
		lblCurrencies.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrencies.setBounds(124, 11, 103, 24);
		contentPanel.add(lblCurrencies);

		btnCreate = new JButton("Save");

		btnCreate.setIcon(new ImageIcon(
				CreateCurrency.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
		btnCreate.setBounds(217, 65, 108, 24);
		contentPanel.add(btnCreate);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(10, 66, 197, 22);
		textFieldCountry.setColumns(10);
		contentPanel.add(textFieldCountry);
	}
}
