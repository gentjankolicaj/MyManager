package io.mymanager.desktop.view.subviews.user;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.UserContact;
import io.mymanager.desktop.service.UserContactService;
import io.mymanager.desktop.service.impl.UserContactServiceImpl;
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
public class UserContactView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 2586092764218526222L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // Service fields
  private final UserContactService userContactService;
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
  private List<UserContact> currentContactList;

  /**
   * Create the panel.
   */
  public UserContactView(JFrame jframe, MainView mainView) {
    super(1200, 600);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userContactService = new UserContactServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);

    JLabel lblNewLabel = new JLabel("All user contacts");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(455, 11, 230, 31);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 913, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblSearcchBy.setBounds(12, 43, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(83, 46, 56, 25);
    add(rdbtnId);

    rdbtnPersonId = new JRadioButton("User Id");
    buttonGroupSearchType.add(rdbtnPersonId);
    rdbtnPersonId.setBounds(141, 46, 81, 25);
    add(rdbtnPersonId);

    rdbtnCelular = new JRadioButton("Cel");
    buttonGroupSearchType.add(rdbtnCelular);
    rdbtnCelular.setBounds(229, 46, 56, 25);
    add(rdbtnCelular);

    rdbtnEmail = new JRadioButton("Email");
    buttonGroupSearchType.add(rdbtnEmail);
    rdbtnEmail.setBounds(293, 46, 81, 25);
    add(rdbtnEmail);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(935, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 1068, 463);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "User Id", "Telephone", "Celular", "Email", "Fax",
            "Created by", "Created date", "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(1088, 142, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(1088, 178, 97, 25);
    add(btnBack);
  }

  private void initEvents() {
    btnSearch.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {

        try {

          searchContacts();

        } catch (Exception e1) {

          e1.printStackTrace();

        }

      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          UserContact contactToDelete = currentContactList.get(selectedRow);

          try {

            userContactService.deleteContact(contactToDelete);

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

  private void searchContacts() throws Exception {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      UserContact temp = userContactService.getContact(Integer.parseInt(searchValue));
      currentContactList.add(temp);
      fillTable(currentContactList);
    } else if (rdbtnPersonId.isSelected()) {
      UserContact temp = userContactService.getContactByPersonId(searchValue);
      currentContactList.add(temp);
      fillTable(currentContactList);
    } else if (rdbtnCelular.isSelected()) {
      currentContactList = userContactService.getContactsByCelular(Integer.parseInt(searchValue));
      fillTable(currentContactList);

    } else if (rdbtnEmail.isSelected()) {
      currentContactList = userContactService.getContactsByEmail(searchValue);
      fillTable(currentContactList);

    } else {

      // to do some info message

    }

  }

  private void emptyTable() {
    currentContactList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<UserContact> contactsList) {
    if (contactsList != null && contactsList.size() != 0) {
      Object[] rowData = new Object[10];
      for (UserContact contact : contactsList) {
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

      currentContactList = userContactService.getAllContacts(Config.ROW_LIMIT, Config.USER_OFFSET);

    } catch (Exception e) {

      e.printStackTrace();

    }

    if (currentContactList != null && currentContactList.size() != 0) {
      Object[] rowData = new Object[10];
      for (UserContact contact : currentContactList) {
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
