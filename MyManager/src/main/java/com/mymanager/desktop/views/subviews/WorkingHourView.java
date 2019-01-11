package com.mymanager.desktop.views.subviews;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
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
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.User;
import com.mymanager.data.models.WorkingHour;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.create.CreateWorkingHour;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.desktop.views.subviews.edit.EditWorkingHour;
import com.mymanager.services.UserService;
import com.mymanager.services.WorkingHourService;
import com.mymanager.services.WorkingHourServiceImpl;
import com.mymanager.utils.AppUtil;
import com.mymanager.utils.MyDateUtils;

public class WorkingHourView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1225822272502930994L;
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
	private JRadioButton rdbtnEmpId;
	private JRadioButton rdbtnDate;
	private List<WorkingHour> currentWorkingHourList;

	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;

	// Service fields
	private UserService userService;
	private WorkingHourService workingHourService;
	private User user;

	/**
	 * Create the panel.
	 */
	public WorkingHourView(JFrame jframe, MainView mainView, UserService userService, User user) {
		super(1070, 540);
		this.jframe = jframe;
		this.mainView = mainView;
		this.selfReference = this;

		this.userService = userService;
		this.user = user;
		this.workingHourService = new WorkingHourServiceImpl();

		setBorder(new LineBorder(new Color(0, 0, 0)));

		initComponents();
		initEvents();

	}

	private void initComponents() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Registered working hours");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 274, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 90, 793, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(815, 90, 138, 31);
		add(btnSearch);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("ID");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(92, 66, 71, 25);
		add(rdbtnId);

		rdbtnEmpId = new JRadioButton("Emp ID");
		buttonGroupSearchType.add(rdbtnEmpId);
		rdbtnEmpId.setBounds(159, 66, 71, 25);
		add(rdbtnEmpId);

		rdbtnDate = new JRadioButton("Date");
		buttonGroupSearchType.add(rdbtnDate);
		rdbtnDate.setBounds(234, 66, 104, 25);
		add(rdbtnDate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 943, 397);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "Emp ID", "Date", "Amount", "Created by", "Created date",
				"Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);

		btnCreate = new JButton("Create");
		btnCreate.setBounds(963, 144, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(963, 182, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(963, 220, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(963, 279, 97, 25);
		add(btnBack);
	}

	private void initEvents() {

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchWorkingHours();
			}
		});

		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateWorkingHour createWorkingHour = new CreateWorkingHour(workingHourService, user);
				createWorkingHour.setModal(true);
				createWorkingHour.setVisible(true);

				loadData();

			}
		});

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					WorkingHour oldWorkingHour = currentWorkingHourList.get(selectedRow);
					EditWorkingHour editWorkingHour = new EditWorkingHour(workingHourService, user, oldWorkingHour);
					editWorkingHour.setModal(true);
					editWorkingHour.setVisible(true);

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
					WorkingHour workingHourToDelete = currentWorkingHourList.get(selectedRow);
					try {

						workingHourService.deleteWorkingHour(workingHourToDelete);

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

	private void searchWorkingHours() {
		String searchValue = textFieldSearch.getText().trim();
		emptyTable();
		if (rdbtnId.isSelected()) {
			WorkingHour temp = null;
			try {
				temp = workingHourService.getWorkingHourByIndex(Integer.parseInt(searchValue));
			} catch (Exception e) {

				e.printStackTrace();
			}
			if (temp != null)
				currentWorkingHourList.add(temp);

			fillTable(currentWorkingHourList);

		} else if (rdbtnEmpId.isSelected()) {
			try {

				currentWorkingHourList = workingHourService.getWorkingHourByEmplyeeId(searchValue);

			} catch (Exception e) {

				e.printStackTrace();
			}

			fillTable(currentWorkingHourList);

		} else if (rdbtnDate.isSelected()) {
			LocalDate localDateValue = null;
			try {
				localDateValue = MyDateUtils.parseToLocalDate(searchValue, "dd MM yyyy");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (localDateValue != null)
				try {
					currentWorkingHourList = workingHourService.getWorkingHourByDate(localDateValue);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
	}

	private void emptyTable() {
		currentWorkingHourList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private void fillTable(List<WorkingHour> workingHoursList) {
		if (workingHoursList != null && workingHoursList.size() != 0) {
			Object[] rowData = new Object[8];
			for (WorkingHour workingHour : workingHoursList) {
				rowData[0] = workingHour.getIndex();
				rowData[1] = workingHour.getEmployeeId();
				rowData[2] = workingHour.getDate();
				rowData[3] = workingHour.getAmount();
				rowData[4] = workingHour.getCreatedBy();
				rowData[5] = workingHour.getCreatedDate();
				rowData[6] = workingHour.getUpdatedBy();
				rowData[7] = workingHour.getUpdatedDate();
				tableModel.addRow(rowData);
			}
		}
	}

	public void loadData() {
		emptyTable();
		try {

			currentWorkingHourList = workingHourService.getAllWorkingHour(Config.ROW_LIMIT, Config.WORKINGHOUR_OFFSET);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (currentWorkingHourList != null && currentWorkingHourList.size() != 0) {
			Object[] rowData = new Object[8];
			for (WorkingHour workingHour : currentWorkingHourList) {
				rowData[0] = workingHour.getIndex();
				rowData[1] = workingHour.getEmployeeId();
				rowData[2] = workingHour.getDate();
				rowData[3] = workingHour.getAmount();
				rowData[4] = workingHour.getCreatedBy();
				rowData[5] = workingHour.getCreatedDate();
				rowData[6] = workingHour.getUpdatedBy();
				rowData[7] = workingHour.getUpdatedDate();
				tableModel.addRow(rowData);
			}
		}

	}

}
