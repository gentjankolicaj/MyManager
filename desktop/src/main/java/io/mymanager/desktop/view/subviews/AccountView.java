package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.Gender;
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
import io.mymanager.desktop.service.impl.UserAdressServiceImpl;
import io.mymanager.desktop.service.impl.UserContactServiceImpl;
import io.mymanager.desktop.util.CustomCollectionUtils;
import io.mymanager.desktop.util.WindowUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.apache.commons.lang3.math.NumberUtils;

public class AccountView extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -3547202059282319569L;

  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  // Service fields
  private final UserService userService;
  private final UserAdressService userAdressService;
  private final UserContactService userContactService;
  private final CountryService countryService;
  private JTextField id;
  private JTextField firstname;
  private JTextField lastname;
  private JTextField gender;
  private JTextField birthplace;
  private JTextField birthday;
  private JTextField usertype;
  private JTextField rights;
  // Password panel
  private JPasswordField textFieldOldPassword;
  private JPasswordField textFieldNewPassword;
  private JPasswordField textFieldRetypePassword;
  private JButton btnSavePassword;
  private JPanel passwordPanel;
  private JLabel lblNewLabel;
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
  private JButton buttonBack2;
  private JButton btnSave;
  private JButton btnBack;
  private User user;
  private UserContact userContact;
  private UserAdress userAdress;

  /**
   * Create the dialog.
   */
  public AccountView(UserService userService, User user) {
    this.selfReference = this;
    setResizable(false);
    setAlwaysOnTop(true);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    this.userService = userService;
    this.user = user;
    this.userAdressService = new UserAdressServiceImpl();
    this.userContactService = new UserContactServiceImpl();
    this.countryService = new CountryServiceImpl();

    // IMPORTANT field are to initialized ,else =>NPE
    try {
      this.userContact = userContactService.getContactByPersonId(user.getUserId());
      this.userAdress = userAdressService.getAdressesByPersonId(user.getUserId());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    initComponents();

    initPanelEvents();

    initButtonEvents();

    initPasswordPanelEvents();

    loadPanelsData();
  }

  private void initComponents() {
    setTitle("My Account");
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

    JLabel label_3 = new JLabel("Gender :");
    label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
    label_3.setBounds(23, 86, 75, 19);
    detailsPanel.add(label_3);

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

    gender = new JTextField();
    gender.setColumns(10);
    gender.setBounds(84, 87, 218, 20);
    detailsPanel.add(gender);

    birthplace = new JTextField();
    birthplace.setColumns(10);
    birthplace.setBounds(407, 48, 218, 20);
    detailsPanel.add(birthplace);

    birthday = new JTextField();
    birthday.setColumns(10);
    birthday.setBounds(736, 48, 218, 20);
    detailsPanel.add(birthday);

    usertype = new JTextField();
    usertype.setColumns(10);
    usertype.setBounds(404, 87, 221, 19);
    detailsPanel.add(usertype);

    JLabel lblRights = new JLabel("Rights  :");
    lblRights.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblRights.setBounds(661, 89, 60, 19);
    detailsPanel.add(lblRights);

    rights = new JTextField();
    rights.setText(null);
    rights.setColumns(10);
    rights.setBounds(736, 86, 218, 20);
    detailsPanel.add(rights);

    passwordPanel = new JPanel();
    passwordPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Change password",
        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    passwordPanel.setBounds(10, 155, 961, 107);
    contentPanel.add(passwordPanel);
    passwordPanel.setLayout(null);

    JLabel lblOld = new JLabel("Actual  :");
    lblOld.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblOld.setBounds(14, 22, 57, 29);
    passwordPanel.add(lblOld);

    textFieldOldPassword = new JPasswordField();
    textFieldOldPassword.setText(null);
    textFieldOldPassword.setColumns(10);
    textFieldOldPassword.setBounds(81, 26, 218, 20);
    passwordPanel.add(textFieldOldPassword);

    JLabel lblNew = new JLabel("New :");
    lblNew.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblNew.setBounds(360, 27, 40, 19);
    passwordPanel.add(lblNew);

    textFieldNewPassword = new JPasswordField();
    textFieldNewPassword.setText(null);
    textFieldNewPassword.setColumns(10);
    textFieldNewPassword.setBounds(404, 27, 218, 20);
    passwordPanel.add(textFieldNewPassword);

    JLabel lblRetype = new JLabel("Re-type  :");
    lblRetype.setFont(new Font("Tahoma", Font.BOLD, 11));
    lblRetype.setBounds(666, 27, 65, 19);
    passwordPanel.add(lblRetype);

    textFieldRetypePassword = new JPasswordField();
    textFieldRetypePassword.setText(null);
    textFieldRetypePassword.setColumns(10);
    textFieldRetypePassword.setBounds(733, 27, 218, 20);
    passwordPanel.add(textFieldRetypePassword);

    btnSavePassword = new JButton("Save");
    btnSavePassword.setBounds(30, 73, 89, 23);
    passwordPanel.add(btnSavePassword);

    lblNewLabel = new JLabel("");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
    lblNewLabel.setBounds(309, 74, 642, 22);
    passwordPanel.add(lblNewLabel);

    buttonBack2 = new JButton("Back");
    buttonBack2.setBounds(131, 73, 89, 23);
    passwordPanel.add(buttonBack2);

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

    comboBoxModel = new DefaultComboBoxModel();
    comboBoxCountry.setModel(comboBoxModel);

    adressPanel.add(comboBoxCountry);

    btnSave = new JButton("Save");
    btnSave.setBounds(338, 570, 111, 34);
    contentPanel.add(btnSave);

    btnBack = new JButton("Back");
    btnBack.setBounds(480, 570, 111, 34);
    contentPanel.add(btnBack);

  }

  private void initPanelEvents() {
    getContentPane().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        lblNewLabel.setText("");
      }
    });

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

  private void initPasswordPanelEvents() {
    btnSavePassword.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        changePassword();

      }
    });

    buttonBack2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        selfReference.dispose();
      }
    });
  }

  private void loadDetails() {
    id.setText(user.getUserId());
    firstname.setText(user.getFirstName());
    lastname.setText(user.getLastName());
    gender.setText(user.getGender().name());
    birthplace.setText(user.getBirthplace());
    birthday.setText(user.getBirthday().toString());
    usertype.setText(user.getUserType());
    rights.setText(user.getRights());

  }

  private void loadContact() {
    if (userContact != null) {
      textFieldContactId.setText(String.valueOf(userContact.getContactId()));
      textFieldTelephone.setText(String.valueOf(userContact.getTelephone()));
      textFieldCel.setText(String.valueOf(userContact.getCelular()));
      textFieldEmail.setText(userContact.getEmail());
      textFieldFax.setText(userContact.getFax());
    }
  }

  private void loadAdress() {
    if (userAdress != null) {
      textFieldAdressId.setText(String.valueOf(userAdress.getAdressId()));
      textFieldZipCode.setText(String.valueOf(userAdress.getZipCode()));
      textFieldStreet.setText(userAdress.getStreetName());
      textFieldBuilding.setText(userAdress.getBuilding());
      textFieldCity.setText(userAdress.getCity());
      Country country = userAdress.getCountry();
      comboBoxCountry.setSelectedItem(country.getCountryName());
    }
  }

  private void loadPanelsData() {
    loadCountries();
    loadDetails();
    loadContact();// selects first element from the list
    loadAdress();// selects first element from the list

  }

  private void saveDetails() {

    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> second = new ArrayList<>();

    first.add(user.getUserId());
    first.add(user.getFirstName());
    first.add(user.getLastName());
    first.add(user.getGender().toString());
    first.add(user.getBirthplace());
    first.add(user.getBirthday().toString());
    first.add(user.getUserType());
    first.add(user.getRights());

    second.add(id.getText());
    second.add(firstname.getText());
    second.add(lastname.getText());
    second.add(gender.getText());
    second.add(birthplace.getText());
    second.add(birthday.getText());
    second.add(usertype.getText());
    second.add(rights.getText());

    if (!CustomCollectionUtils.areEquals(first, second)) {
      User newUser = new User(id.getText(), usertype.getText(), firstname.getText(),
          lastname.getText(),
          user.getPassword(), LocalDate.parse(birthday.getText()), birthplace.getText(),
          Gender.valueOf(gender.getText()), rights.getText(), user.getCreatedBy(), user.getUserId(),
          user.getCreatedDate(), LocalDateTime.now());
      try {

        userService.updateUser(user, newUser);
        user = newUser;

      } catch (Exception e) {

        e.printStackTrace();
      }

    }

  }

  private void saveContact() {
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> second = new ArrayList<>();
    if (userContact != null) {
      first.add(String.valueOf(userContact.getTelephone()));
      first.add(String.valueOf(userContact.getCelular()));
      first.add(userContact.getEmail());
      first.add(userContact.getFax());
      second.add(textFieldTelephone.getText());
      second.add(textFieldCel.getText());
      second.add(textFieldEmail.getText());
      second.add(textFieldFax.getText());

      if (!CustomCollectionUtils.areEquals(first, second)) {
        UserContact newUserContact = new UserContact(userContact.getContactId(),
            userContact.getPersonId(),
            Integer.parseInt(textFieldTelephone.getText()),
            Integer.parseInt(textFieldCel.getText()),
            textFieldEmail.getText(), textFieldFax.getText(), userContact.getCreatedBy(),
            user.getUserId(),
            userContact.getCreatedDate(), LocalDateTime.now());

        try {
          userContactService.updateContact(userContact, newUserContact);
          userContact = newUserContact;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

    } else {

      String telephone = textFieldTelephone.getText();
      String celular = textFieldCel.getText();

      if (!NumberUtils.isParsable(telephone)) {
        telephone = "35501";
      }

      if (!NumberUtils.isParsable(celular)) {
        celular = "069";
      }

      UserContact newUserContact = new UserContact(1, user.getUserId(), Integer.parseInt(telephone),
          Integer.parseInt(celular), textFieldEmail.getText(), textFieldFax.getText(),
          user.getUserId(),
          user.getUserId(), LocalDateTime.now(), LocalDateTime.now());

      try {

        userContactService.saveContact(newUserContact);
        userContact = newUserContact;

      } catch (Exception e) {

        e.printStackTrace();
      }
    }

  }

  private void saveAdress() {
    ArrayList<String> first = new ArrayList<>();
    ArrayList<String> second = new ArrayList<>();
    if (userAdress != null) {
      Object countryObject = comboBoxCountry.getSelectedItem();
      String countryName = "";

      if (countryObject == null) {
        countryName = "ALBANIA";
      } else {
        countryName = countryObject.toString().trim();
      }

      String actualCountryName = userAdress.getCountry().getCountryName();
      first.add(String.valueOf(userAdress.getZipCode()));
      first.add(userAdress.getStreetName());
      first.add(userAdress.getBuilding());
      first.add(userAdress.getCity());
      first.add(actualCountryName);
      second.add(textFieldZipCode.getText());
      second.add(textFieldStreet.getText());
      second.add(textFieldBuilding.getText());
      second.add(textFieldCity.getText());
      second.add(countryName);

      if (!CustomCollectionUtils.areEquals(first, second)) {

        String zipCode = textFieldZipCode.getText();

        if (!NumberUtils.isParsable(zipCode)) {
          zipCode = "0000";
        }

        UserAdress newUserAdress = new UserAdress(1, user.getUserId(), new Country(countryName),
            textFieldCity.getText(), textFieldStreet.getText(), Integer.parseInt(zipCode),
            textFieldBuilding.getText(), userAdress.getCreatedBy(), user.getUserId(),
            userAdress.getCreatedDate(), LocalDateTime.now());

        try {
          userAdressService.updateAdress(userAdress, newUserAdress);
          userAdress = newUserAdress;
        } catch (Exception e) {

          e.printStackTrace();
        }
      }

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

      UserAdress newUserAdress = new UserAdress(1, user.getUserId(), new Country(countryName),
          textFieldCity.getText(), textFieldStreet.getText(), Integer.parseInt(zipCode),
          textFieldBuilding.getText(), user.getUserId(), user.getUserId(), LocalDateTime.now(),
          LocalDateTime.now());

      try {

        userAdressService.saveAdress(newUserAdress);
        userAdress = newUserAdress;

      } catch (Exception e) {

        e.printStackTrace();
      }
    }
  }

  private void savePanelsData() {
    saveDetails();
    saveContact();
    saveAdress();
  }

  private void loadCountries() {
    if (comboBoxModel.getSize() > 0) {
      comboBoxModel.removeAllElements();
    }

    List<Country> countriesList = null;
    try {
      countriesList = countryService.getAllCountries();
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (countriesList != null && countriesList.size() != 0) {
      for (Country country : countriesList) {
        comboBoxModel.addElement(country.getCountryName());
      }

    }
  }

  private void changePassword() {
    char[] oldPassArray = textFieldOldPassword.getPassword();
    char[] newPassArray = textFieldNewPassword.getPassword();
    char[] retypedNewPassArray = textFieldRetypePassword.getPassword();
    String oldPassword = String.valueOf(oldPassArray);
    String newPassword = String.valueOf(newPassArray);
    String reTypedNewPassword = String.valueOf(retypedNewPassArray);

    try {
      if (userService.validatePassword(oldPassword, user)) {
        if (newPassword.equals(reTypedNewPassword)) {
          User newUser = new User(user.getUserId(), user.getUserType(), user.getFirstName(),
              user.getLastName(), newPassword, user.getBirthday(), user.getBirthplace(),
              user.getGender(),
              user.getRights(), user.getCreatedBy(), user.getUserId(), user.getCreatedDate(),
              LocalDateTime.now());
          userService.updateUser(user, newUser);
          user = newUser;
          lblNewLabel.setText("Password changed.");
        } else {
          lblNewLabel.setText("New password don't match.");
        }

      } else {
        lblNewLabel.setText("Password you typed is not the same as actual password.");
      }
    } catch (Exception e1) {
      WindowUtils.showMessage(null, e1.getMessage(), MessageType.ERROR);

    }

  }
}
