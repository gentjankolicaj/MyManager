package io.gentjankolicaj.app.mymanager.desktop.view.subviews.create;

import io.gentjankolicaj.app.mymanager.desktop.data.models.PaymentType;
import io.gentjankolicaj.app.mymanager.desktop.service.PaymentTypeService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreatePaymentType extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7927585795717063183L;
	private final JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldPayment;


	//Service field
    private final PaymentTypeService paymentTypeService;
	/**
	 * Create the dialog.
	 */
	public CreatePaymentType(PaymentTypeService paymentTypeService) {
		setTitle("Create new payment type");
		selfReference = this;
		this.paymentTypeService=paymentTypeService;
		initComponents();
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newPaymentType = textFieldPayment.getText();
				try {
					
					paymentTypeService.savePaymentType(new PaymentType(newPaymentType));
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				selfReference.dispose();
			}
		});

		textFieldPayment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newPaymentType = textFieldPayment.getText();
					try {
						
						paymentTypeService.savePaymentType(new PaymentType(newPaymentType));
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(CreatePaymentType.class.getResource("/io/gentjankolicaj/apps/mymanager/resources/icons/icons_24x24/icons8-save-money.png")));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnCreate = new JButton("Save");

        btnCreate.setIcon(new ImageIcon(
                CreateCurrency.class.getResource("/io/gentjankolicaj/apps/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
        btnCreate.setBounds(226, 28, 110, 24);
		contentPanel.add(btnCreate);

		textFieldPayment = new JTextField();
		textFieldPayment.setBounds(10, 29, 206, 22);
		contentPanel.add(textFieldPayment);
		textFieldPayment.setColumns(10);
	}
}
