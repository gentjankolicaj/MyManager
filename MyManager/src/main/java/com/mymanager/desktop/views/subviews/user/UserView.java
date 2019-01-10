package com.mymanager.desktop.views.subviews.user;

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
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserAdress;
import com.mymanager.data.models.UserContact;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.create.CreateUser;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.desktop.views.subviews.edit.EditUser;
import com.mymanager.services.UserAdressService;
import com.mymanager.services.UserAdressServiceImpl;
import com.mymanager.services.UserContactService;
import com.mymanager.services.UserContactServiceImpl;
import com.mymanager.services.UserService;
import com.mymanager.utils.AppUtil;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserView extends MyPanel {

	private static final long serialVersionUID = 2586092764218526222L;
	private JTextField textFieldSearch;

	private DefaultTableModel tableModel;
	private MyTable table;

	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnFirstname;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnType;
	private JRadioButton rdbtnLastname;

	private List<User> currentUserList;

	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;
	
	
	
	//================================================================
	//Field services
	private UserService userService;
	private User user;
	private UserContactService userContactService;
	private UserAdressService userAdressService;

	/**
	 * Create the panel.
	 */
	public UserView(JFrame jframe, MainView mainView, UserService userService,User user) {
		super(1200, 550);
		this.jframe = jframe;
		this.mainView = mainView;
		this.userService=userService;
		this.user=user;
		this.userContactService=new UserContactServiceImpl();
		this.userAdressService=new UserAdressServiceImpl();
		
		selfReference = this;

		initComponents();
		initEvents();

	}

	private void initComponents() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("All registered users");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 230, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 93, 913, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("ID");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(83, 66, 56, 25);
		add(rdbtnId);

		rdbtnType = new JRadioButton("User type");
		buttonGroupSearchType.add(rdbtnType);
		rdbtnType.setBounds(141, 66, 95, 25);
		add(rdbtnType);

		rdbtnFirstname = new JRadioButton("Firstname");
		buttonGroupSearchType.add(rdbtnFirstname);
		rdbtnFirstname.setBounds(240, 66, 90, 25);
		add(rdbtnFirstname);

		rdbtnLastname = new JRadioButton("Lastname");
		buttonGroupSearchType.add(rdbtnLastname);
		rdbtnLastname.setBounds(332, 65, 89, 25);
		add(rdbtnLastname);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(942, 93, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 136, 1068, 402);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "User type", "Firstname", "Lastname", "Birthday",
				"Birthplace", "Rights", "Gender", "Created by", "Created date", "Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);
		btnCreate = new JButton("Create");
		btnCreate.setBounds(1090, 140, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(1090, 178, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(1090, 216, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(1090, 300, 97, 25);
		add(btnBack);
	}

	private void initEvents() {

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					searchUsers();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateUser createUser = new CreateUser(userService ,userContactService,userAdressService,user);
				createUser.setModal(true);
				createUser.setVisible(true);
				loadData();

			}
		});

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					User oldUser = currentUserList.get(selectedRow);
					
					UserContact oldContact=null;
					UserAdress oldAdress=null;
					try {
						oldContact = userContactService.getContactByPersonId(oldUser.getUserId());
					    oldAdress = userAdressService.getAdressesByPersonId(oldUser.getUserId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				

					EditUser editUser = new EditUser(userService,userContactService,userAdressService,user, oldUser, oldContact,oldAdress);
					editUser.setModal(true);
					editUser.setVisible(true);
					loadData();
				}
			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					User userToDelete = currentUserList.get(selectedRow);
					try {
						userService.deleteUser(userToDelete);
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
				AppUtil.returnToMainView(jframe, selfReference, mainView);
			}
		});

	}

	private void searchUsers() throws Exception {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (rdbtnId.isSelected()) {
			User temp = userService.getUser(searchValue);
			currentUserList.add(temp);
			fillTable(currentUserList);

		} else if (rdbtnType.isSelected()) {
			currentUserList = userService.getUsersByUserType(searchValue);
			fillTable(currentUserList);

		} else if (rdbtnFirstname.isSelected()) {
			currentUserList =userService.getUsersByFirstName( searchValue);
			fillTable(currentUserList);

		} else if (rdbtnLastname.isSelected()) {
			currentUserList = userService.getUsersByLastName(searchValue);
			fillTable(currentUserList);

		} else {

			// to do some info message

		}

	}

	private void emptyTable() {
		currentUserList = new ArrayList<>();
		tableModel.setRowCount(0);
	}


	private void fillTable(List<User> usersList) {
		if (usersList != null) {
			Object[] rowData = new Object[12];
			for (User user : usersList) {
				rowData[0] = user.getUserId();
				rowData[1] = user.getUserType();
				rowData[2] = user.getFirstName();
				rowData[3] = user.getLastName();
				rowData[4] = user.getBirthday();
				rowData[5] = user.getBirthplace();
				rowData[6] = user.getRights();
				rowData[7] = user.getGender();
				rowData[8] = user.getCreatedBy();
				rowData[9] = user.getCreatedDate();
				rowData[10] = user.getUpdatedBy();
				rowData[11] = user.getUpdatedDate();
				tableModel.addRow(rowData);
			}
		}
	}

	public void loadData() {
		emptyTable();
		
		try {
			
			currentUserList = userService.getAllUsers(Config.ROW_LIMIT, Config.USER_OFFSET);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(currentUserList!=null&&currentUserList.size()!=0) {
			
		Object[] rowData = new Object[12];
		for (User user : currentUserList) {
			rowData[0] = user.getUserId();
			rowData[1] = user.getUserType();
			rowData[2] = user.getFirstName();
			rowData[3] = user.getLastName();
			rowData[4] = user.getBirthday();
			rowData[5] = user.getBirthplace();
			rowData[6] = user.getRights();
			rowData[7] = user.getGender();
			rowData[8] = user.getCreatedBy();
			rowData[9] = user.getCreatedDate();
			rowData[10] = user.getUpdatedBy();
			rowData[11] = user.getUpdatedDate();
			tableModel.addRow(rowData);
		}
		
	   }
		
	}

}
