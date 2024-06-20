package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.Job;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.JobService;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.impl.JobServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.create.CreateJob;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.edit.EditJob;
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

public class JobView extends MyPanel {

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
  private final JobService jobService;
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
  private JRadioButton rdbtnTitle;
  private JRadioButton rdbtnSalary;
  private List<Job> currentJobList;

  /**
   * Create the panel.
   */
  public JobView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1060, 620);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.userService = userService;
    this.user = user;
    this.jobService = new JobServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {

    setLayout(null);

    JLabel lblNewLabel = new JLabel("All registered jobs");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(341, 13, 274, 35);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 785, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(809, 85, 138, 30);
    add(btnSearch);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 48, 89, 31);
    add(lblSearcchBy);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(92, 50, 71, 25);
    add(rdbtnId);

    rdbtnTitle = new JRadioButton("Title");
    buttonGroupSearchType.add(rdbtnTitle);
    rdbtnTitle.setBounds(159, 50, 71, 25);
    add(rdbtnTitle);

    rdbtnSalary = new JRadioButton("Salary");
    buttonGroupSearchType.add(rdbtnSalary);
    rdbtnSalary.setBounds(234, 50, 79, 25);
    add(rdbtnSalary);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 933, 442);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "Title", "Max salary", "Min salary", "Created by",
            "Created date", "Updated by", "Updated date"});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnCreate = new JButton("Create");
    btnCreate.setBounds(957, 153, 97, 25);
    add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setBounds(957, 191, 97, 25);
    add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(957, 229, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(957, 288, 97, 25);
    add(btnBack);
  }

  private void initEvents() {

    btnSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        searchJobs();

      }
    });

    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateJob createJob = new CreateJob(jobService, user);
        createJob.setModal(true);
        createJob.setVisible(true);

        loadData();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRow = table.getSelectedRow();
        int totalRows = table.getRowCount();
        if ((selectedRow > -1) && (selectedRow < totalRows)) {
          Job oldJob = currentJobList.get(selectedRow);
          EditJob editJob = new EditJob(jobService, user, oldJob);
          editJob.setModal(true);
          editJob.setVisible(true);

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
          Job jobToDelete = currentJobList.get(selectedRow);
          try {

            jobService.deleteJob(jobToDelete);

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

  private void searchJobs() {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (rdbtnId.isSelected()) {
      Job temp = null;
      try {
        temp = jobService.getJob(Integer.parseInt(searchValue));
      } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (temp != null) {
        currentJobList.add(temp);
      }
      fillTable(currentJobList);
    } else if (rdbtnTitle.isSelected()) {
      try {
        currentJobList = jobService.getAllJobsByTitle(searchValue);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      fillTable(currentJobList);

    } else if (rdbtnSalary.isSelected()) {
      int boundary = searchValue.indexOf("/");
      String minValue = searchValue.substring(0, boundary);
      String maxValue = searchValue.substring(boundary + 1);

      try {
        currentJobList = jobService.getAllJobsBetweenSalary(Float.parseFloat(minValue),
            Float.parseFloat(maxValue));
      } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      fillTable(currentJobList);

    }
  }

  private void emptyTable() {
    currentJobList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<Job> jobsList) {
    if (jobsList != null && jobsList.size() != 0) {
      Object[] rowData = new Object[8];
      for (Job job : jobsList) {
        rowData[0] = job.getJobId();
        rowData[1] = job.getJobTitle();
        rowData[2] = job.getMaxSalary();
        rowData[3] = job.getMinSalary();
        rowData[4] = job.getCreatedBy();
        rowData[5] = job.getCreatedDate();
        rowData[6] = job.getUpdatedBy();
        rowData[7] = job.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();

    try {
      currentJobList = jobService.getAllJobs(Config.ROW_LIMIT, Config.JOB_OFFSET);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (currentJobList != null && currentJobList.size() != 0) {
      Object[] rowData = new Object[8];
      for (Job job : currentJobList) {
        rowData[0] = job.getJobId();
        rowData[1] = job.getJobTitle();
        rowData[2] = job.getMaxSalary();
        rowData[3] = job.getMinSalary();
        rowData[4] = job.getCreatedBy();
        rowData[5] = job.getCreatedDate();
        rowData[6] = job.getUpdatedBy();
        rowData[7] = job.getUpdatedDate();
        tableModel.addRow(rowData);
      }
    }
  }
}
