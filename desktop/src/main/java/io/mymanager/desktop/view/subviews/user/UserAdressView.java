package io.mymanager.desktop.view.subviews.user;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.UserAdress;
import io.mymanager.desktop.service.UserAdressService;
import io.mymanager.desktop.service.impl.UserAdressServiceImpl;
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
public class UserAdressView extends MyPanel {

  private static final long serialVersionUID = 2586092764218526222L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  private final UserAdressService userAdressService;
  private JTextField textFieldSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnStreet;
  private JButton btnSearch;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnPersonId;
  private JRadioButton rdbtnCity;
  private List<UserAdress> currentAdressList;

  /**
   * Create the panel.
   */
  public UserAdressView(JFrame jframe, MainView mainView) {
    super(1200, 600);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userAdressService = new UserAdressServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);

    JLabel lblNewLabel = new JLabel("All user adresses");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(455, 11, 230, 31);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 913, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 43, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(83, 46, 56, 25);
    add(rdbtnId);

    rdbtnPersonId = new JRadioButton("User Id");
    buttonGroupSearchType.add(rdbtnPersonId);
    rdbtnPersonId.setBounds(141, 46, 73, 25);
    add(rdbtnPersonId);

    rdbtnCity = new JRadioButton("City");
    buttonGroupSearchType.add(rdbtnCity);
    rdbtnCity.setBounds(215, 46, 56, 25);
    add(rdbtnCity);

    rdbtnStreet = new JRadioButton("Street");
    buttonGroupSearchType.add(rdbtnStreet);
    rdbtnStreet.setBounds(275, 46, 83, 25);
    add(rdbtnStreet);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(942, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 1068, 462);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "User Id", "Country", "City", "Street", "Zip code",
            "Building", "Created by", "Created date", "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(1090, 142, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(1090, 178, 97, 25);
    add(btnBack);
  }

  private void initEvents() {
    btnSearch.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {

        try {

          searchAdresses();

        } catch (NumberFormatException n) {

          n.printStackTrace();

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

          UserAdress adressToDelete = currentAdressList.get(selectedRow);

          try {

            userAdressService.deleteAdress(adressToDelete);

          } catch (Exception e1) {
            // TODO Auto-generated catch block
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

  private void searchAdresses() throws Exception {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      UserAdress temp = userAdressService.getAdress(Integer.parseInt(searchValue));
      currentAdressList.add(temp);
      fillTable(currentAdressList);
    } else if (rdbtnPersonId.isSelected()) {
      UserAdress temp = userAdressService.getAdressesByPersonId(searchValue);
      currentAdressList.add(temp);
      fillTable(currentAdressList);
    } else if (rdbtnCity.isSelected()) {
      currentAdressList = userAdressService.getAdressesByCity(searchValue);
      fillTable(currentAdressList);
    } else if (rdbtnStreet.isSelected()) {
      currentAdressList = userAdressService.getAdressesByStreet(searchValue);
      fillTable(currentAdressList);
    }

  }


  private void emptyTable() {
    currentAdressList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<UserAdress> adressesList) {
    if (adressesList != null && adressesList.size() != 0) {
      Object[] rowData = new Object[11];
      for (UserAdress adress : adressesList) {
        rowData[0] = adress.getAdressId();
        rowData[1] = adress.getPersonId();
        rowData[2] = adress.getCountry().getCountryName();
        rowData[3] = adress.getCity();
        rowData[4] = adress.getStreetName();
        rowData[5] = adress.getZipCode();
        rowData[6] = adress.getBuilding();
        rowData[7] = adress.getCreatedBy();
        rowData[8] = adress.getCreatedDate();
        rowData[9] = adress.getUpdatedBy();
        rowData[10] = adress.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();
    try {
      currentAdressList = userAdressService.getAllAdresses(Config.ROW_LIMIT,
          Config.USER_OFFSET);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (currentAdressList != null && currentAdressList.size() != 0) {
      Object[] rowData = new Object[11];
      for (UserAdress adress : currentAdressList) {
        rowData[0] = adress.getAdressId();
        rowData[1] = adress.getPersonId();
        rowData[2] = adress.getCountry().getCountryName();
        rowData[3] = adress.getCity();
        rowData[4] = adress.getStreetName();
        rowData[5] = adress.getZipCode();
        rowData[6] = adress.getBuilding();
        rowData[7] = adress.getCreatedBy();
        rowData[8] = adress.getCreatedDate();
        rowData[9] = adress.getUpdatedBy();
        rowData[10] = adress.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }
}
