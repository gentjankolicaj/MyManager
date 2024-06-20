package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.Project;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.ProjectService;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.impl.ProjectServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreateProject;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditProject;
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

public class ProjectView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 2586092764218526222L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // Service fields
  private final UserService userService;
  private final ProjectService projectService;
  private final User user;
  private JTextField textFieldSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnCreate;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnCustomer;
  private JButton btnSearch;
  private JRadioButton rdbtnName;
  private JRadioButton rdbtnDescription;
  private List<Project> currentProjectList;

  /**
   * Create the panel.
   */
  public ProjectView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1060, 620);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userService = userService;
    this.user = user;
    this.projectService = new ProjectServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);
    JLabel lblNewLabel = new JLabel("All registered projects");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(341, 13, 274, 35);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 789, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 48, 89, 31);
    add(lblSearcchBy);

    rdbtnName = new JRadioButton("Name");
    buttonGroupSearchType.add(rdbtnName);
    rdbtnName.setBounds(83, 50, 74, 25);
    add(rdbtnName);

    rdbtnDescription = new JRadioButton("Desc");
    buttonGroupSearchType.add(rdbtnDescription);
    rdbtnDescription.setBounds(162, 50, 68, 25);
    add(rdbtnDescription);

    rdbtnCustomer = new JRadioButton("Customer");
    buttonGroupSearchType.add(rdbtnCustomer);
    rdbtnCustomer.setBounds(232, 50, 95, 25);
    add(rdbtnCustomer);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(811, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 933, 442);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Name", "Description", "Customer", "Country", "Created by",
            "Created date", "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);
    btnCreate = new JButton("Create");
    btnCreate.setBounds(957, 148, 97, 25);
    add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setBounds(957, 186, 97, 25);
    add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(957, 224, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(957, 283, 97, 25);
    add(btnBack);
  }

  private void initEvents() {
    btnSearch.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        searchProjects();

      }
    });
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateProject createProject = new CreateProject(projectService, user);
        createProject.setModal(true);
        createProject.setVisible(true);

        loadData();

      }
    });
    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          Project oldProject = currentProjectList.get(selectedRow);
          EditProject ediProject = new EditProject(projectService, user, oldProject);
          ediProject.setModal(true);
          ediProject.setVisible(true);

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
          Project projectToDelete = currentProjectList.get(selectedRow);
          try {

            projectService.deleteProject(projectToDelete);

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

  private void searchProjects() {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnName.isSelected()) {
      if (searchValue.equals("") || searchValue.equals(" ")) {
        searchValue = "1";
      }
      Project temp = null;
      try {
        temp = projectService.getProjectByName(searchValue);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (temp != null) {
        currentProjectList.add(temp);
        fillTable(currentProjectList);
      }

    } else if (rdbtnDescription.isSelected()) {
      try {
        currentProjectList = projectService.getAllProjectsByDescription(searchValue);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      fillTable(currentProjectList);

    } else if (rdbtnCustomer.isSelected()) {
      try {
        currentProjectList = projectService.getAllProjectsByCustomer(searchValue);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      fillTable(currentProjectList);

    }
  }

  private void emptyTable() {
    currentProjectList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<Project> projectsList) {
    if (projectsList != null && projectsList.size() != 0) {
      Object[] rowData = new Object[8];
      for (Project project : projectsList) {
        rowData[0] = project.getProjectName();
        rowData[1] = project.getDescription();
        rowData[2] = project.getCustomer();
        rowData[3] = project.getCountry().getCountryName();
        rowData[4] = project.getCreatedBy();
        rowData[5] = project.getCreatedDate();
        rowData[6] = project.getUpdatedBy();
        rowData[7] = project.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();
    try {
      currentProjectList = projectService.getAllProjects(Config.ROW_LIMIT, Config.PROJECT_OFFSET);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (currentProjectList != null && currentProjectList.size() != 0) {
      Object[] rowData = new Object[8];
      for (Project project : currentProjectList) {
        rowData[0] = project.getProjectName();
        rowData[1] = project.getDescription();
        rowData[2] = project.getCustomer();
        rowData[3] = project.getCountry().getCountryName();
        rowData[4] = project.getCreatedBy();
        rowData[5] = project.getCreatedDate();
        rowData[6] = project.getUpdatedBy();
        rowData[7] = project.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }

  }

}
