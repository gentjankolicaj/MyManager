package io.mymanager.desktop.view.subviews.edit;

import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.Project;
import io.mymanager.desktop.data.models.User;
import io.mymanager.desktop.service.CountryService;
import io.mymanager.desktop.service.ProjectService;
import io.mymanager.desktop.service.impl.CountryServiceImpl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EditProject extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 7073986236252726976L;
  private final JDialog selfReference;
  private final JPanel contentPanel = new JPanel();
  private final ProjectService projectService;
  private final CountryService countryService;
  private final User user;
  private JPanel buttonPane;
  private JButton okButton;
  private JButton cancelButton;
  private JTextField textFieldDescription;
  private JTextField textFieldCustomer;
  private JTextField textFieldName;
  private JLabel lblCreatedBy;
  private JTextField textFieldCreatedBy;
  private JLabel lblCountry;
  private JComboBox comboBoxCountry;
  private DefaultComboBoxModel comboBoxModel;
  private Project oldProject;

  /**
   * Create the dialog.
   */
  public EditProject(ProjectService projectService, User user, Project oldProject) {
    this.selfReference = this;
    this.projectService = projectService;
    this.user = user;
    this.countryService = new CountryServiceImpl();

    initComponents();
    initEvents();

    loadCountries();

    fillDetails();

  }

  private void initComponents() {
    setResizable(false);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 600, 400);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblEditExistingJob = new JLabel("Edit existing project :");
      lblEditExistingJob.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
      lblEditExistingJob.setBounds(129, 13, 270, 26);
      contentPanel.add(lblEditExistingJob);
    }
    {
      JLabel lblProjectDescription = new JLabel("Project desc :");
      lblProjectDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblProjectDescription.setBounds(10, 111, 105, 26);
      contentPanel.add(lblProjectDescription);
    }
    {
      textFieldName = new JTextField();
      textFieldName.setColumns(10);
      textFieldName.setBounds(134, 50, 265, 30);
      contentPanel.add(textFieldName);
    }
    {
      textFieldDescription = new JTextField();
      textFieldDescription.setColumns(10);
      textFieldDescription.setBounds(134, 110, 265, 30);
      contentPanel.add(textFieldDescription);
    }
    {
      JLabel lblCustomer = new JLabel("Customer  :");
      lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCustomer.setBounds(22, 170, 81, 26);
      contentPanel.add(lblCustomer);
    }
    {
      textFieldCustomer = new JTextField();
      textFieldCustomer.setColumns(10);
      textFieldCustomer.setBounds(134, 169, 270, 30);
      contentPanel.add(textFieldCustomer);
    }
    {
      JLabel lblJobId = new JLabel("Project name  :");
      lblJobId.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblJobId.setBounds(10, 51, 105, 26);
      contentPanel.add(lblJobId);
    }
    {
      lblCreatedBy = new JLabel("Created by  :");
      lblCreatedBy.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCreatedBy.setBounds(17, 226, 93, 26);
      contentPanel.add(lblCreatedBy);
    }
    {
      textFieldCreatedBy = new JTextField();
      textFieldCreatedBy.setColumns(10);
      textFieldCreatedBy.setBounds(134, 225, 270, 30);
      contentPanel.add(textFieldCreatedBy);
    }
    {
      lblCountry = new JLabel("Country  :");
      lblCountry.setFont(new Font("Tahoma", Font.BOLD, 14));
      lblCountry.setBounds(22, 286, 93, 26);
      contentPanel.add(lblCountry);
    }

    comboBoxCountry = new JComboBox();
    comboBoxCountry.setBounds(104, 283, 260, 36);

    comboBoxModel = new DefaultComboBoxModel();
    comboBoxCountry.setModel(comboBoxModel);

    contentPanel.add(comboBoxCountry);
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
        Project newProject = new Project(textFieldName.getText(), textFieldDescription.getText(),
            textFieldCustomer.getText(), new Country((String) comboBoxCountry.getSelectedItem()),
            textFieldCreatedBy.getText(), user.getUserId(), oldProject.getCreatedDate(),
            LocalDateTime.now());
        try {

          projectService.updateProject(oldProject, newProject);

        } catch (Exception e1) {

          e1.printStackTrace();
        }

        selfReference.dispose();
      }
    });

    cancelButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        selfReference.dispose();
      }
    });

  }

  private void loadCountries() {
    comboBoxModel.removeAllElements();
    List<Country> countryList = null;
    try {

      countryList = countryService.getAllCountries();

    } catch (Exception e) {

      e.printStackTrace();
    }
    if (countryList != null && countryList.size() != 0) {
      for (Country country : countryList) {
        comboBoxModel.addElement(country.getCountryName());
      }

    }
  }

  private void fillDetails() {
    textFieldName.setText(oldProject.getProjectName());
    textFieldDescription.setText(oldProject.getDescription());
    textFieldCustomer.setText(oldProject.getCustomer());
    textFieldCreatedBy.setText(oldProject.getCreatedBy());
    String country = oldProject.getCountry().getCountryName();
    comboBoxCountry.setSelectedItem(country);

  }
}
