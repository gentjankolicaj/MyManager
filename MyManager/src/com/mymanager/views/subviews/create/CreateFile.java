package com.mymanager.views.subviews.create;

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
import com.mymanager.data.models.FileType;
import com.mymanager.views.subviews.CurrencyView;

public class CreateFile extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8197507233437896919L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldFile;
	private UserController userController;

	/**
	 * Create the dialog.
	 */
	public CreateFile(UserController userController) {
		selfReference = this;
		this.userController = userController;
		initComponents();
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newFileType = textFieldFile.getText();
				userController.saveFileType(new FileType(newFileType));
				selfReference.dispose();
			}
		});

		textFieldFile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newFile = textFieldFile.getText();
					userController.saveFileType(new FileType(newFile));
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCurrencies = new JLabel("New file type");
		lblCurrencies.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrencies.setBounds(192, 31, 103, 24);
		contentPanel.add(lblCurrencies);

		btnCreate = new JButton("Save");
		btnCreate.setIcon(new ImageIcon(
				CreateCurrency.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
		btnCreate.setBounds(10, 61, 113, 33);
		contentPanel.add(btnCreate);

		textFieldFile = new JTextField();
		textFieldFile.setBounds(153, 66, 182, 22);
		contentPanel.add(textFieldFile);
		textFieldFile.setColumns(10);
	}

}
