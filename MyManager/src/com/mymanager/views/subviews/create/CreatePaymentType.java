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

import com.mymanager.controllers.AdminController;
import com.mymanager.data.models.PaymentType;
import com.mymanager.views.subviews.CurrencyView;

public class CreatePaymentType extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7927585795717063183L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldPayment;
	private AdminController adminController;

	/**
	 * Create the dialog.
	 */
	public CreatePaymentType(AdminController adminController) {
		selfReference = this;
		this.adminController = adminController;
		initComponents();
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newPaymentType = textFieldPayment.getText();
				adminController.savePaymentType(new PaymentType(newPaymentType));
				selfReference.dispose();
			}
		});

		textFieldPayment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newPaymentType = textFieldPayment.getText();
					adminController.savePaymentType(new PaymentType(newPaymentType));
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCurrencies = new JLabel("New type of payment");
		lblCurrencies.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrencies.setBounds(154, 30, 169, 24);
		contentPanel.add(lblCurrencies);

		btnCreate = new JButton("Save");

		btnCreate.setIcon(new ImageIcon(
				CreateCurrency.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
		btnCreate.setBounds(10, 61, 110, 33);
		contentPanel.add(btnCreate);

		textFieldPayment = new JTextField();
		textFieldPayment.setBounds(141, 66, 182, 22);
		contentPanel.add(textFieldPayment);
		textFieldPayment.setColumns(10);
	}
}
