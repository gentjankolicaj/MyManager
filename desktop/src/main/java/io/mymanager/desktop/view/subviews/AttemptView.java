package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.data.models.Attempt;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.data.models.Status;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.AttemptService;
import io.mymanager.desktop.service.impl.AttemptServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
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

public class AttemptView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = -2191151781811208739L;
  private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  // User
  private final AttemptService attemptService;
  private final User user;
  private JTextField textFieldSearch;
  private JButton btnSearch;
  private DefaultTableModel tableModel;
  private MyTable table;
  private JButton btnDelete;
  private JButton btnBack;
  private JRadioButton rdbtnId;
  private JRadioButton rdbtnUser;
  private JRadioButton rdbtnStatus;
  private List<Attempt> currentAttemptList;


  /**
   * Create the panel.
   */
  public AttemptView(JFrame jframe, MainView mainView, User user) {
    super(1060, 620);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;
    this.user = user;
    this.attemptService = new AttemptServiceImpl();

    initComponents();
    initEvents();

  }

  private void initComponents() {
    setLayout(null);
    JLabel lblNewLabel = new JLabel("All registered attemps");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setBounds(341, 13, 274, 35);
    add(lblNewLabel);

    textFieldSearch = new JTextField();
    textFieldSearch.setBounds(12, 85, 787, 30);
    add(textFieldSearch);
    textFieldSearch.setColumns(10);

    rdbtnId = new JRadioButton("Id");
    buttonGroupSearchType.add(rdbtnId);
    rdbtnId.setBounds(92, 50, 48, 25);
    add(rdbtnId);

    JLabel lblSearcchBy = new JLabel("Search by :");
    lblSearcchBy.setBounds(12, 48, 89, 31);
    add(lblSearcchBy);

    rdbtnUser = new JRadioButton("User");
    buttonGroupSearchType.add(rdbtnUser);
    rdbtnUser.setBounds(142, 50, 60, 25);
    add(rdbtnUser);

    rdbtnStatus = new JRadioButton("Status");
    buttonGroupSearchType.add(rdbtnStatus);
    rdbtnStatus.setBounds(204, 50, 71, 25);
    add(rdbtnStatus);

    btnSearch = new JButton("Search");
    btnSearch.setBounds(809, 85, 138, 30);
    add(btnSearch);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 127, 935, 442);

    table = new MyTable();
    table.setFillsViewportHeight(true);

    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(
        new String[]{"Id", "User", "Status", "Description", "Created date",});

    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    add(scrollPane);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(957, 145, 97, 25);
    add(btnDelete);

    btnBack = new JButton("Back");
    btnBack.setBounds(957, 188, 97, 25);
    add(btnBack);
  }

  private void initEvents() {
    btnSearch.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          searchAttempts();
        } catch (Exception e1) {
          // TODO Auto-generated catch block
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
          Attempt attemptToDelete = currentAttemptList.get(selectedRow);
          try {
            attemptService.deleteAttempt(attemptToDelete);
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

  private void searchAttempts() throws Exception {
    String searchValue = textFieldSearch.getText().trim();
    emptyTable();
    if (chooseSearchType() == 1) {
      currentAttemptList = attemptService.getAttempts(searchValue);
      fillTable(currentAttemptList);

    } else if (chooseSearchType() == 2) {
      User temp = new User();
      temp.setUserId(searchValue);
      currentAttemptList = attemptService.getAttempts(temp);
      fillTable(currentAttemptList);

    } else if (chooseSearchType() == 3) {
      String failStaus = Status.FAILURE.toString();
      String successStatus = Status.SUCCESS.toString();

      if (successStatus.contains(searchValue.toUpperCase())) {
        currentAttemptList = attemptService.getAttempts(Status.SUCCESS);
        fillTable(currentAttemptList);
      } else if (failStaus.contains(searchValue.toUpperCase())) {
        currentAttemptList = attemptService.getAttempts(Status.FAILURE);
        fillTable(currentAttemptList);
      }

    } else {

    }
  }

  private int chooseSearchType() {
    if (rdbtnId.isSelected()) {
      return 1;
    } else if (rdbtnUser.isSelected()) {
      return 2;
    } else if (rdbtnStatus.isSelected()) {
      return 3;
    } else {
      return 0;
    }
  }

  private void emptyTable() {
    currentAttemptList = new ArrayList<>();
    tableModel.setRowCount(0);
  }

  private void fillTable(List<Attempt> attemptsList) {
    if (attemptsList != null) {
      Object[] rowData = new Object[5];
      for (Attempt attempt : attemptsList) {
        rowData[0] = attempt.getIndex();
        rowData[1] = attempt.getUser();
        rowData[2] = attempt.getStatus();
        rowData[3] = attempt.getDescription();
        rowData[4] = attempt.getDateTime();
        tableModel.addRow(rowData);
      }
    }
  }

  public void loadData() {
    emptyTable();
    try {
      currentAttemptList = attemptService.getAllAttempts(Config.ROW_LIMIT, Config.ATTEMPT_OFFSET);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (currentAttemptList != null && currentAttemptList.size() != 0) {
      Object[] rowData = new Object[5];
      for (Attempt attempt : currentAttemptList) {
        rowData[0] = attempt.getIndex();
        rowData[1] = attempt.getUser();
        rowData[2] = attempt.getStatus();
        rowData[3] = attempt.getDescription();
        rowData[4] = attempt.getDateTime();
        tableModel.addRow(rowData);
      }
    }
  }

}
