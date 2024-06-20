package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.Department;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.DepartmentService;
import io.mymanager.desktop.service.EmployeeService;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.impl.DepartmentServiceImpl;
import io.mymanager.desktop.service.impl.EmployeeServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreateDepartment;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditDepartment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class DepartmentView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = -2191151781811208739L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // Service fields
  private final UserService userService;
  private final DepartmentService departmentService;
  private final EmployeeService employeeService;
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
  private JRadioButton rdbtnName;
  private List<Department> currentDepartmentList;

  /**
   * Create the panel.
   */
  public DepartmentView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1060, 620);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userService = userService;
    this.user = user;
    this.departmentService = new DepartmentServiceImpl();
    this.employeeService = new EmployeeServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);
    JLabel lblNewLabel = new JLabel("All registered departments");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(341, 13, 274, 35);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 771, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(92, 50, 71, 25);
    add(rdbtnId);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 48, 89, 31);
    add(lblSearcchBy);

    rdbtnName = new JRadioButton("Name");
    buttonGroupSearchType.add(rdbtnName);
    rdbtnName.setBounds(159, 50, 153, 25);
    add(rdbtnName);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(813, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 933, 442);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "Name", "Manager Id", "Created by", "Created date",
            "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnCreate = new JButton("Create");
    btnCreate.setBounds(957, 156, 97, 25);
    add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setBounds(957, 194, 97, 25);
    add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(957, 232, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(957, 291, 97, 25);
    add(btnBack);
  }

  private void initEvents() {

    btnSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        searchDepartments();
      }
    });

    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateDepartment createDepartment = new CreateDepartment(departmentService, user);
        createDepartment.setModal(true);
        createDepartment.setVisible(true);

        loadData();

      }
    });
    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          Department oldDepartment = currentDepartmentList.get(selectedRow);
          EditDepartment editDepartment = new EditDepartment(departmentService, user,
              oldDepartment);
          editDepartment.setModal(true);
          editDepartment.setVisible(true);

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
          Department departmentToDelete = currentDepartmentList.get(selectedRow);

          try {
            departmentService.deleteDepartment(departmentToDelete);
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

  private void searchDepartments() {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      Department temp = null;
      try {
        temp = departmentService.getDepartment(searchValue);
      } catch (Exception e) {

        e.printStackTrace();
      }
      if (temp != null) {
        currentDepartmentList.add(temp);
      }
      fillTable(currentDepartmentList);

    } else if (rdbtnName.isSelected()) {
      try {
        currentDepartmentList = departmentService.getDepartments(searchValue);
      } catch (Exception e) {

        e.printStackTrace();
      }
      fillTable(currentDepartmentList);

    }

  }

  private void emptyTable() {
    currentDepartmentList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<Department> departmentsList) {
    if (departmentsList != null && departmentsList.size() != 0) {
      Object[] rowData = new Object[7];
      for (Department department : departmentsList) {
        rowData[0] = department.getDepartmentId();
        rowData[1] = department.getDepartmentName();
        rowData[2] = department.getManagerId();
        rowData[3] = department.getCreatedBy();
        rowData[4] = department.getCreatedDate();
        rowData[5] = department.getUpdatedBy();
        rowData[6] = department.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();
    try {

      currentDepartmentList = departmentService.getAllDepartments(Config.ROW_LIMIT,
          Config.DEPARTMENT_OFFSET);

    } catch (Exception e) {

      e.printStackTrace();
    }
    if (currentDepartmentList != null && currentDepartmentList.size() != 0) {
      Object[] rowData = new Object[7];
      for (Department department : currentDepartmentList) {
        rowData[0] = department.getDepartmentId();
        rowData[1] = department.getDepartmentName();
        rowData[2] = department.getManagerId();
        rowData[3] = department.getCreatedBy();
        rowData[4] = department.getCreatedDate();
        rowData[5] = department.getUpdatedBy();
        rowData[6] = department.getUpdatedDate();
        tableModel.addRow(rowData);
      }

    }
  }

}
