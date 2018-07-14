package com.mymanager.views.subviews;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.mymanager.controllers.AdminController;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Rights;
import com.mymanager.data.models.User;
import com.mymanager.utils.MessageType;
import com.mymanager.utils.UtilWindow;

public class RightsView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JLabel lblRights_1;
	private JLabel lblUser;
	private JComboBox comboBox_1;
	private JButton btnSave;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnAdd;
	private JRadioButton rdbtnRemove;
	private JLabel lblRights;
	private DefaultComboBoxModel comboBoxModel;

	private User user;
	private AdminController adminController;
	private JComboBox userComboBox;

	/**
	 * Create the dialog.
	 */
	public RightsView(AdminController adminController) {
		this.adminController = adminController;
		this.user = adminController.getUser();
		initComponents();
		initEvents();
		showRights();
	}

	private void initComponents() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				RightsView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-admin-2.png")));
		setBounds(100, 100, 749, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblUser = new JLabel("User ID  :");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setBounds(10, 116, 66, 28);
		contentPanel.add(lblUser);

		lblRights = new JLabel("");
		lblRights.setBounds(248, 51, 367, 28);
		contentPanel.add(lblRights);

		JLabel lblCurrentRights = new JLabel("Current Rights :");
		lblCurrentRights.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCurrentRights.setBounds(275, 11, 109, 28);
		contentPanel.add(lblCurrentRights);

		lblRights_1 = new JLabel("Rights :");
		lblRights_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRights_1.setBounds(184, 50, 56, 28);
		contentPanel.add(lblRights_1);

		JLabel lblAddRights = new JLabel("Add");
		lblAddRights.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddRights.setBounds(361, 90, 37, 44);
		contentPanel.add(lblAddRights);

		btnSave = new JButton("  Save");
		btnSave.setIcon(new ImageIcon(
				RightsView.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-checkmark.png")));
		btnSave.setBounds(588, 120, 121, 23);
		contentPanel.add(btnSave);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Rights.values()));
		comboBox_1.setBounds(481, 121, 87, 20);
		contentPanel.add(comboBox_1);

		JLabel lblRemoveRights = new JLabel("Remove");
		lblRemoveRights.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemoveRights.setBounds(342, 133, 56, 34);
		contentPanel.add(lblRemoveRights);

		rdbtnAdd = new JRadioButton("");
		buttonGroup.add(rdbtnAdd);
		rdbtnAdd.setBounds(404, 101, 57, 23);
		contentPanel.add(rdbtnAdd);

		rdbtnRemove = new JRadioButton("");
		buttonGroup.add(rdbtnRemove);
		rdbtnRemove.setBounds(404, 139, 57, 23);
		contentPanel.add(rdbtnRemove);

		userComboBox = new JComboBox();
		userComboBox.setBounds(86, 119, 239, 25);

		comboBoxModel = new DefaultComboBoxModel();
		userComboBox.setModel(comboBoxModel);
		contentPanel.add(userComboBox);
	}

	private void initEvents() {
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int selectedRadioButton = getSelectedRadioButton();

				if (selectedRadioButton == 1) {
					User current = adminController.getUser(user.getUserId());
					User newUser = new User(current.getUserId(), current.getUserType(), current.getFirstName(),
							current.getLastName(), current.getPassword(), current.getBirthday(),
							current.getBirthplace(), current.getGender(), null, current.getCreatedBy(),
							current.getUserId(), current.getCreatedDate(), LocalDateTime.now());

					String currentRights = current.getRights();
					Rights right = (Rights) comboBox_1.getSelectedItem();
					String decidedRight = right.name();

					if (currentRights.contains(decidedRight)) {
						UtilWindow.showMessage(null, "This user already has this right.", MessageType.INFORMATION);

					} else {
						String newRights = currentRights.concat(",").concat(decidedRight);
						newUser.setRights(newRights);
						adminController.editUser(user, newUser);
						UtilWindow.showMessage(null, "Your rights are updated.", MessageType.INFORMATION);
					}

				} else if (selectedRadioButton == 2) {

					User current = adminController.getUser(user.getUserId());
					User newUser = new User(current.getUserId(), current.getUserType(), current.getFirstName(),
							current.getLastName(), current.getPassword(), current.getBirthday(),
							current.getBirthplace(), current.getGender(), null, current.getCreatedBy(),
							current.getUserId(), current.getCreatedDate(), LocalDateTime.now());

					String currentRights = current.getRights();
					Rights right = (Rights) comboBox_1.getSelectedItem();
					String decidedRight = right.name();

					UtilWindow.showMessage(null, "Not implemented yet.", MessageType.INFORMATION);

				} else {
					UtilWindow.showMessage(null, "Select add or remove.", MessageType.INFORMATION);
				}

			}
		});

		userComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = adminController.getUser((String) userComboBox.getSelectedItem());
				showRights();
			}
		});
	}

	private int getSelectedRadioButton() {
		if (rdbtnAdd.isSelected()) {
			return 1;
		} else if (rdbtnRemove.isSelected()) {
			return 2;
		} else
			return 0;
	}

	private void showRights() {
		User actualUser = adminController.getUser(user.getUserId());
		lblRights.setText(actualUser.getRights());
	}

	private List<String> getAllUserIds() {
		List<String> userIdList = new ArrayList<String>();
		List<User> userList = adminController.getAllUsers(QueryType.NORMAL);
		for (User user : userList) {
			userIdList.add(user.getUserId());
		}

		return userIdList;
	}

	public void updateUserComboBox() {
		List<String> idList = getAllUserIds();
		for (String id : idList) {
			comboBoxModel.addElement(id);
		}
	}
}
