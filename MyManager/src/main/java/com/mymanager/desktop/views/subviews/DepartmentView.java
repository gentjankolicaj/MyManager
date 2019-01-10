package com.mymanager.desktop.views.subviews;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mymanager.config.Config;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Department;
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.User;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.create.CreateDepartment;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.desktop.views.subviews.edit.EditDepartment;
import com.mymanager.services.DepartmentService;
import com.mymanager.services.DepartmentServiceImpl;
import com.mymanager.services.UserService;
import com.mymanager.utils.AppUtil;

public class DepartmentView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2191151781811208739L;

	private JTextField textFieldSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JButton btnSearch;
	private DefaultTableModel tableModel;
	private MyTable table;
	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnName;
	private List<Department> currentDepartmentList;

	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;

	// Service fields
	private UserService userService;
	private DepartmentService departmentService;
	private User user;

	/**
	 * Create the panel.
	 */
	public DepartmentView(JFrame jframe, MainView mainView, UserService userService, User user) {
		super(1070, 545);
		this.jframe = jframe;
		this.mainView = mainView;
		this.selfReference = this;

		this.userService = userService;
		this.user = user;
		this.departmentService = new DepartmentServiceImpl();

		setBorder(new LineBorder(new Color(0, 0, 0)));

		initComponents();
		initEvents();

	}

	private void initComponents() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("All registered departments");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 221, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 98, 771, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		rdbtnId = new JRadioButton("ID");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(92, 66, 71, 25);
		add(rdbtnId);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnName = new JRadioButton("Name");
		buttonGroupSearchType.add(rdbtnName);
		rdbtnName.setBounds(159, 66, 153, 25);
		add(rdbtnName);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(813, 98, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 140, 939, 387);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "Name", "Manager ID", "Created by", "Created date",
				"Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);

		btnCreate = new JButton("Create");
		btnCreate.setBounds(961, 156, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(961, 194, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(961, 232, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(961, 291, 97, 25);
		add(btnBack);
	}

	private void initEvents() {

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchDepartments();
			}
		});

		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateDepartment createDepartment = new CreateDepartment(departmentService, user);
				createDepartment.setModal(true);
				createDepartment.setVisible(true);

				loadData();

			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					Department oldDepartment = currentDepartmentList.get(selectedRow);
					EditDepartment editDepartment = new EditDepartment(departmentService, user, oldDepartment);
					editDepartment.setModal(true);
					editDepartment.setVisible(true);

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
					Department departmentToDelete = currentDepartmentList.get(selectedRow);
					try {
						departmentService.deleteDepartment(departmentToDelete);
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

	private void searchDepartments() {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (rdbtnId.isSelected()) {
			Department temp = null;
			try {
				temp = departmentService.getDepartment(searchValue);
			} catch (Exception e) {

				e.printStackTrace();
			}
			if (temp != null)
				currentDepartmentList.add(temp);
			fillTable(currentDepartmentList);

		} else if (rdbtnName.isSelected()) {
			try {
				currentDepartmentList = departmentService.getDepartments(searchValue);
			} catch (Exception e) {

				e.printStackTrace();
			}
			fillTable(currentDepartmentList);

		} else {

		}

	}

	private void emptyTable() {
		currentDepartmentList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private void fillTable(List<Department> departmentsList) {
		if (departmentsList != null && departmentsList.size() != 0) {
			Object[] rowData = new Object[7];
			for (Department department : departmentsList) {
				rowData[0] = department.getDepartmentId();
				rowData[1] = department.getDepartmentName();
				rowData[2] = department.getManagerId();
				rowData[3] = department.getCreatedBy();
				rowData[4] = department.getCreatedDate();
				rowData[5] = department.getUpdatedBy();
				rowData[6] = department.getUpdatedDate();
				tableModel.addRow(rowData);
			}
		}
	}

	public void loadData() {
		emptyTable();
		try {

			currentDepartmentList = departmentService.getAllDepartments(Config.ROW_LIMIT, Config.DEPARTMENT_OFFSET);

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (currentDepartmentList != null && currentDepartmentList.size() != 0) {
			Object[] rowData = new Object[7];
			for (Department department : currentDepartmentList) {
				rowData[0] = department.getDepartmentId();
				rowData[1] = department.getDepartmentName();
				rowData[2] = department.getManagerId();
				rowData[3] = department.getCreatedBy();
				rowData[4] = department.getCreatedDate();
				rowData[5] = department.getUpdatedBy();
				rowData[6] = department.getUpdatedDate();
				tableModel.addRow(rowData);
			}

		}
	}

}
