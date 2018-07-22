package com.mymanager.views.subviews.edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EditWorkingHour extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073986236252726976L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textFieldEmpId;
	private JTextField textFieldAmount;
	private JTextField textFieldWhId;
	private JLabel lblCreatedBy;
	private JTextField textFieldCreatedBy;
	private List<Object> objectList;

	/**
	 * Create the dialog.
	 */
	public EditWorkingHour(List<Object> objectList) {
		this.objectList = objectList;
		selfReference = this;
		initComponents();
		initEvents();

	}

	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 713, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEditExistingWH = new JLabel("Edit working hour :");
			lblEditExistingWH.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblEditExistingWH.setBounds(129, 13, 270, 26);
			contentPanel.add(lblEditExistingWH);
		}
		{
			JLabel lblWHId = new JLabel("ID :");
			lblWHId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblWHId.setBounds(12, 72, 58, 26);
			contentPanel.add(lblWHId);
		}
		{
			textFieldWhId = new JTextField();
			textFieldWhId.setColumns(10);
			textFieldWhId.setBounds(82, 71, 326, 30);
			contentPanel.add(textFieldWhId);
		}
		{
			JLabel lblEmpID = new JLabel("Emp ID :");
			lblEmpID.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEmpID.setBounds(12, 129, 81, 26);
			contentPanel.add(lblEmpID);
		}
		{
			textFieldEmpId = new JTextField();
			textFieldEmpId.setColumns(10);
			textFieldEmpId.setBounds(82, 128, 326, 30);
			contentPanel.add(textFieldEmpId);
		}
		{
			JLabel lblAmount = new JLabel("Amount ( hours )  :");
			lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblAmount.setBounds(12, 190, 133, 26);
			contentPanel.add(lblAmount);
		}
		{
			textFieldAmount = new JTextField();
			textFieldAmount.setColumns(10);
			textFieldAmount.setBounds(157, 189, 252, 30);
			contentPanel.add(textFieldAmount);
		}
		{
			lblCreatedBy = new JLabel("Created by  :");
			lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCreatedBy.setBounds(8, 247, 93, 26);
			contentPanel.add(lblCreatedBy);
		}
		{
			textFieldCreatedBy = new JTextField();
			textFieldCreatedBy.setColumns(10);
			textFieldCreatedBy.setBounds(101, 246, 311, 30);
			contentPanel.add(textFieldCreatedBy);
		}
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
