package com.mymanager.views.subviews.edit;

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
import com.mymanager.views.subviews.CurrencyView;

public class EditCountry extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8373954310692448463L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldCountry;
	private UserController userController;
	private Country oldCountry;

	/**
	 * Create the dialog.
	 */
	public EditCountry(UserController userController, Country oldCountry) {
		selfReference = this;
		this.userController = userController;
		this.oldCountry = oldCountry;
		initComponents();
		textFieldCountry.setText(oldCountry.getCountryName());
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newCountry = textFieldCountry.getText();
				userController.editCountry(oldCountry, new Country(newCountry));
				selfReference.dispose();
			}
		});

		textFieldCountry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newCountry = textFieldCountry.getText();
					userController.editCountry(oldCountry, new Country(newCountry));
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCurrencies = new JLabel("Edit country");
		lblCurrencies.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrencies.setBounds(161, 31, 103, 24);
		contentPanel.add(lblCurrencies);

		btnCreate = new JButton("Save");

		btnCreate.setIcon(new ImageIcon(
				EditCountry.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
		btnCreate.setBounds(10, 61, 108, 33);
		contentPanel.add(btnCreate);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(128, 66, 182, 22);
		textFieldCountry.setColumns(10);
		contentPanel.add(textFieldCountry);
	}
}
