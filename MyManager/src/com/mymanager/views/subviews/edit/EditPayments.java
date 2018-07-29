package com.mymanager.views.subviews.edit;

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

public class EditPayments extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073986236252726976L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;

	private JTextField textFieldPaymentId;
	private JTextField textFieldEmpId;
	private JTextField textFieldAmount;
	private JTextField textFieldCreatedBy;
	private JTextArea textAreaDesc;
	private JComboBox comboBoxPaymentType;
	private DefaultComboBoxModel<String> paymentTypeModel;

	private JComboBox comboBoxCurrency;
	private DefaultComboBoxModel<String> currencyModel;

	private UserController userController;
	private User user;
	private Payment oldPayment;

	/**
	 * Create the dialog.
	 */
	public EditPayments(UserController userController, Payment oldPayment) {
		this.userController = userController;
		this.user = userController.getUser();
		this.oldPayment = oldPayment;
		selfReference = this;

		initComponents();
		initEvents();
		fillComboBoxes();
		fillDetails();

	}

	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 550);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEditExistingJob = new JLabel("Edit existing job :");
			lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblEditExistingJob.setBounds(129, 13, 270, 26);
			contentPanel.add(lblEditExistingJob);
		}
		{
			JLabel lblPaymentId = new JLabel("Job Id :");
			lblPaymentId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPaymentId.setBounds(12, 51, 81, 26);
			contentPanel.add(lblPaymentId);
		}
		{
			textFieldPaymentId = new JTextField();
			textFieldPaymentId.setColumns(10);
			textFieldPaymentId.setBounds(105, 50, 326, 30);
			contentPanel.add(textFieldPaymentId);
		}

		JLabel lblPaymentType = new JLabel("Payment type :");
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentType.setBounds(12, 98, 114, 26);
		contentPanel.add(lblPaymentType);

		comboBoxPaymentType = new JComboBox();
		comboBoxPaymentType.setBounds(136, 98, 295, 30);

		paymentTypeModel = new DefaultComboBoxModel();
		comboBoxPaymentType.setModel(paymentTypeModel);

		contentPanel.add(comboBoxPaymentType);

		JLabel lblEmpId = new JLabel("Emp ID  :");
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpId.setBounds(12, 150, 81, 26);
		contentPanel.add(lblEmpId);

		textFieldEmpId = new JTextField();
		textFieldEmpId.setColumns(10);
		textFieldEmpId.setBounds(105, 149, 326, 30);
		contentPanel.add(textFieldEmpId);

		JLabel lblCurrency = new JLabel("Currency :");
		lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrency.setBounds(12, 202, 93, 26);
		contentPanel.add(lblCurrency);

		comboBoxCurrency = new JComboBox();
		comboBoxCurrency.setBounds(135, 201, 296, 30);

		currencyModel = new DefaultComboBoxModel();
		comboBoxCurrency.setModel(currencyModel);

		contentPanel.add(comboBoxCurrency);

		JLabel lblAmount = new JLabel("Amount  :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(12, 253, 81, 26);
		contentPanel.add(lblAmount);

		textFieldAmount = new JTextField();
		textFieldAmount.setToolTipText("eg : 12.234\r\n");
		textFieldAmount.setColumns(10);
		textFieldAmount.setBounds(105, 252, 326, 30);
		contentPanel.add(textFieldAmount);

		JLabel lblDesc = new JLabel("Description  :");
		lblDesc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesc.setBounds(12, 360, 93, 26);
		contentPanel.add(lblDesc);

		textAreaDesc = new JTextArea();
		textAreaDesc.setToolTipText("eg : 12.234\r\n");
		textAreaDesc.setLineWrap(true);
		textAreaDesc.setColumns(10);
		textAreaDesc.setBounds(105, 360, 326, 103);
		contentPanel.add(textAreaDesc);

		textFieldCreatedBy = new JTextField();
		textFieldCreatedBy.setToolTipText("eg : 12.234\r\n");
		textFieldCreatedBy.setColumns(10);
		textFieldCreatedBy.setBounds(105, 309, 326, 30);
		contentPanel.add(textFieldCreatedBy);

		JLabel lblCreatedBy = new JLabel("Created by :");
		lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreatedBy.setBounds(12, 310, 93, 26);
		contentPanel.add(lblCreatedBy);
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
				int newPaymentId = Integer.parseInt(textFieldPaymentId.getText());
				float amount = Float.parseFloat(textFieldAmount.getText());

				PaymentType newPaymentType = new PaymentType((String) comboBoxPaymentType.getSelectedItem());
				Currency newCurrency = new Currency((String) comboBoxCurrency.getSelectedItem());

				Payment newPayment = new Payment(newPaymentId, newPaymentType, textFieldEmpId.getText(), newCurrency,
						amount, textAreaDesc.getText(), textFieldCreatedBy.getText(), user.getUserId(),
						LocalDateTime.now(), LocalDateTime.now());

				userController.editPayment(oldPayment, newPayment);
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
		if (paymentTypeModel.getSize() > 0)
			paymentTypeModel.removeAllElements();
		for (PaymentType paymentType : userController.getAllPaymentTypes()) {
			paymentTypeModel.addElement(paymentType.getPayment());
		}

	}

	private void fillCurrencyComboBox() {
		if (currencyModel.getSize() > 0)
			currencyModel.removeAllElements();
		for (Currency currency : userController.getAllCurrencies()) {
			currencyModel.addElement(currency.getCurrencyName());
		}

	}

	private void fillDetails() {
		textFieldPaymentId.setText(String.valueOf(oldPayment.getPaymentId()));
		textFieldEmpId.setText(oldPayment.getEmployeeId());
		textFieldAmount.setText(String.valueOf(oldPayment.getPaymentAmount()));
		textFieldCreatedBy.setText(oldPayment.getCreatedBy());
		textAreaDesc.setText(oldPayment.getPaymentDescription());
		selectComboBoxElements();

	}

	private void selectComboBoxElements() {
		PaymentType currentPaymentType = oldPayment.getPaymentType();
		Currency paymentCurrency = oldPayment.getCurrency();

		comboBoxPaymentType.setSelectedItem(currentPaymentType);
		comboBoxCurrency.setSelectedItem(paymentCurrency.getCurrencyName());
	}
}
