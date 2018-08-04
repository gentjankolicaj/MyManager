package com.mymanager.views.subviews.user;

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

import com.mymanager.config.Config;
import com.mymanager.controllers.UserController;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Contact;
import com.mymanager.data.models.ContactType;
import com.mymanager.data.models.MyTable;
import com.mymanager.utils.AppUtil;
import com.mymanager.views.MainView;
import com.mymanager.views.subviews.custom.MyPanel;

public class UserContactView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2586092764218526222L;
	private JTextField textFieldSearch;

	private DefaultTableModel tableModel;
	private MyTable table;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnEmail;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnPersonId;
	private JRadioButton rdbtnCelular;

	private JFrame jframe;
	private UserController userController;
	private MyPanel selfReference;
	private MainView mainView;

	private List<Contact> currentContactList;

	/**
	 * Create the panel.
	 */
	public UserContactView(JFrame jframe, MainView mainView, UserController userController) {
		super(1200, 550);
		this.jframe = jframe;
		this.mainView = mainView;
		this.userController = userController;
		selfReference = this;
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("All user contacts");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 230, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(10, 92, 913, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("ID");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(83, 66, 56, 25);
		add(rdbtnId);

		rdbtnPersonId = new JRadioButton("User ID");
		buttonGroupSearchType.add(rdbtnPersonId);
		rdbtnPersonId.setBounds(141, 66, 81, 25);
		add(rdbtnPersonId);

		rdbtnCelular = new JRadioButton("Cel");
		buttonGroupSearchType.add(rdbtnCelular);
		rdbtnCelular.setBounds(229, 66, 56, 25);
		add(rdbtnCelular);

		rdbtnEmail = new JRadioButton("Email");
		buttonGroupSearchType.add(rdbtnEmail);
		rdbtnEmail.setBounds(293, 66, 81, 25);
		add(rdbtnEmail);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(940, 92, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 1068, 405);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "User ID", "Telephone", "Celular", "Email", "Fax",
				"Created by", "Created date", "Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(1088, 142, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(1088, 178, 97, 25);
		add(btnBack);
	}

	private void initEvents() {
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				loadContacts();

			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					Contact contactToDelete = currentContactList.get(selectedRow);
					userController.deleteContact(ContactType.USER_CONTACT, contactToDelete);
					loadData();
				}

			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AppUtil.returnToMainView(jframe, selfReference, mainView);
			}
		});

	}

	private void loadContacts() {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (chooseSearchType() == 1) {
			Contact temp = userController.getContact(QueryType.NORMAL, ContactType.USER_CONTACT,
					Integer.parseInt(searchValue));
			currentContactList.add(temp);
			fillTable(currentContactList);
		} else if (chooseSearchType() == 2) {
			Contact temp = userController.getContactByPersonId(QueryType.NORMAL, ContactType.USER_CONTACT, searchValue);
			currentContactList.add(temp);
			fillTable(currentContactList);
		} else if (chooseSearchType() == 3) {
			currentContactList = userController.getContactsByCelular(QueryType.NORMAL, ContactType.USER_CONTACT,
					Integer.parseInt(searchValue));
			fillTable(currentContactList);

		} else if (chooseSearchType() == 4) {
			currentContactList = userController.getContactsByEmail(QueryType.NORMAL, ContactType.USER_CONTACT,
					searchValue);
			fillTable(currentContactList);

		} else {

			// to do some info message

		}

	}

	private int chooseSearchType() {
		if (rdbtnId.isSelected()) {
			return 1;
		} else if (rdbtnPersonId.isSelected()) {
			return 2;
		} else if (rdbtnCelular.isSelected()) {
			return 3;
		} else if (rdbtnEmail.isSelected()) {
			return 4;
		} else
			return 0;
	}

	private void emptyTable() {
		currentContactList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private void fillTable(List<Contact> contactList) {
		Object[] rowData = new Object[10];
		for (Contact contact : contactList) {
			rowData[0] = contact.getContactId();
			rowData[1] = contact.getPersonId();
			rowData[2] = contact.getTelephone();
			rowData[3] = contact.getCelular();
			rowData[4] = contact.getEmail();
			rowData[5] = contact.getFax();
			rowData[6] = contact.getCreatedBy();
			rowData[7] = contact.getCreatedDate();
			rowData[8] = contact.getUpdatedBy();
			rowData[9] = contact.getUpdatedDate();
			tableModel.addRow(rowData);
		}
	}

	public void loadData() {
		emptyTable();
		currentContactList = userController.getAllContacts(QueryType.NORMAL, ContactType.USER_CONTACT, Config.ROW_LIMIT,
				Config.USER_OFFSET);
		Object[] rowData = new Object[10];
		for (Contact contact : currentContactList) {
			rowData[0] = contact.getContactId();
			rowData[1] = contact.getPersonId();
			rowData[2] = contact.getTelephone();
			rowData[3] = contact.getCelular();
			rowData[4] = contact.getEmail();
			rowData[5] = contact.getFax();
			rowData[6] = contact.getCreatedBy();
			rowData[7] = contact.getCreatedDate();
			rowData[8] = contact.getUpdatedBy();
			rowData[9] = contact.getUpdatedDate();
			tableModel.addRow(rowData);
		}
	}
}
