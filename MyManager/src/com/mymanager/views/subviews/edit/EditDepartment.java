package com.mymanager.views.subviews.edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EditDepartment extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073986236252726976L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldDepName;
	private JTextField textFieldJobId;
	private JLabel lblCreatedBy;
	private JTextField textFieldCreatedBy;
	private List<Object> objectList;
	private JComboBox comboBoxManId;

	/**
	 * Create the dialog.
	 */
	public EditDepartment(List<Object> objectList) {
		this.objectList = objectList;
		selfReference = this;
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEditExistingJob = new JLabel("Edit existing department :");
			lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblEditExistingJob.setBounds(129, 13, 270, 26);
			contentPanel.add(lblEditExistingJob);
		}
		{
			JLabel lblDepartmentId = new JLabel("Dep Id :");
			lblDepartmentId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDepartmentId.setBounds(12, 72, 81, 26);
			contentPanel.add(lblDepartmentId);
		}
		{
			textFieldJobId = new JTextField();
			textFieldJobId.setColumns(10);
			textFieldJobId.setBounds(105, 71, 326, 30);
			contentPanel.add(textFieldJobId);
		}
		{
			JLabel lblDepName = new JLabel("Dep name :");
			lblDepName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDepName.setBounds(12, 129, 81, 26);
			contentPanel.add(lblDepName);
		}
		{
			textFieldDepName = new JTextField();
			textFieldDepName.setColumns(10);
			textFieldDepName.setBounds(105, 128, 326, 30);
			contentPanel.add(textFieldDepName);
		}
		{
			lblCreatedBy = new JLabel("Created by  :");
			lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCreatedBy.setBounds(12, 191, 93, 26);
			contentPanel.add(lblCreatedBy);
		}
		{
			textFieldCreatedBy = new JTextField();
			textFieldCreatedBy.setColumns(10);
			textFieldCreatedBy.setBounds(105, 190, 326, 30);
			contentPanel.add(textFieldCreatedBy);
		}

		JLabel lblManId = new JLabel("Manager Id  :");
		lblManId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblManId.setBounds(12, 254, 93, 26);
		contentPanel.add(lblManId);

		comboBoxManId = new JComboBox();
		comboBoxManId.setBounds(117, 257, 314, 30);
		contentPanel.add(comboBoxManId);
		{
			buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Save");
				okButton.setActionCommand("Save");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void initEvents() {
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				selfReference.dispose();
			}
		});
	}
}
