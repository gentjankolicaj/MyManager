package io.mymanager.desktop.view;

import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.data.models.UserType;
import io.mymanager.desktop.enums.MessageType;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.util.WindowUtils;
import io.mymanager.desktop.view.subviews.AccountView;
import io.mymanager.desktop.view.subviews.AttemptView;
import io.mymanager.desktop.view.subviews.CountryView;
import io.mymanager.desktop.view.subviews.CurrencyView;
import io.mymanager.desktop.view.subviews.DepartmentView;
import io.mymanager.desktop.view.subviews.FileView;
import io.mymanager.desktop.view.subviews.JobView;
import io.mymanager.desktop.view.subviews.PaymentTypeView;
import io.mymanager.desktop.view.subviews.PaymentsView;
import io.mymanager.desktop.view.subviews.ProjectView;
import io.mymanager.desktop.view.subviews.RightsView;
import io.mymanager.desktop.view.subviews.WorkingHourView;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import io.mymanager.desktop.view.subviews.employee.EmployeeDataView;
import io.mymanager.desktop.view.subviews.user.UserDataView;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author gentjan kolicaj
 */
public class MainView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 7963323342444755630L;

  private final JFrame jframe;
  private final MainView selfReference;
  // Views
  //
  private final UserDataView usersDataView;
  private final EmployeeDataView employeesDataView;
  private final ProjectView projectsView;
  private final JobView jobsView;
  private final AttemptView attemptsView;
  private final WorkingHourView workingHoursView;
  private final DepartmentView departmentsView;
  private final PaymentsView paymentsView;
  //User and services
  private final UserService userService;
  private JPanel accountPanel;
  private JPanel useDataPanel;
  private JPanel employeeDataPanel;
  private JPanel projectsPanel;
  private JLabel labelFirstname;
  private JLabel labelLastname;
  private JLabel labelGender;
  private JLabel labelBirthplace;
  private JLabel labelBirthday;
  private JLabel labelUsertype;
  private JLabel labelRights;
  private JLabel labelLastlogin;
  private JLabel labelDate;
  private JPanel jobsPanel;
  private JPanel myAccountPanel;
  private JPanel currenciesPanel;
  private JPanel paymentTypePanel;
  private JPanel rightsPanel;
  private JPanel fileTypePanel;
  private JPanel countryPanel;
  private JLabel labelUserId;
  private JPanel departmentsPanel;
  private JPanel workingHoursPanel;
  private JPanel attemptsPanel;
  private JPanel paymentsPanel;
  private JPanel documentsPanel;
  private JPanel dataPanel;
  private User user;

  /**
   * Create the panel.
   */
  public MainView(JFrame jframe, UserService userService, User user) {
    super(1090, 730);
    selfReference = this;
    this.jframe = jframe;
    this.user = user;
    this.userService = userService;

    usersDataView = new UserDataView(jframe, selfReference, userService, user);
    employeesDataView = new EmployeeDataView(jframe, selfReference, user);
    projectsView = new ProjectView(jframe, selfReference, userService, user);
    jobsView = new JobView(jframe, selfReference, userService, user);
    workingHoursView = new WorkingHourView(jframe, selfReference, userService, user);
    attemptsView = new AttemptView(jframe, selfReference, user);
    departmentsView = new DepartmentView(jframe, selfReference, userService, user);
    paymentsView = new PaymentsView(jframe, selfReference, userService, user);

    initComponents();
    initAccountEvents();
    initConfigEvents();

    setMainViewUserDetails(user);

  }

  public void initComponents() {
    setBorder(new LineBorder(new Color(0, 191, 255)));
    setForeground(new Color(0, 191, 255));
    setBackground(SystemColor.menu);
    setLayout(null);

    accountPanel = new JPanel();
    accountPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
    accountPanel.setBackground(UIManager.getColor("Button.background"));
    accountPanel.setBounds(0, 0, 284, 639);
    add(accountPanel);
    accountPanel.setLayout(null);

    JLabel lblUser = new JLabel("");
    lblUser.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-administrator-male-2.png"));
    lblUser.setBounds(116, 0, 75, 56);
    accountPanel.add(lblUser);

    labelFirstname = new JLabel("default");
    labelFirstname.setBounds(95, 118, 162, 19);
    accountPanel.add(labelFirstname);

    JLabel firstname = new JLabel("First name :");
    firstname.setFont(new Font("Arial", Font.BOLD, 13));
    firstname.setBounds(10, 118, 75, 19);
    accountPanel.add(firstname);

    labelLastname = new JLabel("default");
    labelLastname.setBounds(95, 158, 162, 19);
    accountPanel.add(labelLastname);

    labelGender = new JLabel("default");
    labelGender.setBounds(95, 198, 162, 19);
    accountPanel.add(labelGender);

    labelBirthplace = new JLabel("default");
    labelBirthplace.setBounds(95, 238, 162, 19);
    accountPanel.add(labelBirthplace);

    labelBirthday = new JLabel("default");
    labelBirthday.setBounds(98, 278, 159, 19);
    accountPanel.add(labelBirthday);

    labelUsertype = new JLabel("default");
    labelUsertype.setBounds(98, 318, 140, 19);
    accountPanel.add(labelUsertype);

    labelRights = new JLabel("default");
    labelRights.setBounds(81, 358, 193, 19);
    accountPanel.add(labelRights);

    labelLastlogin = new JLabel("default");
    labelLastlogin.setBounds(95, 398, 162, 19);
    accountPanel.add(labelLastlogin);

    JLabel lastname = new JLabel("Last name :");
    lastname.setFont(new Font("Arial", Font.BOLD, 13));
    lastname.setBounds(10, 158, 75, 19);
    accountPanel.add(lastname);

    JLabel gender = new JLabel("Gender :");
    gender.setFont(new Font("Arial", Font.BOLD, 13));
    gender.setBounds(10, 198, 75, 19);
    accountPanel.add(gender);

    JLabel birthplace = new JLabel("Birthplace :");
    birthplace.setFont(new Font("Arial", Font.BOLD, 13));
    birthplace.setBounds(10, 238, 75, 19);
    accountPanel.add(birthplace);

    JLabel birthday = new JLabel("Birthday  :");
    birthday.setFont(new Font("Arial", Font.BOLD, 13));
    birthday.setBounds(10, 278, 75, 19);
    accountPanel.add(birthday);

    JLabel userType = new JLabel("User type  :");
    userType.setFont(new Font("Arial", Font.BOLD, 13));
    userType.setBounds(10, 318, 75, 19);
    accountPanel.add(userType);

    JLabel rights = new JLabel("Rights  :");
    rights.setFont(new Font("Arial", Font.BOLD, 13));
    rights.setBounds(10, 358, 75, 19);
    accountPanel.add(rights);

    JLabel lastlogin = new JLabel("Last login :");
    lastlogin.setFont(new Font("Arial", Font.BOLD, 13));
    lastlogin.setBounds(10, 398, 75, 17);
    accountPanel.add(lastlogin);

    JLabel userId = new JLabel("User Id :");
    userId.setFont(new Font("Arial", Font.BOLD, 13));
    userId.setBounds(10, 86, 60, 14);
    accountPanel.add(userId);

    labelUserId = new JLabel("default");
    labelUserId.setBounds(95, 86, 162, 19);
    accountPanel.add(labelUserId);

    JPanel menuPanel = new JPanel();
    menuPanel.setBorder(new LineBorder(new Color(0, 191, 255)));
    menuPanel.setForeground(new Color(0, 191, 255));
    menuPanel.setBackground(UIManager.getColor("Button.background"));
    menuPanel.setBounds(226, 0, 874, 639);
    add(menuPanel);
    menuPanel.setLayout(null);

    dataPanel = new JPanel();
    dataPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "My Data", TitledBorder.CENTER,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
    dataPanel.setBackground(UIManager.getColor("Button.background"));
    dataPanel.setBounds(61, 11, 793, 388);
    menuPanel.add(dataPanel);
    dataPanel.setLayout(null);

    useDataPanel = new JPanel();
    useDataPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "User data",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    useDataPanel.setBackground(UIManager.getColor("Button.background"));
    useDataPanel.setBounds(15, 21, 168, 110);
    dataPanel.add(useDataPanel);
    useDataPanel.setLayout(null);

    JLabel lblNewLabel_1 = new JLabel("");
    lblNewLabel_1.setBounds(41, 11, 102, 88);
    useDataPanel.add(lblNewLabel_1);
    lblNewLabel_1.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-user-menu-male.png"));

    employeeDataPanel = new JPanel();
    employeeDataPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Employees",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    employeeDataPanel.setBackground(UIManager.getColor("Button.background"));
    employeeDataPanel.setBounds(216, 21, 173, 110);
    dataPanel.add(employeeDataPanel);
    employeeDataPanel.setLayout(null);

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setBounds(43, 11, 97, 88);
    employeeDataPanel.add(lblNewLabel);
    lblNewLabel.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-users-meeting-2.png"));

    jobsPanel = new JPanel();
    jobsPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Jobs", TitledBorder.LEADING,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
    jobsPanel.setBackground(UIManager.getColor("Button.background"));
    jobsPanel.setBounds(420, 21, 168, 110);
    dataPanel.add(jobsPanel);
    jobsPanel.setLayout(null);

    JLabel label_1 = new JLabel("");
    label_1.setIcon(
        IconUtils.getIcon("icons/icons_80x80/icons8-conference-foreground-selected.png"));
    label_1.setBounds(37, 22, 98, 77);
    jobsPanel.add(label_1);

    projectsPanel = new JPanel();

    projectsPanel.setLayout(null);
    projectsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Projects",
        TitledBorder.LEADING, TitledBorder.TOP, null, null));
    projectsPanel.setBackground(UIManager.getColor("Button.background"));
    projectsPanel.setBounds(15, 142, 168, 110);
    dataPanel.add(projectsPanel);

    JLabel lblNewLabel_2 = new JLabel("");
    lblNewLabel_2.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-training-2.png"));
    lblNewLabel_2.setBounds(42, 11, 100, 88);
    projectsPanel.add(lblNewLabel_2);

    departmentsPanel = new JPanel();
    departmentsPanel.setLayout(null);
    departmentsPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Departments",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    departmentsPanel.setBackground(UIManager.getColor("Button.background"));
    departmentsPanel.setBounds(216, 142, 168, 110);
    dataPanel.add(departmentsPanel);

    JLabel label_7 = new JLabel("");
    label_7.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-contact-us-2.png"));
    label_7.setBounds(35, 11, 102, 88);
    departmentsPanel.add(label_7);

    attemptsPanel = new JPanel();
    attemptsPanel.setLayout(null);
    attemptsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Attempts",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    attemptsPanel.setBackground(UIManager.getColor("Button.background"));
    attemptsPanel.setBounds(15, 263, 168, 110);
    dataPanel.add(attemptsPanel);

    JLabel label_9 = new JLabel("");
    label_9.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-resume.png"));
    label_9.setBounds(35, 11, 102, 88);
    attemptsPanel.add(label_9);

    workingHoursPanel = new JPanel();
    workingHoursPanel.setLayout(null);
    workingHoursPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Working hours",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    workingHoursPanel.setBackground(SystemColor.menu);
    workingHoursPanel.setBounds(420, 142, 168, 110);
    dataPanel.add(workingHoursPanel);

    JLabel label_8 = new JLabel("");
    label_8.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-street-worker-2.png"));
    label_8.setBounds(33, 11, 102, 88);
    workingHoursPanel.add(label_8);

    paymentsPanel = new JPanel();
    paymentsPanel.setLayout(null);
    paymentsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Payments",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    paymentsPanel.setBackground(SystemColor.menu);
    paymentsPanel.setBounds(615, 142, 168, 110);
    dataPanel.add(paymentsPanel);

    JLabel label_10 = new JLabel("");
    label_10.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-payment-history-2.png"));
    label_10.setBounds(40, 11, 102, 88);
    paymentsPanel.add(label_10);

    documentsPanel = new JPanel();
    documentsPanel.setLayout(null);
    documentsPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Employee documents",
            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    documentsPanel.setBackground(SystemColor.menu);
    documentsPanel.setBounds(615, 21, 168, 110);
    dataPanel.add(documentsPanel);

    JLabel label_11 = new JLabel("");
    label_11.setIcon(IconUtils.getIcon("icons/icons_80x80/icons8-book-shelf.png"));
    label_11.setBounds(30, 11, 102, 88);
    documentsPanel.add(label_11);

    JPanel configPanel = new JPanel();
    configPanel.setBackground(UIManager.getColor("Button.background"));
    configPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Configuration",
        TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
    configPanel.setForeground(new Color(0, 0, 0));
    configPanel.setBounds(59, 404, 795, 233);
    menuPanel.add(configPanel);
    configPanel.setLayout(null);

    myAccountPanel = new JPanel();
    myAccountPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "My Account",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    myAccountPanel.setBackground(UIManager.getColor("Button.background"));
    myAccountPanel.setBounds(35, 26, 87, 78);
    configPanel.add(myAccountPanel);
    myAccountPanel.setLayout(null);

    JLabel label = new JLabel("");
    label.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-edit-account-2.png"));
    label.setBounds(21, 11, 56, 56);
    myAccountPanel.add(label);

    currenciesPanel = new JPanel();
    currenciesPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Currencies",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    currenciesPanel.setBackground(UIManager.getColor("Button.background"));
    currenciesPanel.setBounds(146, 26, 87, 78);
    configPanel.add(currenciesPanel);
    currenciesPanel.setLayout(null);

    JLabel label_2 = new JLabel("");
    label_2.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-sack-of-money-2.png"));
    label_2.setBounds(21, 11, 56, 56);
    currenciesPanel.add(label_2);

    paymentTypePanel = new JPanel();
    paymentTypePanel.setBackground(UIManager.getColor("Button.background"));
    paymentTypePanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Pay type", TitledBorder.LEADING,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
    paymentTypePanel.setBounds(257, 26, 87, 78);
    configPanel.add(paymentTypePanel);
    paymentTypePanel.setLayout(null);

    JLabel label_3 = new JLabel("");
    label_3.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-save-money-2.png"));
    label_3.setBounds(21, 11, 56, 56);
    paymentTypePanel.add(label_3);

    countryPanel = new JPanel();
    countryPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Countries",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    countryPanel.setBackground(UIManager.getColor("Button.background"));
    countryPanel.setBounds(371, 26, 87, 78);
    configPanel.add(countryPanel);
    countryPanel.setLayout(null);

    JLabel label_4 = new JLabel("");
    label_4.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-country.png"));
    label_4.setBounds(21, 11, 56, 56);
    countryPanel.add(label_4);

    rightsPanel = new JPanel();
    rightsPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 191, 255)), "Rights", TitledBorder.LEADING,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
    rightsPanel.setBackground(UIManager.getColor("Button.background"));
    rightsPanel.setBounds(485, 26, 87, 78);
    configPanel.add(rightsPanel);
    rightsPanel.setLayout(null);

    JLabel label_5 = new JLabel("");
    label_5.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-user-rights.png"));
    label_5.setBounds(21, 11, 56, 56);
    rightsPanel.add(label_5);

    fileTypePanel = new JPanel();
    fileTypePanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255)), "File types",
        TitledBorder.LEADING, TitledBorder.TOP, null, null));
    fileTypePanel.setBackground(UIManager.getColor("Button.background"));
    fileTypePanel.setBounds(601, 26, 87, 78);
    configPanel.add(fileTypePanel);
    fileTypePanel.setLayout(null);

    JLabel label_6 = new JLabel("");
    label_6.setIcon(IconUtils.getIcon("icons/icons_45x45/icons8-new-file-3.png"));
    label_6.setBounds(21, 11, 56, 56);
    fileTypePanel.add(label_6);

    JPanel panel_7 = new JPanel();
    panel_7.setBounds(146, 134, 87, 78);
    configPanel.add(panel_7);

    JPanel panel_8 = new JPanel();
    panel_8.setBounds(257, 134, 87, 78);
    configPanel.add(panel_8);

    JPanel panel_9 = new JPanel();
    panel_9.setBounds(371, 134, 87, 78);
    configPanel.add(panel_9);

    JPanel panel_10 = new JPanel();
    panel_10.setBounds(485, 134, 87, 78);
    configPanel.add(panel_10);

    JPanel panel_1 = new JPanel();
    panel_1.setBounds(698, 26, 87, 78);
    configPanel.add(panel_1);

    JPanel panel_2 = new JPanel();
    panel_2.setBounds(584, 134, 87, 78);
    configPanel.add(panel_2);

    JPanel panel_3 = new JPanel();
    panel_3.setBounds(698, 134, 87, 78);
    configPanel.add(panel_3);

    JPanel panel = new JPanel();
    panel.setBounds(35, 134, 87, 78);
    configPanel.add(panel);

    labelDate = new JLabel("default");
    labelDate.setBounds(95, 655, 162, 19);
    add(labelDate);

    JLabel currentDate = new JLabel("Today date");
    currentDate.setBounds(10, 655, 75, 18);
    add(currentDate);
    currentDate.setFont(new Font("Arial", Font.BOLD, 13));

  }

  public void initAccountEvents() {
    useDataPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, usersDataView);
      }
    });

    employeeDataPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, employeesDataView);
      }
    });

    jobsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, jobsView);
      }
    });

    projectsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, projectsView);
      }
    });

    departmentsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, departmentsView);
      }
    });

    attemptsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, attemptsView);
      }
    });

    workingHoursPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, workingHoursView);
      }
    });

    paymentsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, paymentsView);
      }
    });

    documentsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        ViewUtils.changeView(jframe, selfReference, paymentsView);
      }
    });

  }

  public void initConfigEvents() {
    myAccountPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        AccountView accountView = new AccountView(userService, user);
        accountView.setModal(true);
        accountView.setVisible(true);

        updateMainViewUserDetails();
      }
    });

    currenciesPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        if (user.getUserType().equals(UserType.ADMIN.toString())) {
          CurrencyView currencyView = new CurrencyView();
          currencyView.setModal(true);
          currencyView.setVisible(true);

        } else {
          WindowUtils.showMessage(null, "Admin users only can access currency panel.",
              MessageType.INFORMATION);
        }
      }
    });

    fileTypePanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        if (user.getUserType().equals(UserType.ADMIN.toString())) {
          FileView fileView = new FileView();
          fileView.setModal(true);
          fileView.setVisible(true);

        } else {
          WindowUtils.showMessage(null, "Admin users only can access currency panel.",
              MessageType.INFORMATION);
        }
      }
    });

    rightsPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        if (user.getUserType().equals(UserType.ADMIN.toString())) {
          RightsView rightsView = new RightsView(userService, user);
          rightsView.updateUserComboBox();
          rightsView.setModal(true);
          rightsView.setVisible(true);

          updateMainViewUserDetails();
        } else {
          WindowUtils.showMessage(null, "Admin users only can access rights panel.",
              MessageType.INFORMATION);
        }

      }
    });

    countryPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        if (user.getUserType().equals(UserType.ADMIN.toString())) {
          CountryView countryView = new CountryView();
          countryView.setModal(true);
          countryView.setVisible(true);

        } else {
          WindowUtils.showMessage(null, "Admin users only can access country panel.",
              MessageType.INFORMATION);
        }
      }
    });

    paymentTypePanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        if (user.getUserType().equals(UserType.ADMIN.toString())) {
          PaymentTypeView paymentTypeView = new PaymentTypeView();
          paymentTypeView.setModal(true);
          paymentTypeView.setVisible(true);

        } else {
          WindowUtils.showMessage(null, "Admin users only can access country panel.",
              MessageType.INFORMATION);
        }
      }
    });
  }


  private void setMainViewUserDetails(User user) {
    labelUserId.setText(user.getUserId());
    labelFirstname.setText(user.getFirstName());
    labelLastname.setText(user.getLastName());
    labelGender.setText(user.getGender().name());
    labelBirthplace.setText(user.getBirthplace());
    labelBirthday.setText(user.getBirthday().toString());
    labelUsertype.setText(user.getUserType());
    labelRights.setText(user.getRights());
    labelDate.setText(LocalDateTime.now().toString());
  }

  public void updateMainViewUserDetails() {
    try {
      user = userService.getUser(user.getUserId());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    setMainViewUserDetails(user);
  }

}
