package com.mymanager.desktop.views.subviews;

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

import com.mymanager.config.Config;
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.Project;
import com.mymanager.data.models.User;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.create.CreateProject;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.desktop.views.subviews.edit.EditProject;
import com.mymanager.services.ProjectService;
import com.mymanager.services.ProjectServiceImpl;
import com.mymanager.services.UserService;
import com.mymanager.utils.AppUtil;

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
	private MyPanel selfReference;
	private MainView mainView;

	// Service fields
	private UserService userService;
	private ProjectService projectService;
	private User user;

	/**
	 * Create the panel.
	 */
	public ProjectView(JFrame jframe, MainView mainView, UserService userService, User user) {
		super(1070, 545);
		this.selfReference = this;
		this.jframe = jframe;
		this.mainView = mainView;

		this.userService = userService;
		this.user = user;
		this.projectService = new ProjectServiceImpl();

		setBorder(new LineBorder(new Color(0, 0, 0)));

		initComponents();
		initEvents();

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
				"Created date", "Updated by", "Updated date" });

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
				searchProjects();

			}
		});
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateProject createProject = new CreateProject(projectService, user);
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
					EditProject ediProject = new EditProject(projectService, user, oldProject);
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
					try {

						projectService.deleteProject(projectToDelete);

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

	private void searchProjects() {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (rdbtnName.isSelected()) {
			Project temp = null;
			try {
				temp = projectService.getProjectByName(searchValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (temp != null) {
				currentProjectList.add(temp);
				fillTable(currentProjectList);
			}

		} else if (rdbtnDescription.isSelected()) {
			try {
				currentProjectList = projectService.getAllProjectsByDescription(searchValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fillTable(currentProjectList);

		} else if (rdbtnCustomer.isSelected()) {
			try {
				currentProjectList = projectService.getAllProjectsByCustomer(searchValue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fillTable(currentProjectList);

		} else {
			// To be implemented
		}
	}

	private void emptyTable() {
		currentProjectList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private void fillTable(List<Project> projectsList) {
		if (projectsList != null && projectsList.size() != 0) {
			Object[] rowData = new Object[8];
			for (Project project : projectsList) {
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

	public void loadData() {
		emptyTable();
		try {
			currentProjectList = projectService.getAllProjects(Config.ROW_LIMIT, Config.PROJECT_OFFSET);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentProjectList != null && currentProjectList.size() != 0) {
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

}
