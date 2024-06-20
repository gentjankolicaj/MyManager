package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.Currency;
import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.CurrencyService;
import io.mymanager.desktop.service.PaymentService;
import io.mymanager.desktop.service.PaymentTypeService;
import io.mymanager.desktop.service.impl.CurrencyServiceImpl;
import io.mymanager.desktop.service.impl.PaymentTypeServiceImpl;
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

public class EditPayments extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7073986236252726976L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  // Service fields
  private final PaymentService paymentService;
  private final PaymentTypeService paymentTypeService;
  private final CurrencyService currencyService;
  private final User user;
  private final Payment oldPayment;
  private JPanel buttonPane;
  private JButton btnSave;
  private JButton btnCancel;
  private JTextField textFieldEmpId;
  private JTextField textFieldAmount;
  private JTextField textFieldCreatedBy;
  private JTextArea textAreaDesc;
  private JComboBox comboBoxPaymentType;
  private DefaultComboBoxModel<String> paymentTypeModel;
  private JComboBox comboBoxCurrency;
  private DefaultComboBoxModel<String> currencyModel;

  /**
   * Create the dialog.
   */
  public EditPayments(PaymentService paymentService, User user, Payment oldPayment) {
    this.selfReference = this;
    this.paymentService = paymentService;
    this.user = user;
    this.oldPayment = oldPayment;
    this.paymentTypeService = new PaymentTypeServiceImpl();
    this.currencyService = new CurrencyServiceImpl();

    initComponents();
    initEvents();

    fillComboBoxes();
    fillDetails();

  }

  private void initComponents() {
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 560, 486);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblEditExistingJob = new JLabel("Edit existing payment :");
      lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
      lblEditExistingJob.setBounds(129, 13, 270, 26);
      contentPanel.add(lblEditExistingJob);
    }

    JLabel lblPaymentType = new JLabel("Type :");
    lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblPaymentType.setBounds(35, 50, 58, 26);
    contentPanel.add(lblPaymentType);

    comboBoxPaymentType = new JComboBox();
    comboBoxPaymentType.setBounds(103, 50, 296, 30);

    paymentTypeModel = new DefaultComboBoxModel();
    comboBoxPaymentType.setModel(paymentTypeModel);

    contentPanel.add(comboBoxPaymentType);

    JLabel lblEmpId = new JLabel("Emp Id  :");
    lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblEmpId.setBounds(16, 101, 75, 26);
    contentPanel.add(lblEmpId);

    textFieldEmpId = new JTextField();
    textFieldEmpId.setColumns(10);
    textFieldEmpId.setBounds(103, 101, 296, 30);
    contentPanel.add(textFieldEmpId);

    JLabel lblCurrency = new JLabel("Currency :");
    lblCurrency.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCurrency.setBounds(10, 153, 81, 26);
    contentPanel.add(lblCurrency);

    comboBoxCurrency = new JComboBox();
    comboBoxCurrency.setBounds(103, 153, 296, 30);

    currencyModel = new DefaultComboBoxModel();
    comboBoxCurrency.setModel(currencyModel);

    contentPanel.add(comboBoxCurrency);

    JLabel lblAmount = new JLabel("Amount  :");
    lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblAmount.setBounds(16, 204, 75, 26);
    contentPanel.add(lblAmount);

    textFieldAmount = new JTextField();
    textFieldAmount.setToolTipText("eg : 12.234\r\n");
    textFieldAmount.setColumns(10);
    textFieldAmount.setBounds(103, 204, 296, 30);
    contentPanel.add(textFieldAmount);

    JLabel lblDesc = new JLabel("Description  :");
    lblDesc.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblDesc.setBounds(10, 312, 93, 26);
    contentPanel.add(lblDesc);

    textAreaDesc = new JTextArea();
    textAreaDesc.setToolTipText("eg : 12.234\r\n");
    textAreaDesc.setLineWrap(true);
    textAreaDesc.setColumns(10);
    textAreaDesc.setBounds(103, 312, 296, 103);
    contentPanel.add(textAreaDesc);

    textFieldCreatedBy = new JTextField();
    textFieldCreatedBy.setToolTipText("eg : 12.234\r\n");
    textFieldCreatedBy.setColumns(10);
    textFieldCreatedBy.setBounds(103, 261, 296, 30);
    contentPanel.add(textFieldCreatedBy);

    JLabel lblCreatedBy = new JLabel("Created by :");
    lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblCreatedBy.setBounds(10, 262, 93, 26);
    contentPanel.add(lblCreatedBy);
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

        float amount = Float.parseFloat(textFieldAmount.getText());
        PaymentType newPaymentType = new PaymentType(
            (String) comboBoxPaymentType.getSelectedItem());
        Currency newCurrency = new Currency((String) comboBoxCurrency.getSelectedItem());

        Payment newPayment = new Payment(oldPayment.getPaymentId(), newPaymentType,
            textFieldEmpId.getText(),
            newCurrency, amount, textAreaDesc.getText(), textFieldCreatedBy.getText(),
            user.getUserId(),
            LocalDateTime.now(), LocalDateTime.now());

        try {

          paymentService.updatePayment(oldPayment, newPayment);

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
    if (paymentTypeModel.getSize() > 0) {
      paymentTypeModel.removeAllElements();
    }

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
    if (currencyModel.getSize() > 0) {
      currencyModel.removeAllElements();
    }

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

  private void fillDetails() {
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
