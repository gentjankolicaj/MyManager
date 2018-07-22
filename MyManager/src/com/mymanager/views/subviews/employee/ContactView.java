package com.mymanager.views.subviews.employee;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mymanager.data.models.Contact;
import com.mymanager.data.models.MyTable;

public class ContactView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2586092764218526222L;
	private JTextField textFieldSearch;

	private int width = 1250;
	private int height = 650;
	private DefaultTableModel tableModel;
	private MyTable table;

	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnTelephone;
	private JRadioButton rdbtnEmail;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnPersonId;
	private JRadioButton rdbtnCelular;
	private JRadioButton rdbtnFax;

	/**
	 * Create the panel.
	 */
	public ContactView() {
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
		textFieldSearch.setBounds(12, 115, 913, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("Id");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(83, 66, 56, 25);
		add(rdbtnId);

		rdbtnPersonId = new JRadioButton("Person Id");
		buttonGroupSearchType.add(rdbtnPersonId);
		rdbtnPersonId.setBounds(141, 66, 95, 25);
		add(rdbtnPersonId);

		rdbtnTelephone = new JRadioButton("Tel");
		buttonGroupSearchType.add(rdbtnTelephone);
		rdbtnTelephone.setBounds(240, 66, 56, 25);
		add(rdbtnTelephone);

		rdbtnCelular = new JRadioButton("Cel");
		buttonGroupSearchType.add(rdbtnCelular);
		rdbtnCelular.setBounds(300, 67, 56, 25);
		add(rdbtnCelular);

		rdbtnEmail = new JRadioButton("Email");
		buttonGroupSearchType.add(rdbtnEmail);
		rdbtnEmail.setBounds(364, 67, 81, 25);
		add(rdbtnEmail);

		rdbtnFax = new JRadioButton("Fax");
		buttonGroupSearchType.add(rdbtnFax);
		rdbtnFax.setBounds(443, 66, 83, 25);
		add(rdbtnFax);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(937, 115, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 174, 1068, 460);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "User Id", "Telephone", "Celular", "Email", "Fax",
				"Created by", "Created date", "Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);
		btnCreate = new JButton("Create");
		btnCreate.setBounds(1092, 184, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(1092, 222, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(1092, 260, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(1092, 319, 97, 25);
		add(btnBack);
	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				addContacts();
			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				clearTable();
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

	}

	public int getMyHeight() {
		return height;
	}

	public int getMyWidth() {
		return width;
	}

	private void clearTable() {
		tableModel.setRowCount(0);
	}

	private int chooseSearchType() {
		if (rdbtnId.isSelected()) {
			return 1;
		} else if (rdbtnPersonId.isSelected()) {
			return 2;
		} else if (rdbtnTelephone.isSelected()) {
			return 3;
		} else if (rdbtnCelular.isSelected()) {
			return 4;
		} else if (rdbtnEmail.isSelected()) {
			return 5;
		} else if (rdbtnFax.isSelected()) {
			return 6;
		} else
			return 0;
	}

	private void addContacts() {
		List<Contact> contactsList = null;
		Object[] rowData = new Object[10];
		for (Contact contact : contactsList) {
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
