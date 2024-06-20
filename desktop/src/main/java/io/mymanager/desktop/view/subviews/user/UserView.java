package io.mymanager.desktop.view.subviews.user;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.data.models.UserAdress;
import io.mymanager.desktop.data.models.UserContact;
import io.mymanager.desktop.service.UserAdressService;
import io.mymanager.desktop.service.UserContactService;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.impl.UserAdressServiceImpl;
import io.mymanager.desktop.service.impl.UserContactServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreateUser;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditUser;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author gentjan kolicaj
 */
public class UserView extends MyPanel {

  private static final long serialVersionUID = 2586092764218526222L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // ================================================================
  // Field services
  private final UserService userService;
  private final User user;
  private final UserContactService userContactService;
  private final UserAdressService userAdressService;
  private JTextField textFieldSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnCreate;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnFirstname;
  private JButton btnSearch;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnType;
  private JRadioButton rdbtnLastname;
  private List<User> currentUserList;

  /**
   * Create the panel.
   */
  public UserView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1200, 600);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;
    this.userService = userService;
    this.user = user;
    this.userContactService = new UserContactServiceImpl();
    this.userAdressService = new UserAdressServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);

    JLabel lblNewLabel = new JLabel("All registered users");
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

    rdbtnType = new JRadioButton("User type");
    buttonGroupSearchType.add(rdbtnType);
    rdbtnType.setBounds(141, 46, 95, 25);
    add(rdbtnType);

    rdbtnFirstname = new JRadioButton("Firstname");
    buttonGroupSearchType.add(rdbtnFirstname);
    rdbtnFirstname.setBounds(240, 46, 90, 25);
    add(rdbtnFirstname);

    rdbtnLastname = new JRadioButton("Lastname");
    buttonGroupSearchType.add(rdbtnLastname);
    rdbtnLastname.setBounds(332, 46, 89, 25);
    add(rdbtnLastname);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(935, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 1068, 463);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "User type", "Firstname", "Lastname", "Birthday",
            "Birthplace", "Rights", "Gender", "Created by", "Created date", "Updated by",
            "Updated date"});

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
      @Override
      public void mouseReleased(MouseEvent e) {
        try {
          searchUsers();
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

      }
    });

    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateUser createUser = new CreateUser(userService, userContactService, userAdressService,
            user);
        createUser.setModal(true);
        createUser.setVisible(true);
        loadData();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          User oldUser = currentUserList.get(selectedRow);

          UserContact oldContact = null;
          UserAdress oldAdress = null;
          try {
            oldContact = userContactService.getContactByPersonId(oldUser.getUserId());
            oldAdress = userAdressService.getAdressesByPersonId(oldUser.getUserId());
          } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }

          EditUser editUser = new EditUser(userService, userContactService, userAdressService, user,
              oldUser,
              oldContact, oldAdress);
          editUser.setModal(true);
          editUser.setVisible(true);
          loadData();
        }
      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          User userToDelete = currentUserList.get(selectedRow);
          int value = JOptionPane.showConfirmDialog(null,
              "If you delete the user,you are also going to delete its address,contacts etc...",
              "Do you want to proceed ?", JOptionPane.YES_NO_OPTION);
          if (value == 0) {

            try {
              UserAdress userAdress = userAdressService.getAdressesByPersonId(
                  userToDelete.getUserId());
              UserContact userContact = userContactService.getContactByPersonId(
                  userToDelete.getUserId());

              if (userAdress != null) {
                userAdressService.deleteAdress(userAdress);
              }
              if (userContact != null) {
                userContactService.deleteContact(userContact);
              }

              userService.deleteUser(userToDelete);
            } catch (Exception e1) {

              e1.printStackTrace();
            }
            loadData();
          }
        } else {
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

  private void searchUsers() throws Exception {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      User temp = userService.getUser(searchValue);
      currentUserList.add(temp);
      fillTable(currentUserList);

    } else if (rdbtnType.isSelected()) {
      currentUserList = userService.getUsersByUserType(searchValue);
      fillTable(currentUserList);

    } else if (rdbtnFirstname.isSelected()) {
      currentUserList = userService.getUsersByFirstName(searchValue);
      fillTable(currentUserList);

    } else if (rdbtnLastname.isSelected()) {
      currentUserList = userService.getUsersByLastName(searchValue);
      fillTable(currentUserList);

    }

  }

  private void emptyTable() {
    currentUserList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<User> usersList) {
    if (usersList != null && usersList.size() != 0) {
      Object[] rowData = new Object[12];
      for (User user : usersList) {
        rowData[0] = user.getUserId();
        rowData[1] = user.getUserType();
        rowData[2] = user.getFirstName();
        rowData[3] = user.getLastName();
        rowData[4] = user.getBirthday();
        rowData[5] = user.getBirthplace();
        rowData[6] = user.getRights();
        rowData[7] = user.getGender();
        rowData[8] = user.getCreatedBy();
        rowData[9] = user.getCreatedDate();
        rowData[10] = user.getUpdatedBy();
        rowData[11] = user.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();

    try {

      currentUserList = userService.getAllUsers(Config.ROW_LIMIT, Config.USER_OFFSET);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (currentUserList != null && currentUserList.size() != 0) {

      Object[] rowData = new Object[12];
      for (User user : currentUserList) {
        rowData[0] = user.getUserId();
        rowData[1] = user.getUserType();
        rowData[2] = user.getFirstName();
        rowData[3] = user.getLastName();
        rowData[4] = user.getBirthday();
        rowData[5] = user.getBirthplace();
        rowData[6] = user.getRights();
        rowData[7] = user.getGender();
        rowData[8] = user.getCreatedBy();
        rowData[9] = user.getCreatedDate();
        rowData[10] = user.getUpdatedBy();
        rowData[11] = user.getUpdatedDate();
        tableModel.addRow(rowData);
      }

    }

  }

}
