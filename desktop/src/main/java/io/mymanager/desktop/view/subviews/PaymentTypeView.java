package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.PaymentTypeService;
import io.mymanager.desktop.service.impl.PaymentTypeServiceImpl;
import io.mymanager.desktop.view.subviews.create.CreatePaymentType;
import io.mymanager.desktop.view.subviews.edit.EditPaymentType;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class PaymentTypeView extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 2492766874229689500L;
  private final JPanel contentPanel = new JPanel();
  // Service field
  private final PaymentTypeService paymentTypeService;
  private JButton btnDelete;
  private JButton btnEdit;
  private JButton btnCreate;
  private DefaultTableModel tableModel;
  private List<PaymentType> paymentTypeList;
  private MyTable table;
  private JScrollPane scrollPane;

  /**
   * Create the dialog.
   */
  public PaymentTypeView() {
    setTitle("ALL TYPES OF PAYMENT");
    this.paymentTypeService = new PaymentTypeServiceImpl();

    initComponents();
    initEvents();

    updateTable();
  }

  public void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-save-money.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 420, 380);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Create");

    btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-add-2.png"));
    btnCreate.setBounds(10, 22, 108, 23);
    contentPanel.add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-edit-3.png"));
    btnEdit.setBounds(10, 67, 108, 23);
    contentPanel.add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-minus-2.png"));
    btnDelete.setBounds(10, 115, 108, 23);
    contentPanel.add(btnDelete);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(128, 25, 266, 306);

    table = new MyTable();
    table.setCellSelectionEnabled(true);
    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(new String[]{"Type of payment"});
    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    contentPanel.add(scrollPane);
  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreatePaymentType createPaymentType = new CreatePaymentType(paymentTypeService);
        createPaymentType.setModal(true);
        createPaymentType.setVisible(true);

        updateTable();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        PaymentType oldPaymentType = paymentTypeList.get(index);
        EditPaymentType editPaymentType = new EditPaymentType(paymentTypeService, oldPaymentType);
        editPaymentType.setModal(true);
        editPaymentType.setVisible(true);

        updateTable();
      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        String paymentType = (String) tableModel.getValueAt(index, 0);
        try {
          paymentTypeService.deletePaymentType(new PaymentType(paymentType));
        } catch (Exception e1) {

          e1.printStackTrace();
        }

        updateTable();
      }
    });

  }

  public void updateTable() {
    emptyTable();
    try {
      paymentTypeList = paymentTypeService.getAllPaymentTypes();
    } catch (Exception e) {

      e.printStackTrace();
    }
    if (paymentTypeList != null && paymentTypeList.size() != 0) {
      Object[] obj = new Object[1];
      for (PaymentType paymentType : paymentTypeList) {
        obj[0] = paymentType.getPayment();
        tableModel.addRow(obj);
      }
    }
  }

  private void emptyTable() {
    tableModel.setRowCount(0);
  }
}
