package io.mymanager.desktop.view.about;

import io.mymanager.desktop.icon.IconUtils;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class AboutDialog extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 990588574724534884L;
  private final JPanel contentPanel = new JPanel();

  /**
   * Create the dialog.
   */
  public AboutDialog() {
    setTitle("About");
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-admin-2.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 622, 332);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    JTextArea txtrAboutAuthorGentjan = new JTextArea();
    txtrAboutAuthorGentjan.setEditable(false);
    txtrAboutAuthorGentjan.setLineWrap(true);
    txtrAboutAuthorGentjan.setText(
        "Author : Gentjan Kolicaj \r\nGithub : https://github.com/gentjankolicaj\r\n\r\nAbout Icons : \r\nIcons are property of https://icons8.com/. \r\nThey distribute icons under the license called Creative Commons Attribution-NoDerivs 3.0 Unported.\r\nA special thanks to them.\r\nAlso check the site for more awesome icons.");
    txtrAboutAuthorGentjan.setBackground(UIManager.getColor("Button.background"));
    txtrAboutAuthorGentjan.setBounds(10, 11, 586, 215);
    contentPanel.add(txtrAboutAuthorGentjan);
  }

}
