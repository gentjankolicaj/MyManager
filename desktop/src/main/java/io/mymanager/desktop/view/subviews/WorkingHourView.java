package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.data.models.WorkingHour;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.WorkingHourService;
import io.mymanager.desktop.service.impl.WorkingHourServiceImpl;
import io.mymanager.desktop.util.DateTimeUtils;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreateWorkingHour;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditWorkingHour;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
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

public class WorkingHourView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = -1225822272502930994L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // Service fields
  private final UserService userService;
  private final WorkingHourService workingHourService;
  private final User user;
  private JTextField textFieldSearch;
  private JButton btnSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnCreate;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnEmpId;
  private JRadioButton rdbtnDate;
  private List<WorkingHour> currentWorkingHourList;

  /**
   * Create the panel.
   */
  public WorkingHourView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1060, 620);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userService = userService;
    this.user = user;
    this.workingHourService = new WorkingHourServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);
    JLabel lblNewLabel = new JLabel("All registered working hours");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(341, 13, 274, 35);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 785, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(807, 85, 138, 30);
    add(btnSearch);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 48, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(92, 50, 71, 25);
    add(rdbtnId);

    rdbtnEmpId = new JRadioButton("Emp Id");
    buttonGroupSearchType.add(rdbtnEmpId);
    rdbtnEmpId.setBounds(159, 50, 71, 25);
    add(rdbtnEmpId);

    rdbtnDate = new JRadioButton("Date");
    buttonGroupSearchType.add(rdbtnDate);
    rdbtnDate.setBounds(234, 50, 104, 25);
    add(rdbtnDate);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 933, 442);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "Emp Id", "Date", "Amount", "Created by", "Created date",
            "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnCreate = new JButton("Create");
    btnCreate.setBounds(957, 144, 97, 25);
    add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setBounds(957, 182, 97, 25);
    add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(957, 220, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(957, 279, 97, 25);
    add(btnBack);
  }

  private void initEvents() {

    btnSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        searchWorkingHours();
      }
    });

    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateWorkingHour createWorkingHour = new CreateWorkingHour(workingHourService, user);
        createWorkingHour.setModal(true);
        createWorkingHour.setVisible(true);

        loadData();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          WorkingHour oldWorkingHour = currentWorkingHourList.get(selectedRow);
          EditWorkingHour editWorkingHour = new EditWorkingHour(workingHourService, user,
              oldWorkingHour);
          editWorkingHour.setModal(true);
          editWorkingHour.setVisible(true);

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
          WorkingHour workingHourToDelete = currentWorkingHourList.get(selectedRow);
          try {

            workingHourService.deleteWorkingHour(workingHourToDelete);

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

  private void searchWorkingHours() {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {

      if (searchValue.equals("") || searchValue.equals(" ")) {
        searchValue = "1";
      }

      WorkingHour temp = null;
      try {
        temp = workingHourService.getWorkingHourByIndex(Integer.parseInt(searchValue));
      } catch (Exception e) {

        e.printStackTrace();
      }
      if (temp != null) {
        currentWorkingHourList.add(temp);
      }

      fillTable(currentWorkingHourList);

    } else if (rdbtnEmpId.isSelected()) {

      if (searchValue.equals("") || searchValue.equals(" ")) {
        searchValue = "1";
      }

      try {

        currentWorkingHourList = workingHourService.getWorkingHourByEmplyeeId(searchValue);

      } catch (Exception e) {

        e.printStackTrace();
      }

      fillTable(currentWorkingHourList);

    } else if (rdbtnDate.isSelected()) {
      LocalDate localDateValue = null;

      if (searchValue.equals("") || searchValue.equals(" ")) {
        searchValue = "01 01 2000";
      }

      try {
        localDateValue = DateTimeUtils.parseToLocalDate(searchValue, "dd MM yyyy");
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (localDateValue != null) {
        try {
          currentWorkingHourList = workingHourService.getWorkingHourByDate(localDateValue);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

    }
  }

  private void emptyTable() {
    currentWorkingHourList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<WorkingHour> workingHoursList) {
    if (workingHoursList != null && workingHoursList.size() != 0) {
      Object[] rowData = new Object[8];
      for (WorkingHour workingHour : workingHoursList) {
        rowData[0] = workingHour.getIndex();
        rowData[1] = workingHour.getEmployeeId();
        rowData[2] = workingHour.getDate();
        rowData[3] = workingHour.getAmount();
        rowData[4] = workingHour.getCreatedBy();
        rowData[5] = workingHour.getCreatedDate();
        rowData[6] = workingHour.getUpdatedBy();
        rowData[7] = workingHour.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();
    try {

      currentWorkingHourList = workingHourService.getAllWorkingHour(Config.ROW_LIMIT,
          Config.WORKINGHOUR_OFFSET);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    if (currentWorkingHourList != null && currentWorkingHourList.size() != 0) {
      Object[] rowData = new Object[8];
      for (WorkingHour workingHour : currentWorkingHourList) {
        rowData[0] = workingHour.getIndex();
        rowData[1] = workingHour.getEmployeeId();
        rowData[2] = workingHour.getDate();
        rowData[3] = workingHour.getAmount();
        rowData[4] = workingHour.getCreatedBy();
        rowData[5] = workingHour.getCreatedDate();
        rowData[6] = workingHour.getUpdatedBy();
        rowData[7] = workingHour.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

}
