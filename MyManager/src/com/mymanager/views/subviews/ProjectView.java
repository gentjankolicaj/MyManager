package com.mymanager.views.subviews;

import java.awt.Color;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.Project;
import com.mymanager.utils.AppUtil;
import com.mymanager.views.MainView;
import com.mymanager.views.subviews.create.CreateProject;
import com.mymanager.views.subviews.custom.MyPanel;
import com.mymanager.views.subviews.edit.EditProject;

public class ProjectView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2586092764218526222L;
	private JTextField textFieldSearch;

	private DefaultTableModel tableModel;
	private MyTable table;

	private JButton btnCreate;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnCustomer;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnName;
	private JRadioButton rdbtnDescription;
	private List<Project> currentProjectList;

	private JFrame jframe;
	private UserController userController;
	private MyPanel selfReference;
	private MainView mainView;

	/**
	 * Create the panel.
	 */
	public ProjectView(JFrame jframe, MainView mainView, UserController userController) {
		super(1070, 545);
		this.jframe = jframe;
		this.mainView = mainView;
		this.userController = userController;
		selfReference = this;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		initComponents();
		initEvents();

		loadData();

	}

	private void initComponents() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("All registered projects");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 230, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 93, 779, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnName = new JRadioButton("Name");
		buttonGroupSearchType.add(rdbtnName);
		rdbtnName.setBounds(83, 66, 74, 25);
		add(rdbtnName);

		rdbtnDescription = new JRadioButton("Desc");
		buttonGroupSearchType.add(rdbtnDescription);
		rdbtnDescription.setBounds(162, 66, 68, 25);
		add(rdbtnDescription);

		rdbtnCustomer = new JRadioButton("Customer");
		buttonGroupSearchType.add(rdbtnCustomer);
		rdbtnCustomer.setBounds(232, 66, 95, 25);
		add(rdbtnCustomer);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(811, 93, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 937, 402);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Name", "Description", "Customer", "Country", "Created by",
				"Created date", "Updated by", "Update date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);
		btnCreate = new JButton("Create");
		btnCreate.setBounds(959, 148, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(959, 186, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(959, 224, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(959, 283, 97, 25);
		add(btnBack);
	}

	private void initEvents() {
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				loadProjects();

			}
		});
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateProject createProject = new CreateProject(userController);
				createProject.setModal(true);
				createProject.setVisible(true);
				loadData();

			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					Project oldProject = currentProjectList.get(selectedRow);
					EditProject ediProject = new EditProject(userController, oldProject);
					ediProject.setModal(true);
					ediProject.setVisible(true);
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
					Project projectToDelete = currentProjectList.get(selectedRow);
					userController.deleteProject(projectToDelete);
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

	private void loadProjects() {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (chooseSearchType() == 1) {
			Project temp = userController.getProject(searchValue);
			currentProjectList.add(temp);
			fillTable(currentProjectList);

		} else if (chooseSearchType() == 2) {
			currentProjectList = userController.getProjectsByDescription(searchValue);
			fillTable(currentProjectList);

		} else if (chooseSearchType() == 3) {
			currentProjectList = userController.getProjectsByCustomer(searchValue);
			fillTable(currentProjectList);

		} else {

		}
	}

	private void emptyTable() {
		currentProjectList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private int chooseSearchType() {
		if (rdbtnName.isSelected()) {
			return 1;
		} else if (rdbtnDescription.isSelected()) {
			return 2;
		} else if (rdbtnCustomer.isSelected()) {
			return 3;
		} else
			return 0;
	}

	private void fillTable(List<Project> projectList) {
		Object[] rowData = new Object[8];
		for (Project project : projectList) {
			rowData[0] = project.getProjectName();
			rowData[1] = project.getDescription();
			rowData[2] = project.getCustomer();
			rowData[3] = project.getCountry().getCountryName();
			rowData[4] = project.getCreatedBy();
			rowData[5] = project.getCreatedDate();
			rowData[6] = project.getUpdatedBy();
			rowData[7] = project.getUpdatedDate();
			tableModel.addRow(rowData);
		}
	}

	private void loadData() {
		emptyTable();
		currentProjectList = userController.getAllProjects();
		Object[] rowData = new Object[8];
		for (Project project : currentProjectList) {
			rowData[0] = project.getProjectName();
			rowData[1] = project.getDescription();
			rowData[2] = project.getCustomer();
			rowData[3] = project.getCountry().getCountryName();
			rowData[4] = project.getCreatedBy();
			rowData[5] = project.getCreatedDate();
			rowData[6] = project.getUpdatedBy();
			rowData[7] = project.getUpdatedDate();
			tableModel.addRow(rowData);
		}
	}

}
