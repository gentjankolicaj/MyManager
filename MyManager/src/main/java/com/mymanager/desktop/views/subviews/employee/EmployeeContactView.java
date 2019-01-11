package com.mymanager.desktop.views.subviews.employee;

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
import com.mymanager.data.models.EmployeeContact;
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserContact;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.services.EmployeeContactService;
import com.mymanager.services.EmployeeContactServiceImpl;
import com.mymanager.services.UserContactService;
import com.mymanager.services.UserContactServiceImpl;
import com.mymanager.utils.AppUtil;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class EmployeeContactView extends MyPanel {

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
	private MyPanel selfReference;
	private MainView mainView;

	private List<EmployeeContact> currentContactList;

	// Service fields
	private EmployeeContactService employeeContactService;
	private User user;

	/**
	 * Create the panel.
	 */
	public EmployeeContactView(JFrame jframe, MainView mainView,User user,EmployeeContactService employeeContactService) {
		super(1200, 550);
		this.jframe = jframe;
		this.mainView = mainView;
		this.selfReference = this;
        
		this.user=user;
		this.employeeContactService=employeeContactService;


		initComponents();
		initEvents();

	}

	private void initComponents() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("EMPLOYEE CONTACTS");
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
		tableModel.setColumnIdentifiers(new String[] { "Id", "Employee Id", "Telephone", "Celular", "Email", "Fax",
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

					searchContacts();


			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					EmployeeContact contactToDelete = currentContactList.get(selectedRow);

					try {

						employeeContactService.deleteContact(contactToDelete);

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

				AppUtil.returnToMainView(jframe, selfReference, mainView);

			}
		});

	}

	private void searchContacts(){
		String searchValue = textFieldSearch.getText().trim();
		emptyTable();
		if (rdbtnId.isSelected()) {
			EmployeeContact tmp=null;
			try{
				tmp= employeeContactService.getContact(Integer.parseInt(searchValue));
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(tmp!=null)
			currentContactList.add(tmp);
			fillTable(currentContactList);
		} else if (rdbtnPersonId.isSelected()) {
			EmployeeContact tmp=null;
			try{
				tmp= employeeContactService.getContact(Integer.parseInt(searchValue));
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(tmp!=null)
			currentContactList.add(tmp);
			fillTable(currentContactList);
		} else if (rdbtnCelular.isSelected()) {
			try {
				
				currentContactList = employeeContactService.getContactsByCelular(Integer.parseInt(searchValue));
				
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			fillTable(currentContactList);

		} else if (rdbtnEmail.isSelected()) {
			try {
				
				currentContactList = employeeContactService.getContactsByEmail(searchValue);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			fillTable(currentContactList);

		} 

	}

	private void emptyTable() {
		currentContactList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private void fillTable(List<EmployeeContact> contactsList) {
		if (contactsList != null&&contactsList.size()!=0) {
			Object[] rowData = new Object[10];
			for (EmployeeContact contact : contactsList) {
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

	public void loadData() {

		emptyTable();

		try {

			currentContactList =employeeContactService.getAllContacts(Config.ROW_LIMIT, Config.EMPLOYEE_CONTACT_OFFSET);

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (currentContactList != null && currentContactList.size() != 0) {
			Object[] rowData = new Object[10];
			for (EmployeeContact contact : currentContactList) {
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
}
