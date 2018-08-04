package com.mymanager.views.subviews.create;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

import com.mymanager.controllers.UserController;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.Contact;
import com.mymanager.data.models.ContactType;
import com.mymanager.data.models.Country;
import com.mymanager.data.models.Gender;
import com.mymanager.data.models.Rights;
import com.mymanager.data.models.User;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

public class CreateUser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3547202059282319569L;

	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();

	private JTextField id;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField gender;
	private JTextField birthplace;
	private JTextField birthday;
	private JTextField usertype;
	private JTextField rights;

	private User user;
	private UserController userController;
	private Contact userContact;
	private Adress userAdress;
	private JPasswordField textFieldNewPassword;
	private JPasswordField textFieldRetypePassword;
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
	private JButton btnSave;
	private JButton btnBack;

	/**
	 * Create the dialog.
	 */
	public CreateUser(UserController userController) {
		this.selfReference = this;
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.userController = userController;
		this.user = userController.getUser();
		this.userContact = userController.getContactByPersonId(QueryType.NORMAL, ContactType.USER_CONTACT,
				user.getUserId());
		this.userAdress = userController.getAdressByPersonId(QueryType.NORMAL, AdressType.USER_ADRESS,
				user.getUserId());

		initComponents();

		initButtonEvents();

	}

	private void initComponents() {
		setTitle("My Account");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CreateUser.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
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
		rights.setText((String) null);
		rights.setColumns(10);
		rights.setBounds(736, 86, 218, 20);
		detailsPanel.add(rights);

		passwordPanel = new JPanel();
		passwordPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Password", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		passwordPanel.setBounds(10, 155, 961, 107);
		contentPanel.add(passwordPanel);
		passwordPanel.setLayout(null);

		JLabel lblNew = new JLabel("New :");
		lblNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNew.setBounds(199, 43, 40, 19);
		passwordPanel.add(lblNew);

		textFieldNewPassword = new JPasswordField();
		textFieldNewPassword.setText((String) null);
		textFieldNewPassword.setColumns(10);
		textFieldNewPassword.setBounds(243, 43, 218, 20);
		passwordPanel.add(textFieldNewPassword);

		JLabel lblRetype = new JLabel("Re-type  :");
		lblRetype.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRetype.setBounds(505, 43, 65, 19);
		passwordPanel.add(lblRetype);

		textFieldRetypePassword = new JPasswordField();
		textFieldRetypePassword.setText((String) null);
		textFieldRetypePassword.setColumns(10);
		textFieldRetypePassword.setBounds(572, 43, 218, 20);
		passwordPanel.add(textFieldRetypePassword);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(309, 74, 642, 22);
		passwordPanel.add(lblNewLabel);

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
		textFieldContactId.setText((String) null);
		textFieldContactId.setColumns(10);
		textFieldContactId.setBounds(94, 47, 208, 20);
		contactPanel.add(textFieldContactId);

		textFieldTelephone = new JTextField();
		textFieldTelephone.setText((String) null);
		textFieldTelephone.setColumns(10);
		textFieldTelephone.setBounds(407, 28, 218, 20);
		contactPanel.add(textFieldTelephone);

		textFieldCel = new JTextField();
		textFieldCel.setText((String) null);
		textFieldCel.setColumns(10);
		textFieldCel.setBounds(736, 28, 218, 20);
		contactPanel.add(textFieldCel);

		textFieldEmail = new JTextField();
		textFieldEmail.setText((String) null);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(404, 67, 221, 19);
		contactPanel.add(textFieldEmail);

		lblFax = new JLabel("Fax  :");
		lblFax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFax.setBounds(682, 68, 54, 19);
		contactPanel.add(lblFax);

		textFieldFax = new JTextField();
		textFieldFax.setText((String) null);
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
		textFieldAdressId.setText((String) null);
		textFieldAdressId.setColumns(10);
		textFieldAdressId.setBounds(91, 47, 211, 20);
		adressPanel.add(textFieldAdressId);

		textFieldZipCode = new JTextField();
		textFieldZipCode.setText((String) null);
		textFieldZipCode.setColumns(10);
		textFieldZipCode.setBounds(407, 25, 218, 20);
		adressPanel.add(textFieldZipCode);

		textFieldStreet = new JTextField();
		textFieldStreet.setText((String) null);
		textFieldStreet.setColumns(10);
		textFieldStreet.setBounds(736, 25, 218, 20);
		adressPanel.add(textFieldStreet);

		textFieldBuilding = new JTextField();
		textFieldBuilding.setText((String) null);
		textFieldBuilding.setColumns(10);
		textFieldBuilding.setBounds(407, 62, 218, 20);
		adressPanel.add(textFieldBuilding);

		textFieldCity = new JTextField();
		textFieldCity.setText((String) null);
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

	private void saveDetails() {
		char[] newPassArray = textFieldNewPassword.getPassword();
		String newPass = String.valueOf(newPassArray);
		String genderStr = gender.getText();
		String rightsStr = rights.getText();
		String userTypeStr = usertype.getText();
		String birthdayStr = birthday.getText();

		if (birthdayStr.equals("")) {
			birthdayStr = "1970-12-12";
		}
		if (userTypeStr.equals("")) {
			userTypeStr = "ASSISTANT";
		}
		if (genderStr.equals("")) {
			genderStr = "M";
		}
		if (rightsStr.equals("")) {
			rightsStr = Rights.READ.toString();
		}

		User newUser = new User(id.getText(), userTypeStr, firstname.getText(), lastname.getText(), newPass,
				LocalDate.parse(birthdayStr), birthplace.getText(), Gender.valueOf(genderStr), rightsStr,
				user.getUserId(), user.getUserId(), LocalDateTime.now(), LocalDateTime.now());
		userController.saveUser(newUser);
		UtilWindow.showMessage(this, "New user created", MessageType.INFORMATION);
	}

	private void saveContact() {
		String telephone = textFieldTelephone.getText();
		String celular = textFieldCel.getText();
		if (textFieldTelephone.getText().equals(""))
			telephone = "0";
		if (textFieldCel.getText().equals(""))
			celular = "0";

		Contact newContact = new Contact(1, id.getText(), Integer.parseInt(telephone), Integer.parseInt(celular),
				textFieldEmail.getText(), textFieldFax.getText(), user.getUserId(), user.getUserId(),
				LocalDateTime.now(), LocalDateTime.now());
		userController.saveContact(ContactType.USER_CONTACT, newContact);
	}

	private void saveAdress() {
		String selectedCountryName = (String) comboBoxCountry.getSelectedItem();
		String zipCode = textFieldZipCode.getText();
		if (zipCode.equals(""))
			zipCode = "0";

		Adress newAdress = new Adress(1, id.getText(), new Country(selectedCountryName), textFieldCity.getText(),
				textFieldStreet.getText(), Integer.parseInt(zipCode), textFieldBuilding.getText(), user.getUserId(),
				user.getUserId(), LocalDateTime.now(), LocalDateTime.now());
		userController.saveAdress(AdressType.USER_ADRESS, newAdress);

	}

	private void savePanelsData() {
		if (validatePasswords()) {
			saveDetails();
			saveContact();
			saveAdress();
		}
	}

	private void loadCountries() {
		comboBoxModel.removeAllElements();
		for (Country country : userController.getAllCountries()) {
			comboBoxModel.addElement(country.getCountryName());
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
			UtilWindow.showMessage(this, "Passwords don't match !!!", MessageType.INFORMATION);
			return false;
		}

	}
}
