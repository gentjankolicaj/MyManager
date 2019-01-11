package com.mymanager.desktop.views.subviews.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;

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

import com.mymanager.data.models.Currency;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
import com.mymanager.data.models.User;
import com.mymanager.services.CurrencyService;
import com.mymanager.services.CurrencyServiceImpl;
import com.mymanager.services.PaymentService;
import com.mymanager.services.PaymentTypeService;
import com.mymanager.services.PaymentTypeServiceImpl;

public class CreatePayments extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041425686102020001L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;

	private JComboBox comboBoxPaymentType;
	private DefaultComboBoxModel<String> paymentTypeModel;

	private JComboBox comboBoxCurrency;
	private DefaultComboBoxModel<String> currencyModel;

	private JTextField textFieldEmpId;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField textFieldAmount;
	private JTextArea textAreaDesc;

	// Service fields
	private PaymentService paymentService;
	private PaymentTypeService paymentTypeService;
	private CurrencyService currencyService;
	private User user;

	public CreatePayments(PaymentService paymentService,User user) {
		this.selfReference = this;
		this.paymentService = paymentService;
		this.user = user;
		this.paymentTypeService = new PaymentTypeServiceImpl();
		this.currencyService = new CurrencyServiceImpl();

		setResizable(false);

		initComponents();
		initEvents();
		fillComboBoxes();

	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 483);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCreateNewType = new JLabel("Create new payment :");
		lblCreateNewType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCreateNewType.setBounds(129, 13, 270, 26);
		contentPanel.add(lblCreateNewType);

		JLabel lblPaymentType = new JLabel("Type :");
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentType.setBounds(51, 67, 53, 26);
		contentPanel.add(lblPaymentType);

		JLabel lblEmpId = new JLabel("Emp ID  :");
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpId.setBounds(30, 125, 74, 26);
		contentPanel.add(lblEmpId);

		JLabel lblCurrency = new JLabel("Currency :");
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrency.setBounds(23, 183, 81, 26);
		contentPanel.add(lblCurrency);

		comboBoxPaymentType = new JComboBox();
		comboBoxPaymentType.setBounds(112, 67, 276, 30);

		paymentTypeModel = new DefaultComboBoxModel();
		comboBoxPaymentType.setModel(paymentTypeModel);

		contentPanel.add(comboBoxPaymentType);

		textFieldEmpId = new JTextField();
		textFieldEmpId.setColumns(10);
		textFieldEmpId.setBounds(112, 125, 276, 30);
		contentPanel.add(textFieldEmpId);

		comboBoxCurrency = new JComboBox();
		comboBoxCurrency.setBounds(112, 183, 276, 30);

		currencyModel = new DefaultComboBoxModel();
		comboBoxCurrency.setModel(currencyModel);

		contentPanel.add(comboBoxCurrency);

		JLabel lblAmount = new JLabel("Amount  :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(23, 240, 81, 26);
		contentPanel.add(lblAmount);

		textFieldAmount = new JTextField();
		textFieldAmount.setToolTipText("eg : 12.234\r\n");
		textFieldAmount.setColumns(10);
		textFieldAmount.setBounds(112, 240, 276, 30);
		contentPanel.add(textFieldAmount);

		JLabel lblDescription = new JLabel("Description  :");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(12, 306, 93, 26);
		contentPanel.add(lblDescription);

		textAreaDesc = new JTextArea();
		textAreaDesc.setLineWrap(true);
		textAreaDesc.setToolTipText("eg : 12.234\r\n");
		textAreaDesc.setColumns(10);
		textAreaDesc.setBounds(105, 312, 283, 97);
		contentPanel.add(textAreaDesc);
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSave = new JButton("Save");
				btnSave.setActionCommand("Save");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	private void initEvents() {
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String selectedPaymentType = (String) comboBoxPaymentType.getSelectedItem();
				String selectedCurrency = (String) comboBoxCurrency.getSelectedItem();
				String amount = textFieldAmount.getText();
				String desc = textAreaDesc.getText();

				Payment newPayment = new Payment(1, new PaymentType(selectedPaymentType), textFieldEmpId.getText(),
						new Currency(selectedCurrency), Float.parseFloat(amount), desc, user.getUserId(),
						user.getUserId(), LocalDateTime.now(), LocalDateTime.now());

				try {

					paymentService.savePayment(newPayment);

				} catch (Exception e1) {

					e1.printStackTrace();
				}

				selfReference.dispose();
			}
		});

		btnCancel.addMouseListener(new MouseAdapter() {
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
		List<PaymentType> paymentTypeList = null;

		try {
			
			paymentTypeList = paymentTypeService.getAllPaymentTypes();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (paymentTypeList != null && paymentTypeList.size() != 0) {
			for (PaymentType paymentType : paymentTypeList) {
				paymentTypeModel.addElement(paymentType.getPayment());
			}

		}
	}

	private void fillCurrencyComboBox() {
		currencyModel.removeAllElements();
		List<Currency> currenciesList = null;
		try {
			
			currenciesList = currencyService.getAllCurrencies();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (currenciesList != null && currenciesList.size() != 0) {
			for (Currency currency : currenciesList) {
				currencyModel.addElement(currency.getCurrencyName());
			}

		}
	}
}
