package com.mymanager.views.subviews.edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class EditProject extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073986236252726976L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldDescription;
	private JTextField textFieldCustomer;
	private JTextField textFieldName;
	private JLabel lblCreatedBy;
	private JTextField textFieldCreatedBy;
	private List<Object> objectList;
	private JLabel lblCountry;
	private JComboBox comboBoxCountry;

	/**
	 * Create the dialog.
	 */
	public EditProject(List<Object> objectList) {
		this.objectList = objectList;
		selfReference = this;
		initComponents();
		initEvents();
		loadCountries();

	}

	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 502);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEditExistingJob = new JLabel("Edit existing project :");
			lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblEditExistingJob.setBounds(129, 13, 270, 26);
			contentPanel.add(lblEditExistingJob);
		}
		{
			JLabel lblProjectDescription = new JLabel("Project desc :");
			lblProjectDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblProjectDescription.setBounds(12, 132, 105, 26);
			contentPanel.add(lblProjectDescription);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
			textFieldName.setBounds(136, 71, 326, 30);
			contentPanel.add(textFieldName);
		}
		{
			textFieldDescription = new JTextField();
			textFieldDescription.setColumns(10);
			textFieldDescription.setBounds(136, 131, 326, 30);
			contentPanel.add(textFieldDescription);
		}
		{
			JLabel lblCustomer = new JLabel("Customer  :");
			lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCustomer.setBounds(24, 191, 81, 26);
			contentPanel.add(lblCustomer);
		}
		{
			textFieldCustomer = new JTextField();
			textFieldCustomer.setColumns(10);
			textFieldCustomer.setBounds(136, 190, 326, 30);
			contentPanel.add(textFieldCustomer);
		}
		{
			JLabel lblJobId = new JLabel("Project name  :");
			lblJobId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblJobId.setBounds(12, 72, 105, 26);
			contentPanel.add(lblJobId);
		}
		{
			lblCreatedBy = new JLabel("Created by  :");
			lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCreatedBy.setBounds(19, 247, 93, 26);
			contentPanel.add(lblCreatedBy);
		}
		{
			textFieldCreatedBy = new JTextField();
			textFieldCreatedBy.setColumns(10);
			textFieldCreatedBy.setBounds(136, 246, 326, 30);
			contentPanel.add(textFieldCreatedBy);
		}
		{
			lblCountry = new JLabel("Country  :");
			lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCountry.setBounds(24, 307, 93, 26);
			contentPanel.add(lblCountry);
		}

		comboBoxCountry = new JComboBox();
		comboBoxCountry.setBounds(142, 303, 320, 36);
		contentPanel.add(comboBoxCountry);
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

		comboBoxCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void loadCountries() {

	}
}
