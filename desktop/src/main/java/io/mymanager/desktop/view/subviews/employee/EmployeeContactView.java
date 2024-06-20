package io.mymanager.desktop.view.subviews.employee;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.EmployeeContact;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.EmployeeContactService;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
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

/**
 * @author gentjan kolicaj
 */
public class EmployeeContactView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 2586092764218526222L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // Service fields
  private final EmployeeContactService employeeContactService;
  private final User user;
  private JTextField textFieldSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnEmail;
  private JButton btnSearch;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnPersonId;
  private JRadioButton rdbtnCelular;
  private List<EmployeeContact> currentContactList;

  /**
   * Create the panel.
   */
  public EmployeeContactView(JFrame jframe, MainView mainView, User user,
      EmployeeContactService employeeContactService) {
    super(1300, 600);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.user = user;
    this.employeeContactService = employeeContactService;

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);

    JLabel lblNewLabel = new JLabel("Employee contacts");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(455, 11, 230, 31);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 1023, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblSearcchBy.setBounds(12, 43, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(81, 46, 56, 25);
    add(rdbtnId);

    rdbtnPersonId = new JRadioButton("User Id");
    buttonGroupSearchType.add(rdbtnPersonId);
    rdbtnPersonId.setBounds(139, 46, 81, 25);
    add(rdbtnPersonId);

    rdbtnCelular = new JRadioButton("Cel");
    buttonGroupSearchType.add(rdbtnCelular);
    rdbtnCelular.setBounds(227, 46, 56, 25);
    add(rdbtnCelular);

    rdbtnEmail = new JRadioButton("Email");
    buttonGroupSearchType.add(rdbtnEmail);
    rdbtnEmail.setBounds(291, 46, 81, 25);
    add(rdbtnEmail);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(1045, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 1171, 462);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "Employee Id", "Telephone", "Celular", "Email", "Fax",
            "Created by", "Created date", "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(1191, 143, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(1191, 179, 97, 25);
    add(btnBack);
  }

  private void initEvents() {
    btnSearch.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {

        searchContacts();


      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          EmployeeContact contactToDelete = currentContactList.get(selectedRow);

          try {

            employeeContactService.deleteContact(contactToDelete);

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

  private void searchContacts() {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      EmployeeContact tmp = null;
      try {
        tmp = employeeContactService.getContact(Integer.parseInt(searchValue));
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (tmp != null) {
        currentContactList.add(tmp);
      }
      fillTable(currentContactList);
    } else if (rdbtnPersonId.isSelected()) {
      EmployeeContact tmp = null;
      try {
        tmp = employeeContactService.getContact(Integer.parseInt(searchValue));
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (tmp != null) {
        currentContactList.add(tmp);
      }
      fillTable(currentContactList);
    } else if (rdbtnCelular.isSelected()) {
      try {

        currentContactList = employeeContactService.getContactsByCelular(
            Integer.parseInt(searchValue));

      } catch (NumberFormatException e) {

        e.printStackTrace();
      } catch (Exception e) {

        e.printStackTrace();
      }
      fillTable(currentContactList);

    } else if (rdbtnEmail.isSelected()) {
      try {

        currentContactList = employeeContactService.getContactsByEmail(searchValue);

      } catch (Exception e) {

        e.printStackTrace();
      }

      fillTable(currentContactList);

    }

  }

  private void emptyTable() {
    currentContactList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<EmployeeContact> contactsList) {
    if (contactsList != null && contactsList.size() != 0) {
      Object[] rowData = new Object[10];
      for (EmployeeContact contact : contactsList) {
        rowData[0] = contact.getContactId();
        rowData[1] = contact.getPersonId();
        rowData[2] = contact.getTelephone();
        rowData[3] = contact.getCelular();
        rowData[4] = contact.getEmail();
        rowData[5] = contact.getFax();
        rowData[6] = contact.getCreatedBy();
        rowData[7] = contact.getCreatedDate();
        rowData[8] = contact.getUpdatedBy();
        rowData[9] = contact.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {

    emptyTable();

    try {

      currentContactList = employeeContactService.getAllContacts(Config.ROW_LIMIT,
          Config.EMPLOYEE_CONTACT_OFFSET);

    } catch (Exception e) {

      e.printStackTrace();

    }

    if (currentContactList != null && currentContactList.size() != 0) {
      Object[] rowData = new Object[10];
      for (EmployeeContact contact : currentContactList) {
        rowData[0] = contact.getContactId();
        rowData[1] = contact.getPersonId();
        rowData[2] = contact.getTelephone();
        rowData[3] = contact.getCelular();
        rowData[4] = contact.getEmail();
        rowData[5] = contact.getFax();
        rowData[6] = contact.getCreatedBy();
        rowData[7] = contact.getCreatedDate();
        rowData[8] = contact.getUpdatedBy();
        rowData[9] = contact.getUpdatedDate();
        tableModel.addRow(rowData);
      }

    }
  }
}
