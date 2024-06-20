package io.mymanager.desktop.view.subviews.create;

import io.mymanager.desktop.data.models.Currency;
import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.CurrencyService;
import io.mymanager.desktop.service.EmployeeService;
import io.mymanager.desktop.service.PaymentService;
import io.mymanager.desktop.service.PaymentTypeService;
import io.mymanager.desktop.service.impl.CurrencyServiceImpl;
import io.mymanager.desktop.service.impl.EmployeeServiceImpl;
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

public class CreatePayments extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -4041425686102020001L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  // Service fields
  private final PaymentService paymentService;
  private final PaymentTypeService paymentTypeService;
  private final CurrencyService currencyService;
  private final EmployeeService employeeService;
  private final User user;
  private JPanel buttonPane;
  private JComboBox comboBoxPaymentType;
  private DefaultComboBoxModel<String> paymentTypeModel;
  private JComboBox comboBoxCurrency;
  private DefaultComboBoxModel<String> currencyModel;
  private JComboBox employeeComboBox;
  private DefaultComboBoxModel<String> employeeModel;
  private JButton btnSave;
  private JButton btnCancel;
  private JTextField textFieldAmount;
  private JTextArea textAreaDesc;

  public CreatePayments(PaymentService paymentService, User user) {
    this.selfReference = this;
    this.paymentService = paymentService;
    this.user = user;
    this.paymentTypeService = new PaymentTypeServiceImpl();
    this.currencyService = new CurrencyServiceImpl();
    this.employeeService = new EmployeeServiceImpl();

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

    JLabel lblEmpId = new JLabel("Emp Id  :");
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

    employeeComboBox = new JComboBox();
    employeeComboBox.setBounds(112, 125, 276, 30);

    employeeModel = new DefaultComboBoxModel();
    employeeComboBox.setModel(employeeModel);

    contentPanel.add(employeeComboBox);

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
    textFieldAmount.setText("0");
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

    buttonPane = new JPanel();
    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
    getContentPane().add(buttonPane, BorderLayout.SOUTH);

    btnSave = new JButton("Save");
    btnSave.setActionCommand("Save");
    buttonPane.add(btnSave);
    getRootPane().setDefaultButton(btnSave);

    btnCancel = new JButton("Cancel");
    btnCancel.setActionCommand("Cancel");
    buttonPane.add(btnCancel);

  }

  private void initEvents() {
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        String selectedPaymentType = (String) comboBoxPaymentType.getSelectedItem();
        String selectedCurrency = (String) comboBoxCurrency.getSelectedItem();
        String employeeId = (String) employeeComboBox.getSelectedItem();
        String amount = textFieldAmount.getText();
        String desc = textAreaDesc.getText();

        Payment newPayment = new Payment(1, new PaymentType(selectedPaymentType), employeeId,
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
    fillEmployeeComboBox();
    fillCurrencyComboBox();


  }

  private void fillEmployeeComboBox() {
    employeeModel.removeAllElements();
    List<String> employeeIdList = null;

    try {
      employeeIdList = employeeService.getAllEmployeeIds();
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (employeeIdList != null && employeeIdList.size() != 0) {
      for (String var : employeeIdList) {
        employeeModel.addElement(var);
      }
    }

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
