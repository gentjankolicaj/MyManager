package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.CountryService;
import io.mymanager.desktop.service.impl.CountryServiceImpl;
import io.mymanager.desktop.view.subviews.create.CreateCountry;
import io.mymanager.desktop.view.subviews.edit.EditCountry;
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

public class CountryView extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 4893837498170262245L;
  private final JPanel contentPanel = new JPanel();
  private final CountryService countryService;
  private JButton btnDelete;
  private JButton btnEdit;
  private JButton btnCreate;
  private DefaultTableModel tableModel;
  private List<Country> countryList;
  private MyTable table;
  private JScrollPane scrollPane;

  /**
   * Create the dialog.
   */
  public CountryView() {
    setTitle("ALL COUNTRIES");
    this.countryService = new CountryServiceImpl();

    initComponents();
    initEvents();

    updateTable();
  }

  public void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-country.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 420, 380);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Create");

    btnCreate.setIcon(IconUtils.getIcon("icons_24x24/icons8-add-2.png"));
    btnCreate.setBounds(10, 26, 108, 23);
    contentPanel.add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-edit-3.png"));
    btnEdit.setBounds(10, 71, 108, 23);
    contentPanel.add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-minus-2.png"));
    btnDelete.setBounds(10, 119, 108, 23);
    contentPanel.add(btnDelete);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(128, 26, 264, 306);

    table = new MyTable();
    table.setCellSelectionEnabled(true);
    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(new String[]{"Country"});
    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    contentPanel.add(scrollPane);
  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateCountry createCountry = new CreateCountry(countryService);
        createCountry.setModal(true);
        createCountry.setVisible(true);

        updateTable();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        Country oldCountry = countryList.get(index);
        EditCountry editCountry = new EditCountry(countryService, oldCountry);
        editCountry.setModal(true);
        editCountry.setVisible(true);
        updateTable();
      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        String country = (String) tableModel.getValueAt(index, 0);
        try {

          countryService.deleteCountry(new Country(country));

        } catch (Exception e1) {

          e1.printStackTrace();

        }

        updateTable();
      }
    });

  }

  private void updateTable() {
    emptyTable();

    try {
      countryList = countryService.getAllCountries();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (countryList != null && countryList.size() != 0) {
      Object[] obj = new Object[1];
      for (Country country : countryList) {
        obj[0] = country.getCountryName();
        tableModel.addRow(obj);
      }
    }
  }

  private void emptyTable() {
    tableModel.setRowCount(0);
  }
}
