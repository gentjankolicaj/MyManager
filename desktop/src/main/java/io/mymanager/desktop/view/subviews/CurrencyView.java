package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.data.models.Currency;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.CurrencyService;
import io.mymanager.desktop.service.impl.CurrencyServiceImpl;
import io.mymanager.desktop.view.subviews.create.CreateCurrency;
import io.mymanager.desktop.view.subviews.edit.EditCurrency;
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

public class CurrencyView extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -2868031185429310600L;
  private final JPanel contentPanel = new JPanel();
  // Service field
  private final CurrencyService currencyService;
  private JButton btnDelete;
  private JButton btnEdit;
  private JButton btnCreate;
  private DefaultTableModel tableModel;
  private List<Currency> currencyList;
  private MyTable table;
  private JScrollPane scrollPane;

  /**
   * Create the dialog.
   */
  public CurrencyView() {
    setTitle("ALL CURRENCIES");
    this.currencyService = new CurrencyServiceImpl();

    initComponents();
    initEvents();

    updateTable();
  }

  public void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-sack-of-money-2.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 420, 380);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Create");

    btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-add-2.png"));
    btnCreate.setBounds(10, 23, 108, 23);
    contentPanel.add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-edit-3.png"));
    btnEdit.setBounds(10, 68, 108, 23);
    contentPanel.add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-minus-2.png"));
    btnDelete.setBounds(10, 116, 108, 23);
    contentPanel.add(btnDelete);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(128, 23, 266, 306);

    table = new MyTable();
    table.setCellSelectionEnabled(true);
    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(new String[]{"Currency"});
    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    contentPanel.add(scrollPane);
  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateCurrency createCurrency = new CreateCurrency(currencyService);
        createCurrency.setModal(true);
        createCurrency.setVisible(true);

        updateTable();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        Currency oldCurrency = currencyList.get(index);

        EditCurrency editCurrency = new EditCurrency(currencyService, oldCurrency);
        editCurrency.setModal(true);
        editCurrency.setVisible(true);

        updateTable();
      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        String currency = (String) tableModel.getValueAt(index, 0);

        try {
          currencyService.deleteCurrency(new Currency(currency));
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        updateTable();
      }
    });

  }

  public void updateTable() {
    emptyTable();
    try {
      currencyList = currencyService.getAllCurrencies();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (currencyList != null && currencyList.size() != 0) {
      Object[] obj = new Object[1];
      for (Currency currency : currencyList) {
        obj[0] = currency.getCurrencyName();
        tableModel.addRow(obj);
      }
    }
  }

  private void emptyTable() {
    tableModel.setRowCount(0);
  }
}
