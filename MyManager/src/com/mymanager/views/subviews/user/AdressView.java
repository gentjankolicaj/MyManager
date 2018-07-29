package com.mymanager.views.subviews.user;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mymanager.controllers.UserController;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.MyTable;
import com.mymanager.utils.AppUtil;
import com.mymanager.views.MainView;
import com.mymanager.views.subviews.custom.MyPanel;

public class AdressView extends MyPanel {

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
	private JRadioButton rdbtnCountry;
	private JRadioButton rdbtnStreet;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnPersonId;
	private JRadioButton rdbtnCity;
	private JRadioButton rdbtnBuilding;

	private JFrame jframe;
	private UserController userController;
	private MyPanel selfReference;
	private MainView mainView;

	/**
	 * Create the panel.
	 */
	public AdressView(JFrame jframe, MainView mainView, UserController userController) {
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

		JLabel lblNewLabel = new JLabel("All user adresses");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(341, 13, 230, 45);
		add(lblNewLabel);

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(12, 91, 913, 31);
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
		rdbtnPersonId.setBounds(141, 66, 95, 25);
		add(rdbtnPersonId);

		rdbtnCountry = new JRadioButton("Country");
		buttonGroupSearchType.add(rdbtnCountry);
		rdbtnCountry.setBounds(240, 66, 83, 25);
		add(rdbtnCountry);

		rdbtnCity = new JRadioButton("City");
		buttonGroupSearchType.add(rdbtnCity);
		rdbtnCity.setBounds(327, 67, 56, 25);
		add(rdbtnCity);

		rdbtnStreet = new JRadioButton("Street");
		buttonGroupSearchType.add(rdbtnStreet);
		rdbtnStreet.setBounds(387, 66, 83, 25);
		add(rdbtnStreet);

		rdbtnBuilding = new JRadioButton("Building");
		buttonGroupSearchType.add(rdbtnBuilding);
		rdbtnBuilding.setBounds(474, 66, 83, 25);
		add(rdbtnBuilding);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(942, 91, 138, 31);
		add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 133, 1068, 406);

		table = new MyTable();
		table.setFillsViewportHeight(true);

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] { "ID", "User ID", "Country", "City", "Street", "Zip code",
				"Building", "Created by", "Created date", "Updated by", "Updated date" });

		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		add(scrollPane);
		btnCreate = new JButton("Create");
		btnCreate.setBounds(1090, 133, 97, 25);
		add(btnCreate);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(1090, 171, 97, 25);
		add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(1090, 209, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(1090, 290, 97, 25);
		add(btnBack);
	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				addAdresses();
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
				clearTable();
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AppUtil.returnToMainView(jframe, selfReference, mainView);
			}
		});

	}

	private void clearTable() {
		tableModel.setRowCount(0);
	}

	private int chooseSearchType() {
		if (rdbtnId.isSelected()) {
			return 1;
		} else if (rdbtnPersonId.isSelected()) {
			return 2;
		} else if (rdbtnCountry.isSelected()) {
			return 3;
		} else if (rdbtnCity.isSelected()) {
			return 4;
		} else if (rdbtnStreet.isSelected()) {
			return 5;
		} else
			return 0;
	}

	private void addAdresses() {
		List<Adress> adressesList = null;
		Object[] rowData = new Object[11];
		for (Adress adress : adressesList) {
			rowData[0] = adress.getAdressId();
			rowData[1] = adress.getPersonId();
			rowData[2] = adress.getCountry().getCountryName();
			rowData[3] = adress.getCity();
			rowData[4] = adress.getStreetName();
			rowData[5] = adress.getZipCode();
			rowData[6] = adress.getBuilding();
			rowData[7] = adress.getCreatedBy();
			rowData[8] = adress.getCreatedDate();
			rowData[9] = adress.getUpdatedBy();
			rowData[10] = adress.getUpdatedDate();

			tableModel.addRow(rowData);
		}
	}
}
