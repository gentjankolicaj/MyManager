package io.mymanager.desktop.view.subviews.employee;

import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.EmployeeAdressService;
import io.mymanager.desktop.service.EmployeeContactService;
import io.mymanager.desktop.service.EmployeeService;
import io.mymanager.desktop.service.impl.EmployeeAdressServiceImpl;
import io.mymanager.desktop.service.impl.EmployeeContactServiceImpl;
import io.mymanager.desktop.service.impl.EmployeeServiceImpl;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EmployeeDataView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 4100590738083935784L;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  //Service
  private final EmployeeService employeeService;
  private final EmployeeAdressService employeeAdressService;
  private final EmployeeContactService employeeContactService;
  private final User user;
  //
  private JButton btnEmployee;
  private JButton btnAdresses;
  private JButton btnContacts;
  private EmployeeView employeeView;
  private EmployeeAdressView employeeAdressView;
  private EmployeeContactView employeeContactView;
  // important for inside navigation
  private MyPanel previousPanel;

  /**
   * Create the panel.
   */
  public EmployeeDataView(JFrame jframe, MainView mainView, User user) {
    super(1425, 650);
    this.jframe = jframe;
    this.mainView = mainView;
    this.selfReference = this;

    this.user = user;
    this.employeeService = new EmployeeServiceImpl();
    this.employeeAdressService = new EmployeeAdressServiceImpl();
    this.employeeContactService = new EmployeeContactServiceImpl();

    initComponents();

    initEvents();
  }

  private void initComponents() {
    setLayout(null);

    btnContacts = new JButton("Contacts");
    btnContacts.setBounds(10, 278, 120, 35);
    add(btnContacts);
    buttonGroup.add(btnContacts);

    btnAdresses = new JButton("Adresses");
    btnAdresses.setBounds(10, 219, 120, 35);
    add(btnAdresses);
    buttonGroup.add(btnAdresses);

    btnEmployee = new JButton("Employee");
    btnEmployee.setBounds(10, 162, 120, 35);
    add(btnEmployee);
    buttonGroup.add(btnEmployee);

    employeeView = new EmployeeView(jframe, mainView, user, employeeService);
    previousPanel = employeeView;
    employeeView.setBounds(130, 10, 1450, 650);
    add(employeeView);
    setSize(1400, 650);

  }

  public void initEvents() {

    btnEmployee.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        employeeView = new EmployeeView(jframe, mainView, user, employeeService);
        ViewUtils.changeEmpView(selfReference, employeeView, previousPanel);
        previousPanel = employeeView;

      }
    });
    btnAdresses.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        employeeAdressView = new EmployeeAdressView(jframe, mainView, user, employeeAdressService);
        ViewUtils.changeEmpView(selfReference, employeeAdressView, previousPanel);
        previousPanel = employeeAdressView;

      }
    });

    btnContacts.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        employeeContactView = new EmployeeContactView(jframe, mainView, user,
            employeeContactService);
        ViewUtils.changeEmpView(selfReference, employeeContactView, previousPanel);
        previousPanel = employeeContactView;

      }
    });

  }
}
