package io.mymanager.desktop.view.subviews.create;

import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.CountryService;
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

public class CreateCountry extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -8373954310692448463L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final CountryService countryService;
  private JButton btnCreate;
  private JTextField textFieldCountry;

  /**
   * Create the dialog.
   */
  public CreateCountry(CountryService countryService) {
    setTitle("Create new country");
    selfReference = this;
    this.countryService = countryService;

    initComponents();
    initEvents();

  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        String newCountry = textFieldCountry.getText();
        try {

          countryService.saveCountry(new Country(newCountry));

        } catch (Exception e1) {

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

            countryService.saveCountry(new Country(newCountry));

          } catch (Exception e1) {

            e1.printStackTrace();
          }

          selfReference.dispose();
        }
      }
    });
  }

  private void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-country.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 351, 110);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Save");

    btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-save-2.png"));
    btnCreate.setBounds(217, 21, 108, 24);
    contentPanel.add(btnCreate);

    textFieldCountry = new JTextField();
    textFieldCountry.setBounds(10, 22, 197, 22);
    textFieldCountry.setColumns(10);
    contentPanel.add(textFieldCountry);
  }
}
