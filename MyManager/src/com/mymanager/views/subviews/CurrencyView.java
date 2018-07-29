package com.mymanager.views.subviews;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.Currency;
import com.mymanager.data.models.MyTable;
import com.mymanager.views.subviews.create.CreateCurrency;
import com.mymanager.views.subviews.edit.EditCurrency;

public class CurrencyView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2868031185429310600L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnCreate;
	private UserController userController;
	private DefaultTableModel tableModel;
	private List<Currency> currencyList;
	private MyTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public CurrencyView(UserController userController) {
		this.userController = userController;
		initComponents();
		initEvents();

		updateTable();
	}

	public void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 426);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCurrencies = new JLabel("All currencies");
		lblCurrencies.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrencies.setBounds(235, 11, 103, 24);
		contentPanel.add(lblCurrencies);

		btnCreate = new JButton("Create");

		btnCreate.setIcon(new ImageIcon(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-add-2.png")));
		btnCreate.setBounds(10, 212, 108, 23);
		contentPanel.add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-edit-3.png")));
		btnEdit.setBounds(10, 257, 108, 23);
		contentPanel.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(
				CurrencyView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-minus-2.png")));
		btnDelete.setBounds(10, 305, 108, 23);
		contentPanel.add(btnDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 68, 327, 306);

		table = new MyTable();
		table.setCellSelectionEnabled(true);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "Currency" });
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		contentPanel.add(scrollPane);
	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CreateCurrency createCurrency = new CreateCurrency(userController);
				createCurrency.setModal(true);
				createCurrency.setVisible(true);
				updateTable();

			}
		});

		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int index = table.getSelectedRow();
				Currency oldCurrency = currencyList.get(index);

				EditCurrency editCurrency = new EditCurrency(userController, oldCurrency);
				editCurrency.setModal(true);
				editCurrency.setVisible(true);
				updateTable();
			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int index = table.getSelectedRow();
				String currency = (String) tableModel.getValueAt(index, 0);
				userController.deleteCurrency(new Currency(currency));
				updateTable();
			}
		});

	}

	public void updateTable() {
		emptyTable();
		currencyList = userController.getAllCurrencies();
		Object[] obj = new Object[1];
		for (Currency currency : currencyList) {
			obj[0] = currency.getCurrencyName();
			tableModel.addRow(obj);
		}
	}

	private void emptyTable() {
		tableModel.setRowCount(0);
	}
}
