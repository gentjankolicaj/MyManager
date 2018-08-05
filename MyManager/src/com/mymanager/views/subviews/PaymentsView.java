
package com.mymanager.views.subviews;

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
import com.mymanager.data.models.MyTable;
import com.mymanager.data.models.Payment;
import com.mymanager.data.models.PaymentType;
import com.mymanager.utils.AppUtil;
import com.mymanager.views.MainView;
import com.mymanager.views.subviews.create.CreatePayments;
import com.mymanager.views.subviews.custom.MyPanel;
import com.mymanager.views.subviews.edit.EditPayments;

public class PaymentsView extends MyPanel {

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
	private JRadioButton rdbtnType;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnEmpId;
	private JRadioButton rdbtnDesc;
	private List<Payment> currentPaymentList;

	private JFrame jframe;
	private UserController userController;
	private MyPanel selfReference;
	private MainView mainView;

	/**
	 * Create the panel.
	 */
	public PaymentsView(JFrame jframe, MainView mainView, UserController userController) {
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

		JLabel lblNewLabel = new JLabel("All employee payments");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 230, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 98, 913, 31);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JLabel lblSearcchBy = new JLabel("Search by :");
		lblSearcchBy.setBounds(12, 63, 89, 31);
		add(lblSearcchBy);

		rdbtnId = new JRadioButton("ID");
		buttonGroupSearchType.add(rdbtnId);
		rdbtnId.setBounds(83, 66, 56, 25);
		add(rdbtnId);

		rdbtnEmpId = new JRadioButton("Employee Id");
		buttonGroupSearchType.add(rdbtnEmpId);
		rdbtnEmpId.setBounds(141, 66, 95, 25);
		add(rdbtnEmpId);

		rdbtnType = new JRadioButton("Type");
		buttonGroupSearchType.add(rdbtnType);
		rdbtnType.setBounds(240, 66, 61, 25);
		add(rdbtnType);

		rdbtnDesc = new JRadioButton("Description");
		buttonGroupSearchType.add(rdbtnDesc);
		rdbtnDesc.setBounds(303, 65, 95, 25);
		add(rdbtnDesc);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(942, 98, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 140, 1068, 398);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "Type", "Emp ID", "Amount", "Currency", "Desc",
				"Created by", "Created date", "Updated by", "Updated date" });

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
			public void mouseReleased(MouseEvent e) {
				loadPayments();
			}
		});
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreatePayments createPayment = new CreatePayments(userController);
				createPayment.setModal(true);
				createPayment.setVisible(true);
				loadData();

			}
		});

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					Payment oldPayment = currentPaymentList.get(selectedRow);
					EditPayments editPayment = new EditPayments(userController, oldPayment);
					editPayment.setModal(true);
					editPayment.setVisible(true);
					loadData();
				}

			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if (selectedRow > -1 && selectedRow < totalRows) {
					Payment payment = currentPaymentList.get(selectedRow);
					userController.deletePayment(payment);
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

	private void emptyTable() {
		currentPaymentList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private int chooseSearchType() {
		if (rdbtnId.isSelected()) {
			return 1;
		} else if (rdbtnEmpId.isSelected()) {
			return 2;
		} else if (rdbtnType.isSelected()) {
			return 3;
		} else if (rdbtnDesc.isSelected()) {
			return 4;
		} else
			return 0;
	}

	private void fillTable(List<Payment> paymentsList) {
		if (paymentsList != null) {
			Object[] rowData = new Object[10];
			for (Payment payment : paymentsList) {
				rowData[0] = payment.getPaymentId();
				rowData[1] = payment.getPaymentType().getPayment();
				rowData[2] = payment.getEmployeeId();
				rowData[3] = payment.getPaymentAmount();
				rowData[4] = payment.getCurrency().getCurrencyName();
				rowData[5] = payment.getPaymentDescription();
				rowData[6] = payment.getCreatedBy();
				rowData[7] = payment.getCreatedDate();
				rowData[8] = payment.getUpdatedBy();
				rowData[9] = payment.getUpdatedDate();
				tableModel.addRow(rowData);
			}
		}
	}

	private void loadPayments() {
		String searchValue = textFieldSearch.getText();
		emptyTable();
		if (chooseSearchType() == 1) {
			Payment temp = userController.getPayment(Integer.parseInt(searchValue));
			currentPaymentList.add(temp);
			fillTable(currentPaymentList);
		} else if (chooseSearchType() == 2) {
			currentPaymentList = userController.getPaymentByEmployeeId(QueryType.NORMAL, searchValue);
			fillTable(currentPaymentList);
		} else if (chooseSearchType() == 3) {
			currentPaymentList = userController.getPaymentByType(QueryType.NORMAL, new PaymentType(searchValue));
			fillTable(currentPaymentList);
		} else if (chooseSearchType() == 4) {
			currentPaymentList = userController.getPaymentByDescription(QueryType.NORMAL, searchValue);
			fillTable(currentPaymentList);
		} else {

		}
	}

	public void loadData() {
		emptyTable();
		currentPaymentList = userController.getAllPayments(QueryType.NORMAL, Config.ROW_LIMIT, Config.PAYMENTS_OFFSET);
		Object[] rowData = new Object[10];
		for (Payment payment : currentPaymentList) {
			rowData[0] = payment.getPaymentId();
			rowData[1] = payment.getPaymentType().getPayment();
			rowData[2] = payment.getEmployeeId();
			rowData[3] = payment.getPaymentAmount();
			rowData[4] = payment.getCurrency().getCurrencyName();
			rowData[5] = payment.getPaymentDescription();
			rowData[6] = payment.getCreatedBy();
			rowData[7] = payment.getCreatedDate();
			rowData[8] = payment.getUpdatedBy();
			rowData[9] = payment.getUpdatedDate();
			tableModel.addRow(rowData);
		}

	}
}
