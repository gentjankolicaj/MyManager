package io.mymanager.desktop.view.subviews.user;

import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.util.ViewUtils;
import io.mymanager.desktop.view.MainView;
import io.mymanager.desktop.view.subviews.custom.MyPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * @author gentjan kolicaj
 */
public class UserDataView extends MyPanel {

  /**
   *
   */
  private static final long serialVersionUID = 4100590738083935784L;

  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final JFrame jframe;
  private final MyPanel selfReference;
  private final MainView mainView;
  //Service fields
  private final UserService userService;
  //
  private final User user;
  private UserView userView;
  private UserAdressView adressView;
  private UserContactView contactView;
  // important for inside navigation
  private MyPanel previousPanel;
  private JButton btnContacts;
  private JButton btnAdresses;
  private JButton btnUsers;

  /**
   * Create the panel.
   */
  public UserDataView(JFrame jframe, MainView mainView, UserService userService, User user) {
    super(1330, 650);
    this.jframe = jframe;
    this.selfReference = this;
    this.mainView = mainView;
    this.userService = userService;
    this.user = user;

    initComponents();
    initEvents();
  }

  private void initComponents() {
    setLayout(null);

    userView = new UserView(jframe, mainView, userService, user);
    previousPanel = userView;
    userView.setBounds(134, 11, 1221, 650);
    add(userView);

    btnContacts = new JButton("Contacts");
    btnContacts.setBounds(10, 269, 120, 35);
    add(btnContacts);

    btnAdresses = new JButton("Adresses");
    btnAdresses.setBounds(10, 206, 120, 35);
    add(btnAdresses);

    btnUsers = new JButton("Users");
    btnUsers.setForeground(Color.BLACK);
    btnUsers.setBackground(UIManager.getColor("Button.background"));
    btnUsers.setBounds(10, 146, 120, 35);
    add(btnUsers);

  }

  public void initEvents() {

    btnUsers.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        userView = new UserView(jframe, mainView, userService, user);
        ViewUtils.changeUserView(selfReference, userView, previousPanel);
        previousPanel = userView;

      }
    });
    btnAdresses.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        adressView = new UserAdressView(jframe, mainView);
        ViewUtils.changeUserView(selfReference, adressView, previousPanel);
        previousPanel = adressView;
      }
    });

    btnContacts.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        contactView = new UserContactView(jframe, mainView);
        ViewUtils.changeUserView(selfReference, contactView, previousPanel);
        previousPanel = contactView;
      }
    });
  }
}
