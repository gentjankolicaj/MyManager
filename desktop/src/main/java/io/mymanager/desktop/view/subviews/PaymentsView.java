package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.PaymentService;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.impl.PaymentServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreatePayments;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditPayments;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PaymentsView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 2586092764218526222L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  //Service fields
  private final UserService userService;
  private final PaymentService paymentService;
  private final User user;
  private JTextField textFieldSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnCreate;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnType;
  private JButton btnSearch;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnEmpId;
  private JRadioButton rdbtnDesc;
  private List<Payment> currentPaymentList;

  /**
   * Create the panel.
   */
  public PaymentsView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1200, 620);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userService = userService;
    this.user = user;
    this.paymentService = new PaymentServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);

    JLabel lblNewLabel = new JLabel("All employee payments");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(360, 13, 230, 35);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 913, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 48, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(83, 50, 56, 25);
    add(rdbtnId);

    rdbtnEmpId = new JRadioButton("Employee Id");
    buttonGroupSearchType.add(rdbtnEmpId);
    rdbtnEmpId.setBounds(141, 50, 95, 25);
    add(rdbtnEmpId);

    rdbtnType = new JRadioButton("Type");
    buttonGroupSearchType.add(rdbtnType);
    rdbtnType.setBounds(240, 50, 61, 25);
    add(rdbtnType);

    rdbtnDesc = new JRadioButton("Description");
    buttonGroupSearchType.add(rdbtnDesc);
    rdbtnDesc.setBounds(303, 50, 95, 25);
    add(rdbtnDesc);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(942, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 1068, 442);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"ID", "Type", "Emp ID", "Amount", "Currency", "Desc",
            "Created by", "Created date", "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);
    btnCreate = new JButton("Create");
    btnCreate.setBounds(1090, 140, 97, 25);
    add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setBounds(1090, 178, 97, 25);
    add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(1090, 216, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(1090, 300, 97, 25);
    add(btnBack);
  }

  private void initEvents() {
    btnSearch.addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        searchPayments();
      }
    });

    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreatePayments createPayment = new CreatePayments(paymentService, user);
        createPayment.setModal(true);
        createPayment.setVisible(true);

        loadData();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          Payment oldPayment = currentPaymentList.get(selectedRow);
          EditPayments editPayment = new EditPayments(paymentService, user, oldPayment);
          editPayment.setModal(true);
          editPayment.setVisible(true);

          loadData();
        }

      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if (selectedRow > -1 && selectedRow < totalRows) {
          Payment payment = currentPaymentList.get(selectedRow);
          try {

            paymentService.deletePayment(payment);

          } catch (Exception e1) {

            e1.printStackTrace();
          }

          loadData();
        }

      }
    });

    btnBack.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.returnToMainView(jframe, selfReference, mainView);
      }
    });

  }

  private void emptyTable() {
    currentPaymentList = new ArrayList<>();
    tableModel.setRowCount(0);
  }


  private void searchPayments() {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      Payment temp = null;
      try {

        temp = paymentService.getPayment(Integer.parseInt(searchValue));

      } catch (NumberFormatException n) {
        n.printStackTrace();
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (temp != null) {
        currentPaymentList.add(temp);
      }

      fillTable(currentPaymentList);
    } else if (rdbtnEmpId.isSelected()) {
      try {

        currentPaymentList = paymentService.getAllPaymentsByEmployeeId(searchValue);

      } catch (Exception e) {

        e.printStackTrace();
      }
      fillTable(currentPaymentList);
    } else if (rdbtnType.isSelected()) {
      try {

        currentPaymentList = paymentService.getAllPaymentsByPaymentType(
            new PaymentType(searchValue));

      } catch (Exception e) {

        e.printStackTrace();
      }
      fillTable(currentPaymentList);
    } else if (rdbtnDesc.isSelected()) {
      try {
        currentPaymentList = paymentService.getAllPaymentsByDescription(searchValue);
      } catch (Exception e) {

        e.printStackTrace();
      }
      fillTable(currentPaymentList);
    }
  }

  public void loadData() {
    emptyTable();
    try {

      currentPaymentList = paymentService.getAllPayments(Config.ROW_LIMIT, Config.PAYMENTS_OFFSET);

    } catch (Exception e) {

      e.printStackTrace();
    }
    if (currentPaymentList != null && currentPaymentList.size() != 0) {
      Object[] rowData = new Object[10];
      for (Payment payment : currentPaymentList) {
        rowData[0] = payment.getPaymentId();
        rowData[1] = payment.getPaymentType().getPayment();
        rowData[2] = payment.getEmployeeId();
        rowData[3] = payment.getPaymentAmount();
        rowData[4] = payment.getCurrency().getCurrencyName();
        rowData[5] = payment.getPaymentDescription();
        rowData[6] = payment.getCreatedBy();
        rowData[7] = payment.getCreatedDate();
        rowData[8] = payment.getUpdatedBy();
        rowData[9] = payment.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }


  private void fillTable(List<Payment> paymentsList) {
    if (paymentsList != null && paymentsList.size() != 0) {
      Object[] rowData = new Object[10];
      for (Payment payment : paymentsList) {
        rowData[0] = payment.getPaymentId();
        rowData[1] = payment.getPaymentType().getPayment();
        rowData[2] = payment.getEmployeeId();
        rowData[3] = payment.getPaymentAmount();
        rowData[4] = payment.getCurrency().getCurrencyName();
        rowData[5] = payment.getPaymentDescription();
        rowData[6] = payment.getCreatedBy();
        rowData[7] = payment.getCreatedDate();
        rowData[8] = payment.getUpdatedBy();
        rowData[9] = payment.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }
}
