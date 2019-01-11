package com.mymanager.desktop.views.subviews.employee;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.mymanager.data.models.User;
import com.mymanager.desktop.views.MainView;
import com.mymanager.desktop.views.subviews.custom.MyPanel;
import com.mymanager.services.EmployeeAdressService;
import com.mymanager.services.EmployeeAdressServiceImpl;
import com.mymanager.services.EmployeeContactService;
import com.mymanager.services.EmployeeContactServiceImpl;
import com.mymanager.services.EmployeeService;
import com.mymanager.services.EmployeeServiceImpl;
import com.mymanager.utils.AppUtil;

public class EmployeeDataView extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4100590738083935784L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnEmployee;
	private JButton btnAdresses;
	private JButton btnContacts;

	private EmployeeView employeeView;
	private EmployeeAdressView employeeAdressView;
	private EmployeeContactView employeeContactView;

	// important for inside navigation
	private MyPanel previousPanel;
	//

	private JFrame jframe;
	private MyPanel selfReference;
	private MainView mainView;
	
	//Service
	private EmployeeService employeeService;
	private EmployeeAdressService employeeAdressService;
	private EmployeeContactService employeeContactService;
	private User user;

	/**
	 * Create the panel.
	 */
	public EmployeeDataView(JFrame jframe, MainView mainView,User user) {
		super(1425, 650);
		this.jframe = jframe;
		this.mainView = mainView;
		this.selfReference=this;
		
		this.user=user;
		this.employeeService=new EmployeeServiceImpl();
		this.employeeAdressService=new EmployeeAdressServiceImpl();
		this.employeeContactService=new EmployeeContactServiceImpl();
		
		
		initComponents();
		
		initEvents();
	}

	private void initComponents() {
		setLayout(null);

		btnContacts = new JButton("Contacts");
		btnContacts.setBounds(10, 278, 120, 35);
		add(btnContacts);
		buttonGroup.add(btnContacts);

		btnAdresses = new JButton("Adresses");
		btnAdresses.setBounds(10, 219, 120, 35);
		add(btnAdresses);
		buttonGroup.add(btnAdresses);

		btnEmployee = new JButton("Employee");
		btnEmployee.setBounds(10, 162, 120, 35);
		add(btnEmployee);
		buttonGroup.add(btnEmployee);

		employeeView = new EmployeeView(jframe, mainView, user, employeeService);
		previousPanel = employeeView;
		employeeView.setBounds(130, 10, 1450, 650);
		add(employeeView);
		setSize(1400, 650);

	}

	public void initEvents() {

		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				employeeView=new EmployeeView(jframe,mainView,user,employeeService);
				AppUtil.changeEmpView(selfReference,employeeView,previousPanel);
				previousPanel=employeeView;

			}
		});
		btnAdresses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				employeeAdressView=new EmployeeAdressView(jframe,mainView,user,employeeAdressService);
				AppUtil.changeEmpView(selfReference,employeeAdressView,previousPanel);
				previousPanel=employeeAdressView;
				
			}
		});

		btnContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				employeeContactView=new EmployeeContactView(jframe,mainView,user,employeeContactService);
				AppUtil.changeEmpView(selfReference,employeeContactView,previousPanel);
				previousPanel=employeeContactView;
			
			}
		});

	}
}
