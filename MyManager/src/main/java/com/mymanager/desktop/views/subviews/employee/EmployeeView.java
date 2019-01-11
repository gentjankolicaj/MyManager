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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mymanager.data.models.Employee;
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.User;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.services.EmployeeService;
import com.mymanager.services.UserService;
import com.mymanager.utils.AppUtil;

public class EmployeeView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2586092764218526222L;
	private JTextField tfSearch;

	
	//panel properties
	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;
	
	
	
	private DefaultTableModel tableModel;
	private MyTable table;

	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnFirstname;
	private JRadioButton rdbtnDepartment;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnLastname;
	private List<Employee> currentEmployeeList;
	
	
	
	//Service fields
	private EmployeeService employeeService;
	private User user;
	private JRadioButton rdbtnJob;

	/**
	 * Create the panel.
	 */
	public EmployeeView(JFrame jframe, MainView mainView, User user,EmployeeService employeeService) {
		super(1300,  600);
		this.jframe = jframe;
		this.mainView = mainView;
		this.selfReference=this;
		this.employeeService=employeeService;
		this.user=user;
		
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("All employees");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(455, 11, 230, 31);
		add(lblNewLabel);

		tfSearch = new JTextField();
		tfSearch.setBounds(12, 85, 1023, 30);
		add(tfSearch);
		tfSearch.setColumns(10);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearcchBy.setBounds(12, 43, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("Id");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(83, 46, 56, 25);
		add(rdbtnId);

		rdbtnFirstname = new JRadioButton("Firstname");
		buttonGroupSearchType.add(rdbtnFirstname);
		rdbtnFirstname.setBounds(141, 46, 95, 25);
		add(rdbtnFirstname);

		rdbtnLastname = new JRadioButton("Lastname");
		buttonGroupSearchType.add(rdbtnLastname);
		rdbtnLastname.setBounds(238, 46, 83, 25);
		add(rdbtnLastname);

		rdbtnDepartment = new JRadioButton("Departmet Id");
		buttonGroupSearchType.add(rdbtnDepartment);
		rdbtnDepartment.setBounds(409, 46, 110, 25);
		add(rdbtnDepartment);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(1045, 85, 138, 30);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 127, 1171, 462);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Id", "Firstname", "Middle","Lastname", "Birthday",
				"Birthplace","Gender", "Job Id","Dep Id ","Project","Created by", "Created date", "Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);
		btnCreate = new JButton("Create");
		btnCreate.setBounds(1191, 143, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(1191, 181, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(1191, 219, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(1191, 278, 97, 25);
		add(btnBack);
		
		rdbtnJob = new JRadioButton("Job Id");
		buttonGroupSearchType.add(rdbtnJob);
		rdbtnJob.setBounds(332, 46, 75, 25);
		add(rdbtnJob);
	}

	private void initEvents() {
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
              searchEmployees();
				
			}
		});
		
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				
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
				
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AppUtil.returnToMainView(jframe, selfReference, mainView);
			}
		});

	}
	
	
	private void emptyTable() {
	currentEmployeeList=new ArrayList<>();
	tableModel.setRowCount(0);
	
	}

	private void searchEmployees() {
		String searchValue=tfSearch.getText().trim();
		emptyTable();
		if(rdbtnId.isSelected()) {
			Employee tmp=null;
			try {
				tmp=employeeService.getEmployee(searchValue);
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(tmp!=null)
				currentEmployeeList.add(tmp);
			fillTable(currentEmployeeList);
			
		}else if(rdbtnFirstname.isSelected()) {
			try {
				currentEmployeeList=employeeService.getEmployeesByFirstName(searchValue);
			}catch(Exception e) {
				e.printStackTrace();
			}
			fillTable(currentEmployeeList);
		}else if(rdbtnLastname.isSelected()) {
			try {
				currentEmployeeList=employeeService.getEmployeesByLastName(searchValue);
			}catch(Exception e) {
				e.printStackTrace();
			}
			fillTable(currentEmployeeList);
		}else if(rdbtnDepartment.isSelected()) {
			try {
				currentEmployeeList=employeeService.getEmployeesByDepartmentId(Integer.parseInt(searchValue));
			}catch(Exception e) {
				e.printStackTrace();
			}
			fillTable(currentEmployeeList);
		}
		else if(rdbtnJob.isSelected()) {
			try {
				currentEmployeeList=employeeService.getEmployeesByJobId(Integer.parseInt(searchValue));
			}catch(Exception e) {
				e.printStackTrace();
			}
			fillTable(currentEmployeeList);
		}
		
	}
	
	
	private void fillTable(List<Employee> employeeList) {
		if(employeeList!=null&&employeeList.size()!=0) {
			Object[] row=new Object[14];
			for(Employee var:employeeList) {
				row[0]=var.getEmployeeId();
				row[1]=var.getFirstName();
				row[2]=var.getMiddleName();
				row[3]=var.getLastName();
				row[4]=var.getBirthday();
				row[5]=var.getBirthplace();
				row[6]=var.getGender();
				row[7]=var.getJobId();
				row[8]=var.getDepartmentId();
				row[9]=var.getProjectName();
				row[10]=var.getCreatedBy();
				row[11]=var.getCreatedDate();
				row[12]=var.getUpdatedBy();
				row[13]=var.getUpdatedDate();
				tableModel.addRow(row);
			}
		}
	}
	
	
	@Override
	public void loadData() {
		emptyTable();
		try {
			currentEmployeeList=employeeService.getAllEmployees();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		if(currentEmployeeList!=null&&currentEmployeeList.size()!=0) {
			Object[] row=new Object[14];
			for(Employee var:currentEmployeeList) {
				row[0]=var.getEmployeeId();
				row[1]=var.getFirstName();
				row[2]=var.getMiddleName();
				row[3]=var.getLastName();
				row[4]=var.getBirthday();
				row[5]=var.getBirthplace();
				row[6]=var.getGender();
				row[7]=var.getJobId();
				row[8]=var.getDepartmentId();
				row[9]=var.getProjectName();
				row[10]=var.getCreatedBy();
				row[11]=var.getCreatedDate();
				row[12]=var.getUpdatedBy();
				row[13]=var.getUpdatedDate();
				tableModel.addRow(row);
		     }
		}
	}
	

	public int getMyHeight() {
		return height;
	}

	public int getMyWidth() {
		return width;
	}
}
