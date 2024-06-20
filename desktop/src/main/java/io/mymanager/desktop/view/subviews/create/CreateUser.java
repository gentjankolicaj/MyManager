package io.mymanager.desktop.view.subviews.create;

import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.Gender;
import io.mymanager.desktop.data.models.Rights;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.data.models.UserAdress;
import io.mymanager.desktop.data.models.UserContact;
import io.mymanager.desktop.enums.MessageType;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.CountryService;
import io.mymanager.desktop.service.UserAdressService;
import io.mymanager.desktop.service.UserContactService;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.service.impl.CountryServiceImpl;
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
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.apache.commons.lang3.math.NumberUtils;

public class CreateUser extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -3547202059282319569L;

  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  // ================================================================
  // Field services
  private final UserService userService;
  private final User user;
  private final UserContactService userContactService;
  private final UserAdressService userAdressService;
  private final CountryService countryService;
  private final ButtonGroup buttonGroupSex = new ButtonGroup();
  private JTextField id;
  private JTextField firstname;
  private JTextField lastname;
  private JTextField birthplace;
  private JTextField birthday;
  private JComboBox userTypeComboBox;
  private DefaultComboBoxModel<String> userTypeModel;
  private JTextField rights;
  private JPasswordField textFieldNewPassword;
  private JPasswordField textFieldRetypePassword;
  private JPanel passwordPanel;
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
  private DefaultComboBoxModel<String> comboBoxModel;
  private JButton btnSave;
  private JButton btnBack;
  private JRadioButton rdbtnM;
  private JRadioButton rdbtnF;

  /**
   * Create the dialog.
   */
  public CreateUser(UserService userService, UserContactService userContactService,
      UserAdressService userAdressService, User user) {
    this.selfReference = this;
    setResizable(false);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    this.userService = userService;
    this.user = user;
    this.userContactService = userContactService;
    this.userAdressService = userAdressService;
    this.countryService = new CountryServiceImpl();

    initComponents();
    loadCountries();
    initButtonEvents();
  }

  private void initComponents() {
    setTitle("Create new user ");
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-admin-2.png"));
    setBounds(100, 100, 997, 653);
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

    JLabel label = new JLabel("User ID :");
    label.setFont(new Font("Tahoma", Font.BOLD, 11));
    label.setBounds(23, 50, 60, 14);
    detailsPanel.add(label);

    JLabel label_1 = new JLabel("First name :");
    label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_1.setBounds(333, 10, 75, 19);
    detailsPanel.add(label_1);

    JLabel label_2 = new JLabel("Last name :");
    label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_2.setBounds(661, 11, 75, 19);
    detailsPanel.add(label_2);

    JLabel lblSex = new JLabel("Sex :");
    lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblSex.setBounds(41, 87, 42, 19);
    detailsPanel.add(lblSex);

    JLabel label_4 = new JLabel("Birthplace :");
    label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_4.setBounds(333, 47, 75, 19);
    detailsPanel.add(label_4);

    JLabel label_5 = new JLabel("Birthday  :");
    label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_5.setBounds(661, 49, 75, 19);
    detailsPanel.add(label_5);

    JLabel label_6 = new JLabel("User type  :");
    label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_6.setBounds(333, 87, 66, 19);
    detailsPanel.add(label_6);

    JLabel label_7 = new JLabel("Rights  :");
    label_7.setBounds(0, 294, 75, 19);
    detailsPanel.add(label_7);

    id = new JTextField();
    id.setBounds(84, 47, 218, 20);
    detailsPanel.add(id);
    id.setColumns(10);

    firstname = new JTextField();
    firstname.setColumns(10);
    firstname.setBounds(407, 11, 218, 20);
    detailsPanel.add(firstname);

    lastname = new JTextField();
    lastname.setColumns(10);
    lastname.setBounds(736, 11, 218, 20);
    detailsPanel.add(lastname);

    birthplace = new JTextField();
    birthplace.setColumns(10);
    birthplace.setBounds(407, 48, 218, 20);
    detailsPanel.add(birthplace);

    birthday = new JTextField();
    birthday.setText("01 01 1970");
    birthday.setToolTipText("dd MM yyyy");
    birthday.setColumns(10);
    birthday.setBounds(736, 48, 218, 20);
    detailsPanel.add(birthday);

    userTypeComboBox = new JComboBox();
    userTypeComboBox.setToolTipText("ADMIN or MANAGER or HR or ASSISTANT");
    userTypeComboBox.setBounds(404, 87, 221, 19);

    userTypeModel = new DefaultComboBoxModel();
    fillUserTypeComboBox();

    userTypeComboBox.setModel(userTypeModel);

    detailsPanel.add(userTypeComboBox);

    JLabel lblRights = new JLabel("Rights  :");
    lblRights.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblRights.setBounds(661, 89, 60, 19);
    detailsPanel.add(lblRights);

    rights = new JTextField();
    rights.setToolTipText("READ,WRITE,UPDATE,DELETE");
    rights.setText(null);
    rights.setColumns(10);
    rights.setBounds(736, 86, 218, 20);
    detailsPanel.add(rights);

    rdbtnM = new JRadioButton("M");
    buttonGroupSex.add(rdbtnM);
    rdbtnM.setBounds(84, 84, 48, 23);
    detailsPanel.add(rdbtnM);

    rdbtnF = new JRadioButton("F");
    buttonGroupSex.add(rdbtnF);
    rdbtnF.setBounds(134, 85, 48, 23);
    detailsPanel.add(rdbtnF);

    passwordPanel = new JPanel();
    passwordPanel.setBorder(
        new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Password", TitledBorder.LEADING,
            TitledBorder.TOP, null, new Color(0, 0, 0)));
    passwordPanel.setBounds(10, 155, 961, 107);
    contentPanel.add(passwordPanel);
    passwordPanel.setLayout(null);

    JLabel lblNew = new JLabel("New :");
    lblNew.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblNew.setBounds(199, 43, 40, 19);
    passwordPanel.add(lblNew);

    textFieldNewPassword = new JPasswordField();
    textFieldNewPassword.setText(null);
    textFieldNewPassword.setColumns(10);
    textFieldNewPassword.setBounds(243, 43, 218, 20);
    passwordPanel.add(textFieldNewPassword);

    JLabel lblRetype = new JLabel("Re-type  :");
    lblRetype.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblRetype.setBounds(505, 43, 65, 19);
    passwordPanel.add(lblRetype);

    textFieldRetypePassword = new JPasswordField();
    textFieldRetypePassword.setText(null);
    textFieldRetypePassword.setColumns(10);
    textFieldRetypePassword.setBounds(572, 43, 218, 20);
    passwordPanel.add(textFieldRetypePassword);

    contactPanel = new JPanel();
    contactPanel.setLayout(null);
    contactPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contact details",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    contactPanel.setBounds(10, 273, 964, 125);
    contentPanel.add(contactPanel);

    lblContactId = new JLabel("Contact ID :");
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
    adressPanel.setBounds(10, 409, 964, 133);
    contentPanel.add(adressPanel);

    lblAdressId = new JLabel("Adress ID :");
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

    comboBoxModel = new DefaultComboBoxModel<>();
    comboBoxCountry.setModel(comboBoxModel);

    adressPanel.add(comboBoxCountry);

    btnSave = new JButton("Save");
    btnSave.setBounds(338, 570, 111, 34);
    contentPanel.add(btnSave);

    btnBack = new JButton("Back");
    btnBack.setBounds(480, 570, 111, 34);
    contentPanel.add(btnBack);

  }

  private void initButtonEvents() {
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        savePanelsData();
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

  private int saveDetails() {
    char[] newPassArray = textFieldNewPassword.getPassword();
    String newPass = String.valueOf(newPassArray);
    String genderStr = rdbtnM.isSelected() ? "M" : "F";
    String rightsStr = rights.getText();
    String userTypeStr = (String) userTypeComboBox.getSelectedItem();
    String birthdayStr = birthday.getText();
    LocalDate birthday = null;
    if (birthdayStr.equals("")) {
      birthdayStr = "01 01 1972";
      try {
        birthday = DateTimeUtils.parseToLocalDate(birthdayStr, "dd MM yyyy");
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      try {

        birthday = DateTimeUtils.parseToLocalDate(birthdayStr, "dd MM yyyy");
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    if (rightsStr.equals("")) {
      rightsStr = Rights.READ.toString();
    }

    User newUser = new User(id.getText(), userTypeStr, firstname.getText(), lastname.getText(),
        newPass,
        birthday, birthplace.getText(), Gender.valueOf(genderStr), rightsStr,
        user.getUserId(), user.getUserId(), LocalDateTime.now(), LocalDateTime.now());
    try {
      userService.saveUser(newUser);
      WindowUtils.showMessage(this, "New user created", MessageType.INFORMATION);

    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
    return 1;
  }

  private int saveContact() {
    String telephone = textFieldTelephone.getText();
    String celular = textFieldCel.getText();

    if (!NumberUtils.isParsable(telephone)) {
      telephone = "35501";
    }

    if (!NumberUtils.isParsable(celular)) {
      celular = "069";
    }

    UserContact newContact = new UserContact(1, id.getText(), Integer.parseInt(telephone),
        Integer.parseInt(celular), textFieldEmail.getText(), textFieldFax.getText(),
        user.getUserId(),
        user.getUserId(), LocalDateTime.now(), LocalDateTime.now());

    try {

      userContactService.saveContact(newContact);

    } catch (Exception e) {

      e.printStackTrace();
      return 0;
    }

    return 1;
  }

  private int saveAdress() {
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

    UserAdress newAdress = new UserAdress(1, id.getText(), new Country(countryName),
        textFieldCity.getText(), textFieldStreet.getText(), Integer.parseInt(zipCode),
        textFieldBuilding.getText(), user.getUserId(), user.getUserId(), LocalDateTime.now(),
        LocalDateTime.now());

    try {

      userAdressService.saveAdress(newAdress);

    } catch (Exception e) {

      e.printStackTrace();
      return 0;
    }

    return 1;
  }

  private void savePanelsData() {
    if (validatePasswords()) {
      if (saveDetails() == 1) {
        if (saveContact() == 1) {
          saveAdress();
        }
      }

    }
  }

  private void loadCountries() {
    comboBoxModel.removeAllElements();
    List<Country> temp = null;
    try {
      temp = countryService.getAllCountries();

    } catch (Exception e) {
      e.printStackTrace();
    }
    if (temp != null && temp.size() != 0) {
      for (Country country : temp) {
        comboBoxModel.addElement(country.getCountryName());
      }

    }
  }

  private boolean validatePasswords() {
    char[] newPassArray = textFieldNewPassword.getPassword();
    char[] retypedNewPassArray = textFieldRetypePassword.getPassword();
    String newPass = String.valueOf(newPassArray);
    String reTypedNewPass = String.valueOf(retypedNewPassArray);

    if (newPass.equals(reTypedNewPass) && (!newPass.equals(""))) {
      return true;
    } else {
      WindowUtils.showMessage(this, "Passwords don't match !!!", MessageType.INFORMATION);
      return false;
    }

  }

  private void fillUserTypeComboBox() {
    userTypeModel.addElement("ADMIN");
    userTypeModel.addElement("USER");
    userTypeModel.addElement("MANAGER");
    userTypeModel.addElement("HR");
    userTypeModel.addElement("FINANCE");
    userTypeModel.addElement("ASSISTANT");
  }
}
