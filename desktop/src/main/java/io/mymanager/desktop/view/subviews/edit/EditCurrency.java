package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.Currency;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.CurrencyService;
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

public class EditCurrency extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7927585795717063183L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final Currency oldCurrency;
  //Service field
  private final CurrencyService currencyService;
  private JButton btnCreate;
  private JTextField textFieldCurrency;

  /**
   * Create the dialog.
   */
  public EditCurrency(CurrencyService currencyService, Currency oldCurrency) {
    setTitle("Edit currency");
    selfReference = this;
    this.currencyService = currencyService;
    this.oldCurrency = oldCurrency;

    initComponents();
    textFieldCurrency.setText(oldCurrency.getCurrencyName());
    initEvents();

  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        String newCurrency = textFieldCurrency.getText();
        try {
          currencyService.updateCurrency(oldCurrency, new Currency(newCurrency));
        } catch (Exception e1) {

          e1.printStackTrace();
        }
        selfReference.dispose();
      }
    });

    textFieldCurrency.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          String newCurrency = textFieldCurrency.getText();
          try {
            currencyService.updateCurrency(oldCurrency, new Currency(newCurrency));
          } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          selfReference.dispose();
        }
      }
    });
  }

  private void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-sack-of-money-2.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 362, 110);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Save");

    btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-save-2.png"));
    btnCreate.setBounds(226, 25, 110, 24);
    contentPanel.add(btnCreate);

    textFieldCurrency = new JTextField();
    textFieldCurrency.setBounds(10, 26, 206, 22);
    contentPanel.add(textFieldCurrency);
    textFieldCurrency.setColumns(10);
  }
}
