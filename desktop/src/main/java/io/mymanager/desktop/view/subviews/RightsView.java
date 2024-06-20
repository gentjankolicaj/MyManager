package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.data.models.Rights;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.enums.MessageType;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.UserService;
import io.mymanager.desktop.util.WindowUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import org.apache.commons.lang3.StringUtils;

public class RightsView extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = -2398676643579841060L;

  private final JPanel contentPanel = new JPanel();

  private final JDialog selfReference;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final UserService userService;
  private JLabel lblRights_1;
  private JLabel lblUser;
  private JComboBox comboBox_1;
  private JButton btnSave;
  private JRadioButton rdbtnAdd;
  private JRadioButton rdbtnRemove;
  private JLabel lblRights;
  private DefaultComboBoxModel comboBoxModel;
  private JComboBox userComboBox;
  private User user;

  /**
   * Create the dialog.
   */
  public RightsView(UserService userService, User user) {
    setTitle("Change user rights");
    this.selfReference = this;
    this.userService = userService;
    this.user = user;

    initComponents();
    initEvents();

    showRights();
  }

  private void initComponents() {
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-admin-2.png"));
    setBounds(100, 100, 561, 250);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    lblUser = new JLabel("User ID  :");
    lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblUser.setBounds(10, 12, 66, 28);
    contentPanel.add(lblUser);

    lblRights = new JLabel("");
    lblRights.setForeground(new Color(255, 0, 0));
    lblRights.setBounds(307, 144, 232, 25);
    contentPanel.add(lblRights);

    lblRights_1 = new JLabel("Current rights :");
    lblRights_1.setForeground(new Color(0, 0, 0));
    lblRights_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
    lblRights_1.setBounds(287, 105, 106, 28);
    contentPanel.add(lblRights_1);

    btnSave = new JButton("  Save");
    btnSave.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-checkmark.png"));
    btnSave.setBounds(87, 149, 106, 23);
    contentPanel.add(btnSave);

    comboBox_1 = new JComboBox();
    comboBox_1.setModel(new DefaultComboBoxModel(Rights.values()));
    comboBox_1.setBounds(87, 101, 106, 20);
    contentPanel.add(comboBox_1);

    rdbtnAdd = new JRadioButton("Add");
    buttonGroup.add(rdbtnAdd);
    rdbtnAdd.setBounds(87, 59, 66, 23);
    contentPanel.add(rdbtnAdd);

    rdbtnRemove = new JRadioButton("Remove");
    buttonGroup.add(rdbtnRemove);
    rdbtnRemove.setBounds(155, 59, 106, 23);
    contentPanel.add(rdbtnRemove);

    userComboBox = new JComboBox();
    userComboBox.setBounds(86, 15, 186, 25);

    comboBoxModel = new DefaultComboBoxModel();
    userComboBox.setModel(comboBoxModel);
    contentPanel.add(userComboBox);
  }

  private void initEvents() {
    btnSave.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int selectedRadioButton = getSelectedRadioButton();
        User currentUser = null;
        if (selectedRadioButton == 1) {

          try {

            currentUser = userService.getUser(user.getUserId());

          } catch (Exception e1) {

            e1.printStackTrace();
          }
          if (currentUser != null) {
            User newUser = new User(currentUser.getUserId(), currentUser.getUserType(),
                currentUser.getFirstName(),
                currentUser.getLastName(), currentUser.getPassword(), currentUser.getBirthday(),
                currentUser.getBirthplace(), currentUser.getGender(), null,
                currentUser.getCreatedBy(),
                currentUser.getUserId(), currentUser.getCreatedDate(), LocalDateTime.now());

            String currentRights = currentUser.getRights();
            Rights right = (Rights) comboBox_1.getSelectedItem();
            String decidedRight = right.name();

            if (currentRights.contains(decidedRight)) {
              WindowUtils.showMessage(null, "This user already has this right.",
                  MessageType.INFORMATION);

            } else {
              String newRights = currentRights.concat(" ").concat(decidedRight);
              newUser.setRights(newRights);

              try {

                userService.updateUser(user, newUser);
                user = newUser;

              } catch (Exception e1) {

                e1.printStackTrace();
              }

              WindowUtils.showMessage(null, decidedRight + " is added.", MessageType.INFORMATION);

              showRights();

            }

          }

        } else if (selectedRadioButton == 2) {

          try {

            currentUser = userService.getUser(user.getUserId());

          } catch (Exception e1) {

            e1.printStackTrace();
          }

          if (currentUser != null) {

            String currentRights = currentUser.getRights();
            Rights rightSelected = (Rights) comboBox_1.getSelectedItem();
            String rightToRemove = rightSelected.name();
            rightToRemove = " " + rightToRemove;

            String updatedRights = StringUtils.remove(currentRights, rightToRemove);

            User newUser = new User(currentUser.getUserId(), currentUser.getUserType(),
                currentUser.getFirstName(),
                currentUser.getLastName(), currentUser.getPassword(), currentUser.getBirthday(),
                currentUser.getBirthplace(), currentUser.getGender(), updatedRights,
                currentUser.getCreatedBy(),
                currentUser.getUserId(), currentUser.getCreatedDate(), LocalDateTime.now());

            try {

              userService.updateUser(user, newUser);
              user = newUser;

            } catch (Exception e1) {

              e1.printStackTrace();
            }

            WindowUtils.showMessage(null, rightToRemove + " removed.", MessageType.INFORMATION);
            showRights();
          }
        } else {
          WindowUtils.showMessage(null, "Select add or remove.", MessageType.INFORMATION);
        }

      }
    });

    userComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {

          user = userService.getUser((String) userComboBox.getSelectedItem());

        } catch (Exception e1) {

          e1.printStackTrace();
        }

        showRights();
      }
    });
  }

  private int getSelectedRadioButton() {
    if (rdbtnAdd.isSelected()) {
      return 1;
    } else if (rdbtnRemove.isSelected()) {
      return 2;
    } else {
      return 0;
    }
  }

  private void showRights() {
    User actualUser = null;
    try {
      actualUser = userService.getUser(user.getUserId());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (actualUser != null) {
      lblRights.setText(actualUser.getRights());
    }
  }

  public void updateUserComboBox() {
    List<String> userIdList = null;

    try {

      userIdList = userService.getAllUserIds();

    } catch (Exception e) {

      e.printStackTrace();
    }

    if (userIdList != null && userIdList.size() != 0) {
      for (String id : userIdList) {
        comboBoxModel.addElement(id);
      }

    }

  }
}
