package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.Department;
import io.mymanager.desktop.data.models.Employee;
import io.mymanager.desktop.data.models.EmployeeAdress;
import io.mymanager.desktop.data.models.EmployeeContact;
import io.mymanager.desktop.data.models.Gender;
import io.mymanager.desktop.data.models.Job;
import io.mymanager.desktop.data.models.Project;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.enums.MessageType;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.CountryService;
import io.mymanager.desktop.service.DepartmentService;
import io.mymanager.desktop.service.EmployeeAdressService;
import io.mymanager.desktop.service.EmployeeContactService;
import io.mymanager.desktop.service.EmployeeService;
import io.mymanager.desktop.service.JobService;
import io.mymanager.desktop.service.ProjectService;
import io.mymanager.desktop.service.impl.CountryServiceImpl;
import io.mymanager.desktop.service.impl.DepartmentServiceImpl;
import io.mymanager.desktop.service.impl.JobServiceImpl;
import io.mymanager.desktop.service.impl.ProjectServiceImpl;
import io.mymanager.desktop.util.DateTimeUtils;
import io.mymanager.desktop.util.WindowUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.apache.commons.lang3.math.NumberUtils;

public class EditEmployee extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -3547202059282319569L;

  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final ButtonGroup buttonGroupSex = new ButtonGroup();
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
  private final EmployeeService employeeService;
  private final EmployeeAdressService employeeAdressService;
  private final EmployeeContactService employeeContactService;
  private final CountryService countryService;
  private final JobService jobService;
  private final DepartmentService departmentService;
  private final ProjectService projectService;
  private final User user;
  private final Employee oldEmployee;
  private final EmployeeAdress oldEmployeeAdress;
  private final EmployeeContact oldEmployeeContact;
  private JTextField tfId;
  private JTextField tfFirstName;
  private JTextField tfLastName;
  private JTextField tfBirthplace;
  private JTextField tfBirthday;
  private JPanel contactPanel;
  private JLabel lblContactId;
  private JLabel lblTel;
  private JLabel lblCel;
  private JLabel lblEmail;
  private JLabel label_16;
  private JTextField textFieldContactId;
  private JTextField textFieldTelephone;
  private JTextField textFieldCel;
  private JTextField textFieldEmail;
  private JLabel lblFax;
  private JTextField textFieldFax;
  private JPanel adressPanel;
  private JLabel lblAdressId;
  private JLabel lblZipCode;
  private JLabel lblStreet;

  // ================================================================
  // Field services
  private JLabel lblBuilding;
  private JLabel lblCity;
  private JLabel label_26;
  private JTextField textFieldAdressId;
  private JTextField textFieldZipCode;
  private JTextField textFieldStreet;
  private JTextField textFieldBuilding;
  private JTextField textFieldCity;
  private JLabel lblCountry;
  private JComboBox comboBoxCountry;
  private DefaultComboBoxModel<String> countryModel;
  private JButton btnSave;
  private JButton btnBack;
  private JRadioButton rdbtnM;
  private JRadioButton rdbtnF;
  private JPanel workPanel;
  private JLabel lblJob;
  private JLabel label_11;
  private JComboBox jobComboBox;
  private DefaultComboBoxModel jobModel;
  private JLabel lblDepartment;
  private JComboBox departmentComboBox;
  private DefaultComboBoxModel departmentModel;
  private JComboBox projectComboBox;
  private DefaultComboBoxModel projectModel;
  private JTextField tfMiddleName;

  /**
   * Create the dialog.
   */
  public EditEmployee(EmployeeService employeeService, EmployeeAdressService employeeAdressService,
      EmployeeContactService employeeContactService,
      User user, Employee oldEmployee, EmployeeAdress oldEmployeeAdress,
      EmployeeContact oldEmployeeContact) {
    this.selfReference = this;
    setResizable(false);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.employeeService = employeeService;
    this.employeeAdressService = employeeAdressService;
    this.employeeContactService = employeeContactService;
    this.user = user;
    this.oldEmployee = oldEmployee;
    this.oldEmployeeAdress = oldEmployeeAdress;
    this.oldEmployeeContact = oldEmployeeContact;
    this.countryService = new CountryServiceImpl();
    this.projectService = new ProjectServiceImpl();
    this.departmentService = new DepartmentServiceImpl();
    this.jobService = new JobServiceImpl();

    initComponents();

    fillComboBoxes();

    initButtonEvents();

    populatePanelData();

  }

  private void populatePanelData() {
    populateDetails();
    populateContact();
    populateAdress();
    populateWorkDetails();
  }


  private void loadCountries() {
    countryModel.removeAllElements();
    List<Country> temp = null;
    try {
      temp = countryService.getAllCountries();

    } catch (Exception e) {
      e.printStackTrace();
    }
    if (temp != null && temp.size() != 0) {
      for (Country country : temp) {
        countryModel.addElement(country.getCountryName());
      }

    }
  }

  private void populateDetails() {
    tfId.setText(oldEmployee.getEmployeeId());
    tfId.setEditable(false);
    tfFirstName.setText(oldEmployee.getFirstName());
    tfLastName.setText(oldEmployee.getLastName());
    tfBirthplace.setText(oldEmployee.getBirthplace());
    tfBirthday.setText(oldEmployee.getBirthday().format(formatter));
    tfMiddleName.setText(oldEmployee.getMiddleName());

    if (oldEmployee.getGender().equals(Gender.M)) {
      rdbtnM.setSelected(true);
    } else {
      rdbtnF.setSelected(true);
    }

  }

  private void populateContact() {
    if (oldEmployeeContact != null) {
      textFieldContactId.setText(String.valueOf(oldEmployeeContact.getContactId()));
      textFieldTelephone.setText(String.valueOf(oldEmployeeContact.getTelephone()));
      textFieldCel.setText(String.valueOf(oldEmployeeContact.getCelular()));
      textFieldEmail.setText(oldEmployeeContact.getEmail());
      textFieldFax.setText(oldEmployeeContact.getFax());
    }
  }

  private void populateAdress() {
    if (oldEmployeeAdress != null) {
      textFieldAdressId.setText(String.valueOf(oldEmployeeAdress.getAdressId()));
      textFieldZipCode.setText(String.valueOf(oldEmployeeAdress.getZipCode()));
      textFieldStreet.setText(oldEmployeeAdress.getStreetName());
      textFieldBuilding.setText(oldEmployeeAdress.getBuilding());
      textFieldCity.setText(oldEmployeeAdress.getCity());
      Country country = oldEmployeeAdress.getCountry();
      comboBoxCountry.setSelectedItem(country.getCountryName());
    }
  }

  private void populateWorkDetails() {
    int jobIdValue = oldEmployee.getJobId();
    int departmentIdValue = oldEmployee.getDepartmentId();
    String projectNameValue = oldEmployee.getProjectName();

    if (oldEmployee.getJobId() != 0) {
      Integer jobId = Integer.valueOf(jobIdValue);
      jobModel.setSelectedItem(jobId);
    }

    if (departmentIdValue != 0) {
      Integer departmentId = Integer.valueOf(departmentIdValue);
      departmentModel.setSelectedItem(departmentId);
    }

    if (projectNameValue != null && !projectNameValue.equals("")) {
      projectModel.setSelectedItem(projectNameValue);
    }
  }

  private void initComponents() {
    setTitle("Edit employee");
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-admin-2.png"));
    setBounds(100, 100, 997, 664);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    JPanel detailsPanel = new JPanel();
    detailsPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Personal details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    detailsPanel.setBounds(10, 11, 964, 133);
    contentPanel.add(detailsPanel);
    detailsPanel.setLayout(null);

    JLabel lblEmpId = new JLabel("Emp Id :");
    lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblEmpId.setBounds(23, 50, 60, 14);
    detailsPanel.add(lblEmpId);

    JLabel label_1 = new JLabel("First name :");
    label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_1.setBounds(333, 10, 75, 19);
    detailsPanel.add(label_1);

    JLabel label_2 = new JLabel("Last name :");
    label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_2.setBounds(333, 86, 75, 19);
    detailsPanel.add(label_2);

    JLabel lblSex = new JLabel("Sex :");
    lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblSex.setBounds(690, 89, 42, 19);
    detailsPanel.add(lblSex);

    JLabel label_4 = new JLabel("Birthplace :");
    label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_4.setBounds(661, 10, 75, 19);
    detailsPanel.add(label_4);

    JLabel label_5 = new JLabel("Birthday  :");
    label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_5.setBounds(661, 49, 75, 19);
    detailsPanel.add(label_5);

    JLabel label_7 = new JLabel("Rights  :");
    label_7.setBounds(0, 294, 75, 19);
    detailsPanel.add(label_7);

    tfId = new JTextField();
    tfId.setBounds(84, 47, 218, 20);
    detailsPanel.add(tfId);
    tfId.setColumns(10);

    tfFirstName = new JTextField();
    tfFirstName.setColumns(10);
    tfFirstName.setBounds(407, 11, 218, 20);
    detailsPanel.add(tfFirstName);

    tfLastName = new JTextField();
    tfLastName.setColumns(10);
    tfLastName.setBounds(408, 86, 218, 20);
    detailsPanel.add(tfLastName);

    tfBirthplace = new JTextField();
    tfBirthplace.setColumns(10);
    tfBirthplace.setBounds(735, 11, 218, 20);
    detailsPanel.add(tfBirthplace);

    tfBirthday = new JTextField();
    tfBirthday.setText("01 01 1970");
    tfBirthday.setToolTipText("dd MM yyyy");
    tfBirthday.setColumns(10);
    tfBirthday.setBounds(736, 48, 218, 20);
    detailsPanel.add(tfBirthday);

    rdbtnM = new JRadioButton("M");
    buttonGroupSex.add(rdbtnM);
    rdbtnM.setBounds(733, 86, 48, 23);
    detailsPanel.add(rdbtnM);

    rdbtnF = new JRadioButton("F");
    buttonGroupSex.add(rdbtnF);
    rdbtnF.setBounds(783, 87, 48, 23);
    detailsPanel.add(rdbtnF);

    tfMiddleName = new JTextField();
    tfMiddleName.setColumns(10);
    tfMiddleName.setBounds(408, 44, 218, 20);
    detailsPanel.add(tfMiddleName);

    JLabel lblMiddle = new JLabel("Middle name :");
    lblMiddle.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblMiddle.setBounds(321, 44, 87, 19);
    detailsPanel.add(lblMiddle);

    contactPanel = new JPanel();
    contactPanel.setLayout(null);
    contactPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contact details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    contactPanel.setBounds(10, 155, 964, 125);
    contentPanel.add(contactPanel);

    lblContactId = new JLabel("Contact Id :");
    lblContactId.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblContactId.setBounds(23, 50, 75, 14);
    contactPanel.add(lblContactId);

    lblTel = new JLabel("Tel :");
    lblTel.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblTel.setBounds(362, 28, 37, 19);
    contactPanel.add(lblTel);

    lblCel = new JLabel("Cel  :");
    lblCel.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblCel.setBounds(683, 28, 43, 19);
    contactPanel.add(lblCel);

    lblEmail = new JLabel("Email  :");
    lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblEmail.setBounds(351, 68, 48, 19);
    contactPanel.add(lblEmail);

    label_16 = new JLabel("Rights  :");
    label_16.setBounds(0, 294, 75, 19);
    contactPanel.add(label_16);

    textFieldContactId = new JTextField();
    textFieldContactId.setEditable(false);
    textFieldContactId.setText(null);
    textFieldContactId.setColumns(10);
    textFieldContactId.setBounds(94, 47, 208, 20);
    contactPanel.add(textFieldContactId);

    textFieldTelephone = new JTextField();
    textFieldTelephone.setText(null);
    textFieldTelephone.setColumns(10);
    textFieldTelephone.setBounds(407, 28, 218, 20);
    contactPanel.add(textFieldTelephone);

    textFieldCel = new JTextField();
    textFieldCel.setText(null);
    textFieldCel.setColumns(10);
    textFieldCel.setBounds(736, 28, 218, 20);
    contactPanel.add(textFieldCel);

    textFieldEmail = new JTextField();
    textFieldEmail.setText(null);
    textFieldEmail.setColumns(10);
    textFieldEmail.setBounds(404, 67, 221, 19);
    contactPanel.add(textFieldEmail);

    lblFax = new JLabel("Fax  :");
    lblFax.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblFax.setBounds(682, 68, 54, 19);
    contactPanel.add(lblFax);

    textFieldFax = new JTextField();
    textFieldFax.setText(null);
    textFieldFax.setColumns(10);
    textFieldFax.setBounds(736, 66, 218, 20);
    contactPanel.add(textFieldFax);

    adressPanel = new JPanel();
    adressPanel.setLayout(null);
    adressPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Adress details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    adressPanel.setBounds(10, 291, 964, 133);
    contentPanel.add(adressPanel);

    lblAdressId = new JLabel("Adress Id :");
    lblAdressId.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblAdressId.setBounds(23, 50, 75, 14);
    adressPanel.add(lblAdressId);

    lblZipCode = new JLabel("Zip code :");
    lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblZipCode.setBounds(333, 24, 75, 19);
    adressPanel.add(lblZipCode);

    lblStreet = new JLabel("Street :");
    lblStreet.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblStreet.setBounds(661, 25, 75, 19);
    adressPanel.add(lblStreet);

    lblBuilding = new JLabel("Building :");
    lblBuilding.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblBuilding.setBounds(333, 61, 75, 19);
    adressPanel.add(lblBuilding);

    lblCity = new JLabel("City :");
    lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblCity.setBounds(661, 63, 75, 19);
    adressPanel.add(lblCity);

    label_26 = new JLabel("Rights  :");
    label_26.setBounds(0, 294, 75, 19);
    adressPanel.add(label_26);

    textFieldAdressId = new JTextField();
    textFieldAdressId.setEditable(false);
    textFieldAdressId.setText(null);
    textFieldAdressId.setColumns(10);
    textFieldAdressId.setBounds(91, 47, 211, 20);
    adressPanel.add(textFieldAdressId);

    textFieldZipCode = new JTextField();
    textFieldZipCode.setText(null);
    textFieldZipCode.setColumns(10);
    textFieldZipCode.setBounds(407, 25, 218, 20);
    adressPanel.add(textFieldZipCode);

    textFieldStreet = new JTextField();
    textFieldStreet.setText(null);
    textFieldStreet.setColumns(10);
    textFieldStreet.setBounds(736, 25, 218, 20);
    adressPanel.add(textFieldStreet);

    textFieldBuilding = new JTextField();
    textFieldBuilding.setText(null);
    textFieldBuilding.setColumns(10);
    textFieldBuilding.setBounds(407, 62, 218, 20);
    adressPanel.add(textFieldBuilding);

    textFieldCity = new JTextField();
    textFieldCity.setText(null);
    textFieldCity.setColumns(10);
    textFieldCity.setBounds(736, 62, 218, 20);
    adressPanel.add(textFieldCity);

    lblCountry = new JLabel("Country  :");
    lblCountry.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblCountry.setBounds(661, 103, 60, 19);
    adressPanel.add(lblCountry);

    comboBoxCountry = new JComboBox();
    comboBoxCountry.setBounds(736, 100, 218, 20);

    countryModel = new DefaultComboBoxModel<>();
    comboBoxCountry.setModel(countryModel);

    adressPanel.add(comboBoxCountry);

    btnSave = new JButton("Save");
    btnSave.setBounds(334, 588, 111, 34);
    contentPanel.add(btnSave);

    btnBack = new JButton("Back");
    btnBack.setBounds(476, 588, 111, 34);
    contentPanel.add(btnBack);

    workPanel = new JPanel();
    workPanel.setLayout(null);
    workPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Work details", TitledBorder.LEADING,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
    workPanel.setBounds(10, 444, 964, 133);
    contentPanel.add(workPanel);

    lblJob = new JLabel("Job :");
    lblJob.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblJob.setBounds(333, 24, 75, 19);
    workPanel.add(lblJob);

    label_11 = new JLabel("Rights  :");
    label_11.setBounds(0, 294, 75, 19);
    workPanel.add(label_11);

    jobComboBox = new JComboBox();
    jobComboBox.setBounds(389, 23, 218, 20);

    jobModel = new DefaultComboBoxModel();
    jobComboBox.setModel(jobModel);

    workPanel.add(jobComboBox);

    lblDepartment = new JLabel("Department :");
    lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblDepartment.setBounds(651, 27, 75, 19);
    workPanel.add(lblDepartment);

    departmentComboBox = new JComboBox();
    departmentComboBox.setBounds(736, 24, 218, 20);

    departmentModel = new DefaultComboBoxModel();
    departmentComboBox.setModel(departmentModel);

    workPanel.add(departmentComboBox);

    projectComboBox = new JComboBox();
    projectComboBox.setBounds(85, 24, 218, 20);

    projectModel = new DefaultComboBoxModel();
    projectComboBox.setModel(projectModel);

    workPanel.add(projectComboBox);

    JLabel lblProject = new JLabel("Project  :");
    lblProject.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblProject.setBounds(10, 27, 60, 19);
    workPanel.add(lblProject);

  }

  private void initButtonEvents() {
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        updatePanelsData();
        selfReference.dispose();
      }
    });

    btnBack.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        selfReference.dispose();
      }
    });

  }


  private int updateDetails() {
    String empId = tfId.getText();
    String firstName = tfFirstName.getText();
    String middleName = tfMiddleName.getText();
    String lastName = tfLastName.getText();
    String sex = rdbtnM.isSelected() ? "M" : "F";
    String birthplace = tfBirthplace.getText();

    String birthdayStr = tfBirthday.getText();

    LocalDate birthday = null;
    if (birthdayStr.equals("")) {

      birthdayStr = "01 01 1972";
      try {
        birthday = DateTimeUtils.parseToLocalDate(birthdayStr, "dd MM yyyy");
      } catch (ParseException e) {
        e.printStackTrace();
      }
    } else {
      try {
        birthday = DateTimeUtils.parseToLocalDate(birthdayStr, "dd MM yyyy");
      } catch (ParseException e) {
        e.printStackTrace();
      }

    }

    Object jobObject = jobComboBox.getSelectedItem();
    Object departmentObject = departmentComboBox.getSelectedItem();
    Object projectObject = projectComboBox.getSelectedItem();
    int jobId = 0;
    int departmentId = 0;
    String projectName = null;

    if (jobObject != null) {
      jobId = (Integer) jobObject;
    }

    if (departmentObject != null) {
      departmentId = (Integer) departmentObject;
    }

    if (projectObject != null) {
      projectName = (String) projectObject;
    }

    Employee newEmployee = new Employee(empId, firstName, lastName, middleName, birthday,
        birthplace,
        Gender.valueOf(sex), jobId, departmentId, projectName, oldEmployee.getCreatedBy(),
        user.getUserId(),
        oldEmployee.getCreatedDate(), LocalDateTime.now());

    try {

      employeeService.updateEmployee(oldEmployee, newEmployee);

    } catch (java.sql.SQLIntegrityConstraintViolationException c) {
      c.printStackTrace();
      WindowUtils.showMessage(this, "Employee must have job,department and project set.",
          MessageType.ERROR);
      return 0;

    } catch (Exception e) {

      e.printStackTrace();
      return 0;
    }
    return 1;
  }

  private int updateContact() {
    if (oldEmployeeContact != null) {
      String telephone = textFieldTelephone.getText();
      String celular = textFieldCel.getText();

      if (!NumberUtils.isParsable(telephone)) {
        telephone = "35501";
      }

      if (!NumberUtils.isParsable(celular)) {
        celular = "069";
      }

      EmployeeContact newContact = new EmployeeContact(1, tfId.getText(),
          Integer.parseInt(telephone),
          Integer.parseInt(celular), textFieldEmail.getText(), textFieldFax.getText(),
          oldEmployeeContact.getCreatedBy(),
          user.getUserId(), oldEmployeeContact.getCreatedDate(), LocalDateTime.now());

      try {

        employeeContactService.updateContact(oldEmployeeContact, newContact);

      } catch (Exception e) {

        e.printStackTrace();
        return 0;
      }

      return 1;

    } else {

      String telephone = textFieldTelephone.getText();
      String celular = textFieldCel.getText();

      if (!NumberUtils.isParsable(telephone)) {
        telephone = "35501";
      }

      if (!NumberUtils.isParsable(celular)) {
        celular = "069";
      }

      EmployeeContact newContact = new EmployeeContact(1, tfId.getText(),
          Integer.parseInt(telephone),
          Integer.parseInt(celular), textFieldEmail.getText(), textFieldFax.getText(),
          user.getUserId(),
          user.getUserId(), LocalDateTime.now(), LocalDateTime.now());

      try {

        employeeContactService.saveContact(newContact);

      } catch (Exception e) {

        e.printStackTrace();
        return 0;
      }

      return 1;

    }
  }

  private int updateAdress() {
    if (oldEmployeeAdress != null) {

      Object countryObject = comboBoxCountry.getSelectedItem();
      String countryName = "";

      if (countryObject == null) {
        countryName = "ALBANIA";
      } else {
        countryName = countryObject.toString().trim();
      }

      String zipCode = textFieldZipCode.getText();

      if (!NumberUtils.isParsable(zipCode)) {
        zipCode = "0000";
      }

      EmployeeAdress newAdress = new EmployeeAdress(1, tfId.getText(), new Country(countryName),
          textFieldCity.getText(), textFieldStreet.getText(), Integer.parseInt(zipCode),
          textFieldBuilding.getText(), oldEmployeeAdress.getCreatedBy(), user.getUserId(),
          oldEmployeeAdress.getCreatedDate(),
          LocalDateTime.now());

      try {

        employeeAdressService.updateAdress(oldEmployeeAdress, newAdress);

      } catch (Exception e) {

        e.printStackTrace();
        return 0;
      }
      return 1;

    } else {

      Object countryObject = comboBoxCountry.getSelectedItem();
      String countryName = "";

      if (countryObject == null) {
        countryName = "ALBANIA";
      } else {
        countryName = countryObject.toString().trim();
      }

      String zipCode = textFieldZipCode.getText();

      if (!NumberUtils.isParsable(zipCode)) {
        zipCode = "0000";
      }

      EmployeeAdress newAdress = new EmployeeAdress(1, tfId.getText(), new Country(countryName),
          textFieldCity.getText(), textFieldStreet.getText(), Integer.parseInt(zipCode),
          textFieldBuilding.getText(), user.getUserId(), user.getUserId(), LocalDateTime.now(),
          LocalDateTime.now());

      try {

        employeeAdressService.saveAdress(newAdress);

      } catch (Exception e) {

        e.printStackTrace();
        return 0;
      }
      return 1;
    }

  }


  private void updatePanelsData() {
    if (updateDetails() == 1) {
      if (updateContact() == 1) {
        if (updateAdress() == 1) {
          WindowUtils.showMessage(this, "Changes saved.", MessageType.INFORMATION);
        }
      }
    }

  }


  private void fillComboBoxes() {
    fillComboBoxCountry();
    fillComboBoxProject();
    fillComboBoxJob();
    fillComboBoxDepartment();
  }

  private void fillComboBoxCountry() {
    countryModel.removeAllElements();
    List<Country> temp = null;
    try {
      temp = countryService.getAllCountries();

    } catch (Exception e) {
      e.printStackTrace();
    }
    if (temp != null && temp.size() != 0) {
      for (Country country : temp) {
        countryModel.addElement(country.getCountryName());
      }

    }
  }


  private void fillComboBoxProject() {
    projectModel.removeAllElements();
    List<Project> tmp = null;

    try {

      tmp = projectService.getAllProjects();

    } catch (Exception e) {
      e.printStackTrace();
    }
    if (tmp != null && tmp.size() != 0) {
      for (Project var : tmp) {
        projectModel.addElement(var.getProjectName());
      }

    }
  }


  private void fillComboBoxJob() {
    jobModel.removeAllElements();
    List<Job> tmp = null;

    try {

      tmp = jobService.getAllJobs();

    } catch (Exception e) {
      e.printStackTrace();
    }
    if (tmp != null && tmp.size() != 0) {
      for (Job var : tmp) {
        jobModel.addElement(var.getJobId());
      }

    }
  }

  private void fillComboBoxDepartment() {
    departmentModel.removeAllElements();
    List<Department> tmp = null;

    try {

      tmp = departmentService.getAllDepartments();

    } catch (Exception e) {
      e.printStackTrace();
    }
    if (tmp != null && tmp.size() != 0) {
      for (Department var : tmp) {
        departmentModel.addElement(var.getDepartmentId());
      }
    }
  }


}
