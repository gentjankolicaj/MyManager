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
import com.mymanager.data.models.UserAdress;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.services.UserAdressService;
import com.mymanager.services.UserAdressServiceImpl;
import com.mymanager.utils.AppUtil;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserAdressView extends MyPanel {

	private static final long serialVersionUID = 2586092764218526222L;
	private JTextField textFieldSearch;

	private DefaultTableModel tableModel;
	private MyTable table;
	private JButton btnDelete;
	private JButton btnBack;
	private JRadioButton rdbtnStreet;
	private JButton btnSearch;
	private final ButtonGroup buttonGroupSearchType = new ButtonGroup();
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnPersonId;
	private JRadioButton rdbtnCity;

	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;
	private List<UserAdress> currentAdressList;
	
	private UserAdressService userAdressService;

	/**
	 * Create the panel.
	 */
	public UserAdressView(JFrame jframe, MainView mainView) {
		super(1200, 550);
		this.jframe = jframe;
		this.mainView = mainView;
		this.selfReference = this;
		
		this.userAdressService=new UserAdressServiceImpl();
		
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
		rdbtnPersonId.setBounds(141, 66, 73, 25);
		add(rdbtnPersonId);

		rdbtnCity = new JRadioButton("City");
		buttonGroupSearchType.add(rdbtnCity);
		rdbtnCity.setBounds(215, 66, 56, 25);
		add(rdbtnCity);

		rdbtnStreet = new JRadioButton("Street");
		buttonGroupSearchType.add(rdbtnStreet);
		rdbtnStreet.setBounds(275, 65, 83, 25);
		add(rdbtnStreet);

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

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(1090, 142, 97, 25);
		add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setBounds(1090, 178, 97, 25);
		add(btnBack);
	}

	private void initEvents() {
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				try {
					
					searchAdresses();
					
				}catch (NumberFormatException n) {
					
					n.printStackTrace();
					
				}catch (Exception e1) {
					
					e1.printStackTrace();
					
				}

			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int totalRows = table.getRowCount();
				if ((selectedRow > -1) && (selectedRow < totalRows)) {
					
					UserAdress adressToDelete = currentAdressList.get(selectedRow);
					
					try {
						
						userAdressService.deleteAdress( adressToDelete);
						
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

	private void searchAdresses() throws Exception{
		String searchValue = textFieldSearch.getText().trim();
		emptyTable();
		if (rdbtnId.isSelected()) {
			UserAdress temp = userAdressService.getAdress(Integer.parseInt(searchValue));
			currentAdressList.add(temp);
			fillTable(currentAdressList);
		} else if (rdbtnPersonId.isSelected()) {
			UserAdress temp = userAdressService.getAdressesByPersonId( searchValue);
			currentAdressList.add(temp);
			fillTable(currentAdressList);
		} else if (rdbtnCity.isSelected()) {
			currentAdressList =userAdressService.getAdressesByCity( searchValue);
			fillTable(currentAdressList);
		} else if (rdbtnStreet.isSelected()) {
			currentAdressList = userAdressService.getAdressesByStreet(searchValue);
			fillTable(currentAdressList);
		}

	}

	

	private void emptyTable() {
		currentAdressList = new ArrayList<>();
		tableModel.setRowCount(0);
	}

	private void fillTable(List<UserAdress> adressesList) {
		if (adressesList != null) {
			Object[] rowData = new Object[11];
			for (UserAdress adress : adressesList) {
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

	public void loadData() {
		emptyTable();
		try {
			currentAdressList = userAdressService.getAllAdresses(Config.ROW_LIMIT,
					Config.USER_OFFSET);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(currentAdressList!=null&&currentAdressList.size()!=0) {
		Object[] rowData = new Object[11];
		for (UserAdress adress : currentAdressList) {
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
}
