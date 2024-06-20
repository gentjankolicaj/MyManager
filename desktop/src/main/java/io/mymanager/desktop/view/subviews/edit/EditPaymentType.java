package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.PaymentTypeService;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditPaymentType extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7927585795717063183L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final PaymentType oldPaymentType;
  private final PaymentTypeService paymentTypeService;
  private JButton btnCreate;
  private JTextField textFieldPayment;

  /**
   * Create the dialog.
   */
  public EditPaymentType(PaymentTypeService paymentTypeService, PaymentType oldPaymentType) {
    setTitle("Edit payment type");
    this.selfReference = this;
    this.paymentTypeService = paymentTypeService;
    this.oldPaymentType = oldPaymentType;

    initComponents();
    textFieldPayment.setText(oldPaymentType.getPayment());
    initEvents();

  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        String newPaymentType = textFieldPayment.getText();
        try {

          paymentTypeService.updatePaymentType(oldPaymentType, new PaymentType(newPaymentType));

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

            paymentTypeService.updatePaymentType(oldPaymentType, new PaymentType(newPaymentType));

          } catch (Exception e1) {

            e1.printStackTrace();
          }
          selfReference.dispose();
        }
      }
    });
  }

  private void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-save-money.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 362, 110);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Save");

    btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-save-2.png"));
    btnCreate.setBounds(226, 23, 110, 24);
    contentPanel.add(btnCreate);

    textFieldPayment = new JTextField();
    textFieldPayment.setBounds(10, 24, 206, 22);
    contentPanel.add(textFieldPayment);
    textFieldPayment.setColumns(10);
  }
}
