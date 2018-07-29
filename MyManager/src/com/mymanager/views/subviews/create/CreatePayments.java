package com.mymanager.views.subviews.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.Currency;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
import com.mymanager.data.models.User;

public class CreatePayments extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041425686102020001L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;

	private JComboBox comboBoxPaymentType;
	private DefaultComboBoxModel paymentTypeModel;

	private JComboBox comboBoxCurrency;
	private DefaultComboBoxModel currencyModel;

	private JTextField textFieldEmpId;
	private JButton okButton;
	private JButton cancelButton;

	private UserController userController;
	private User user;
	private JTextField textFieldAmount;
	private JTextArea textAreaDesc;

	public CreatePayments(UserController userController) {
		this.userController = userController;
		this.user = userController.getUser();
		selfReference = this;
		setResizable(false);
		initComponents();
		initEvents();
		fillComboBoxes();

	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 483);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCreateNewType = new JLabel("Create new payment :");
		lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCreateNewType.setBounds(129, 13, 270, 26);
		contentPanel.add(lblCreateNewType);

		JLabel lblPaymentType = new JLabel("Payment type :");
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentType.setBounds(12, 67, 114, 26);
		contentPanel.add(lblPaymentType);

		JLabel lblEmpId = new JLabel("Emp ID  :");
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpId.setBounds(12, 126, 81, 26);
		contentPanel.add(lblEmpId);

		JLabel lblCurrency = new JLabel("Currency :");
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrency.setBounds(12, 183, 93, 26);
		contentPanel.add(lblCurrency);

		comboBoxPaymentType = new JComboBox();
		comboBoxPaymentType.setBounds(118, 67, 270, 30);

		paymentTypeModel = new DefaultComboBoxModel();
		comboBoxPaymentType.setModel(paymentTypeModel);

		contentPanel.add(comboBoxPaymentType);

		textFieldEmpId = new JTextField();
		textFieldEmpId.setColumns(10);
		textFieldEmpId.setBounds(105, 125, 283, 30);
		contentPanel.add(textFieldEmpId);

		comboBoxCurrency = new JComboBox();
		comboBoxCurrency.setBounds(118, 183, 270, 30);

		currencyModel = new DefaultComboBoxModel();
		comboBoxCurrency.setModel(currencyModel);

		contentPanel.add(comboBoxCurrency);

		JLabel lblAmount = new JLabel("Amount  :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(12, 241, 81, 26);
		contentPanel.add(lblAmount);

		textFieldAmount = new JTextField();
		textFieldAmount.setToolTipText("eg : 12.234\r\n");
		textFieldAmount.setColumns(10);
		textFieldAmount.setBounds(105, 240, 283, 30);
		contentPanel.add(textFieldAmount);

		JLabel lblDescription = new JLabel("Description  :");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(12, 306, 93, 26);
		contentPanel.add(lblDescription);

		textAreaDesc = new JTextArea();
		textAreaDesc.setLineWrap(true);
		textAreaDesc.setToolTipText("eg : 12.234\r\n");
		textAreaDesc.setColumns(10);
		textAreaDesc.setBounds(105, 306, 283, 103);
		contentPanel.add(textAreaDesc);
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
				String selectedPaymentType = (String) comboBoxPaymentType.getSelectedItem();
				String selectedCurrency = (String) comboBoxCurrency.getSelectedItem();
				String amount = textFieldAmount.getText();
				String desc = textAreaDesc.getText();

				Payment newPayment = new Payment(1, new PaymentType(selectedPaymentType), textFieldEmpId.getText(),
						new Currency(selectedCurrency), Float.parseFloat(amount), desc, user.getUserId(),
						user.getUserId(), LocalDateTime.now(), LocalDateTime.now());

				userController.savePayment(newPayment);
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

	private void fillComboBoxes() {
		fillPaymentTypeComboBox();
		fillCurrencyComboBox();

	}

	private void fillPaymentTypeComboBox() {
		paymentTypeModel.removeAllElements();
		for (PaymentType paymentType : userController.getAllPaymentTypes()) {
			paymentTypeModel.addElement(paymentType.getPayment());
		}

	}

	private void fillCurrencyComboBox() {
		currencyModel.removeAllElements();
		for (Currency currency : userController.getAllCurrencies()) {
			currencyModel.addElement(currency.getCurrencyName());
		}

	}
}
