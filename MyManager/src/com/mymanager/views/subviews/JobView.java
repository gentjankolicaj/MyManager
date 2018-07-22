package com.mymanager.views.subviews;

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

import com.mymanager.controllers.UserController;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Job;
import com.mymanager.data.models.MyTable;
import com.mymanager.utils.AppUtil;
import com.mymanager.views.MainView;
import com.mymanager.views.subviews.create.CreateJob;
import com.mymanager.views.subviews.custom.MyPanel;
import com.mymanager.views.subviews.edit.EditJob;

public class JobView extends MyPanel {

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
	private JRadioButton rdbtnTitle;
	private JRadioButton rdbtnSalary;
	private List<Job> currentJobList;

	private JFrame jframe;
	private UserController userController;
	private MyPanel selfReference;
	private MainView mainView;

	/**
	 * Create the panel.
	 */
	public JobView(JFrame jframe, MainView mainView, UserController userController) {
		super(1070, 550);
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

		JLabel lblNewLabel = new JLabel("All registered jobs");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 274, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(14, 98, 785, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(809, 98, 138, 31);
		add(btnSearch);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("Id");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(92, 66, 71, 25);
		add(rdbtnId);

		rdbtnTitle = new JRadioButton("Title");
		buttonGroupSearchType.add(rdbtnTitle);
		rdbtnTitle.setBounds(159, 66, 71, 25);
		add(rdbtnTitle);

		rdbtnSalary = new JRadioButton("Salary");
		buttonGroupSearchType.add(rdbtnSalary);
		rdbtnSalary.setBounds(234, 66, 79, 25);
		add(rdbtnSalary);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 140, 933, 402);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Id", "Title", "Max salary", "Min salary", "Created by",
				"Created date", "Updated by", "Update date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);

		btnCreate = new JButton("Create");
		btnCreate.setBounds(957, 153, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(957, 191, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(957, 229, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(957, 288, 97, 25);
		add(btnBack);
	}

	private void initEvents() {

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadJobs();
			}
		});

		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateJob createJob = new CreateJob(userController);
				createJob.setModal(true);
				createJob.setVisible(true);
				loadData();

			}
		});
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					Job oldJob = currentJobList.get(selectedRow);
					EditJob editJob = new EditJob(userController, oldJob);
					editJob.setModal(true);
					editJob.setVisible(true);
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
					Job jobToDelete = currentJobList.get(selectedRow);
					userController.deleteJob(jobToDelete);
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

	private void loadJobs() {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (chooseSearchType() == 1) {
			Job temp = userController.getJob(Integer.parseInt(searchValue));
			currentJobList.add(temp);
			fillTable(currentJobList);
		} else if (chooseSearchType() == 2) {
			currentJobList = userController.getJobsWithTitle(QueryType.NORMAL, searchValue);
			fillTable(currentJobList);

		} else if (chooseSearchType() == 3) {
			int boundary = searchValue.indexOf("/");
			String minValue = searchValue.substring(0, boundary);
			String maxValue = searchValue.substring(boundary + 1);
			currentJobList = userController.getJobsBetween(QueryType.NORMAL, Float.parseFloat(minValue),
					Float.parseFloat(maxValue));
			fillTable(currentJobList);

		}
	}

	private void emptyTable() {
		currentJobList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private int chooseSearchType() {
		if (rdbtnId.isSelected()) {
			return 1;
		} else if (rdbtnTitle.isSelected()) {
			return 2;
		} else if (rdbtnSalary.isSelected()) {
			return 3;
		} else
			return 0;
	}

	private void fillTable(List<Job> jobsList) {
		Object[] rowData = new Object[8];
		for (Job job : jobsList) {
			rowData[0] = job.getJobId();
			rowData[1] = job.getJobTitle();
			rowData[2] = job.getMaxSalary();
			rowData[3] = job.getMinSalary();
			rowData[4] = job.getCreatedBy();
			rowData[5] = job.getCreatedDate();
			rowData[6] = job.getUpdatedBy();
			rowData[7] = job.getUpdatedDate();
			tableModel.addRow(rowData);
		}
	}

	private void loadData() {
		emptyTable();
		currentJobList = userController.getAllJobs(QueryType.NORMAL);
		Object[] rowData = new Object[8];
		for (Job job : currentJobList) {
			rowData[0] = job.getJobId();
			rowData[1] = job.getJobTitle();
			rowData[2] = job.getMaxSalary();
			rowData[3] = job.getMinSalary();
			rowData[4] = job.getCreatedBy();
			rowData[5] = job.getCreatedDate();
			rowData[6] = job.getUpdatedBy();
			rowData[7] = job.getUpdatedDate();
			tableModel.addRow(rowData);
		}

	}
}
