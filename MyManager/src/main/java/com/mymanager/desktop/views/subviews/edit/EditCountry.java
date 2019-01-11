package com.mymanager.desktop.views.subviews.edit;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mymanager.data.models.Country;
import com.mymanager.desktop.views.subviews.CurrencyView;
import com.mymanager.services.CountryService;

public class EditCountry extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8373954310692448463L;
	private JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnEdit;
	private JTextField textFieldCountry;
	private Country oldCountry;
	
	private CountryService countryService;

	/**
	 * Create the dialog.
	 */
	public EditCountry(CountryService countryService, Country oldCountry) {
		setTitle("Edit country");
		selfReference = this;
		this.countryService=countryService;
		this.oldCountry = oldCountry;
		
		initComponents();
		textFieldCountry.setText(oldCountry.getCountryName());
		initEvents();

	}

	private void initEvents() {
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newCountry = textFieldCountry.getText();
				try {
					
					countryService.updateCountry(oldCountry, new Country(newCountry));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				selfReference.dispose();
			}
		});

		textFieldCountry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newCountry = textFieldCountry.getText();
					
					try {
						
						countryService.updateCountry(oldCountry, new Country(newCountry));
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditCountry.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-country.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnEdit = new JButton("Save");

		btnEdit.setIcon(new ImageIcon(
				EditCountry.class.getResource("/com/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
		btnEdit.setBounds(217, 22, 108, 23);
		contentPanel.add(btnEdit);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(10, 22, 197, 22);
		textFieldCountry.setColumns(10);
		contentPanel.add(textFieldCountry);
	}
}
