package io.mymanager.desktop.view.subviews.employee;

import io.mymanager.desktop.data.models.Employee;
import io.mymanager.desktop.data.models.EmployeeAdress;
import io.mymanager.desktop.data.models.EmployeeContact;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.EmployeeAdressService;
import io.mymanager.desktop.service.EmployeeContactService;
import io.mymanager.desktop.service.EmployeeService;
import io.mymanager.desktop.service.impl.EmployeeAdressServiceImpl;
import io.mymanager.desktop.service.impl.EmployeeContactServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreateEmployee;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditEmployee;
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

public class EmployeeView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 2586092764218526222L;
  //panel properties
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  //Service fields
  private final EmployeeService employeeService;
  private final EmployeeAdressService employeeAdressService;
  private final EmployeeContactService employeeContactService;
  private final User user;
  private JTextField tfSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnCreate;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnFirstname;
  private JRadioButton rdbtnDepartment;
  private JButton btnSearch;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnLastname;
  private List<Employee> currentEmployeeList;
  private JRadioButton rdbtnJob;

  /**
   * Create the panel.
   */
  public EmployeeView(JFrame jframe, MainView mainView, User user,
      EmployeeService employeeService) {
    super(1300, 600);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;
    this.employeeService = employeeService;
    this.user = user;
    this.employeeContactService = new EmployeeContactServiceImpl();
    this.employeeAdressService = new EmployeeAdressServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);

    JLabel lblNewLabel = new JLabel("All employees");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(455, 11, 230, 31);
    add(lblNewLabel);

    tfSearch = new JTextField();
    tfSearch.setBounds(12, 85, 1023, 30);
    add(tfSearch);
    tfSearch.setColumns(10);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblSearcchBy.setBounds(12, 43, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(83, 46, 56, 25);
    add(rdbtnId);

    rdbtnFirstname = new JRadioButton("Firstname");
    buttonGroupSearchType.add(rdbtnFirstname);
    rdbtnFirstname.setBounds(141, 46, 95, 25);
    add(rdbtnFirstname);

    rdbtnLastname = new JRadioButton("Lastname");
    buttonGroupSearchType.add(rdbtnLastname);
    rdbtnLastname.setBounds(238, 46, 83, 25);
    add(rdbtnLastname);

    rdbtnDepartment = new JRadioButton("Departmet Id");
    buttonGroupSearchType.add(rdbtnDepartment);
    rdbtnDepartment.setBounds(409, 46, 110, 25);
    add(rdbtnDepartment);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(1045, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 1171, 462);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "Firstname", "Middle", "Lastname", "Birthday",
            "Birthplace", "Gender", "Job Id", "Dep Id ", "Project", "Created by", "Created date",
            "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);
    btnCreate = new JButton("Create");
    btnCreate.setBounds(1191, 143, 97, 25);
    add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setBounds(1191, 181, 97, 25);
    add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(1191, 219, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(1191, 278, 97, 25);
    add(btnBack);

    rdbtnJob = new JRadioButton("Job Id");
    buttonGroupSearchType.add(rdbtnJob);
    rdbtnJob.setBounds(332, 46, 75, 25);
    add(rdbtnJob);
  }

  private void initEvents() {

    btnSearch.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {

        searchEmployees();

      }
    });

    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {

        CreateEmployee createEmployee = new CreateEmployee(employeeService, employeeAdressService,
            employeeContactService, user);
        createEmployee.setModal(true);
        createEmployee.setVisible(true);
        loadData();

      }
    });
    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {

        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          Employee employeeToDelete = currentEmployeeList.get(selectedRow);

          EmployeeAdress employeeAdress = null;
          EmployeeContact employeeContact = null;

          try {
            employeeAdress = employeeAdressService.getAdressesByPersonId(
                employeeToDelete.getEmployeeId());
            employeeContact = employeeContactService.getContactByPersonId(
                employeeToDelete.getEmployeeId());


          } catch (Exception e1) {

            e1.printStackTrace();
          }

          EditEmployee editEmployee = new EditEmployee(employeeService, employeeAdressService,
              employeeContactService, user, employeeToDelete, employeeAdress, employeeContact);
          editEmployee.setModal(true);
          editEmployee.setVisible(true);

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
          Employee employeeToDelete = currentEmployeeList.get(selectedRow);
          int value = JOptionPane.showConfirmDialog(null,
              "If you delete employee,you are also going to delete automatically its adress,contacts etc...",
              "Do you want to proceed ?", JOptionPane.YES_NO_OPTION);
          if (value == 0) {

            try {
              EmployeeAdress employeeAdress = employeeAdressService.getAdressesByPersonId(
                  employeeToDelete.getEmployeeId());
              EmployeeContact employeeContact = employeeContactService.getContactByPersonId(
                  employeeToDelete.getEmployeeId());

              if (employeeAdress != null) {
                employeeAdressService.deleteAdress(employeeAdress);
              }

              if (employeeContact != null) {
                employeeContactService.deleteContact(employeeContact);
              }

              employeeService.deleteEmployee(employeeToDelete);


            } catch (Exception e1) {
              // TODO Auto-generated catch block
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


  private void emptyTable() {
    currentEmployeeList = new ArrayList<>();
    tableModel.setRowCount(0);

  }

  private void searchEmployees() {
    String searchValue = tfSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      Employee tmp = null;
      try {
        tmp = employeeService.getEmployee(searchValue);
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (tmp != null) {
        currentEmployeeList.add(tmp);
      }
      fillTable(currentEmployeeList);

    } else if (rdbtnFirstname.isSelected()) {
      try {
        currentEmployeeList = employeeService.getEmployeesByFirstName(searchValue);
      } catch (Exception e) {
        e.printStackTrace();
      }
      fillTable(currentEmployeeList);
    } else if (rdbtnLastname.isSelected()) {
      try {
        currentEmployeeList = employeeService.getEmployeesByLastName(searchValue);
      } catch (Exception e) {
        e.printStackTrace();
      }
      fillTable(currentEmployeeList);
    } else if (rdbtnDepartment.isSelected()) {
      try {
        currentEmployeeList = employeeService.getEmployeesByDepartmentId(
            Integer.parseInt(searchValue));
      } catch (Exception e) {
        e.printStackTrace();
      }
      fillTable(currentEmployeeList);
    } else if (rdbtnJob.isSelected()) {
      try {
        currentEmployeeList = employeeService.getEmployeesByJobId(Integer.parseInt(searchValue));
      } catch (Exception e) {
        e.printStackTrace();
      }
      fillTable(currentEmployeeList);
    }

  }


  private void fillTable(List<Employee> employeeList) {
    if (employeeList != null && employeeList.size() != 0) {
      Object[] row = new Object[14];
      for (Employee var : employeeList) {
        row[0] = var.getEmployeeId();
        row[1] = var.getFirstName();
        row[2] = var.getMiddleName();
        row[3] = var.getLastName();
        row[4] = var.getBirthday();
        row[5] = var.getBirthplace();
        row[6] = var.getGender();
        row[7] = var.getJobId();
        row[8] = var.getDepartmentId();
        row[9] = var.getProjectName();
        row[10] = var.getCreatedBy();
        row[11] = var.getCreatedDate();
        row[12] = var.getUpdatedBy();
        row[13] = var.getUpdatedDate();
        tableModel.addRow(row);
      }
    }
  }


  @Override
  public void loadData() {
    emptyTable();
    try {
      currentEmployeeList = employeeService.getAllEmployees();
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (currentEmployeeList != null && currentEmployeeList.size() != 0) {
      Object[] row = new Object[14];
      for (Employee var : currentEmployeeList) {
        row[0] = var.getEmployeeId();
        row[1] = var.getFirstName();
        row[2] = var.getMiddleName();
        row[3] = var.getLastName();
        row[4] = var.getBirthday();
        row[5] = var.getBirthplace();
        row[6] = var.getGender();
        row[7] = var.getJobId();
        row[8] = var.getDepartmentId();
        row[9] = var.getProjectName();
        row[10] = var.getCreatedBy();
        row[11] = var.getCreatedDate();
        row[12] = var.getUpdatedBy();
        row[13] = var.getUpdatedDate();
        tableModel.addRow(row);
      }
    }
  }


  public int getMyHeight() {
    return height;
  }

  public int getMyWidth() {
    return width;
  }
}
