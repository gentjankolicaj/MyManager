package io.mymanager.desktop.view.subviews;

import io.mymanager.desktop.data.models.FileType;
import io.mymanager.desktop.data.models.MyTable;
import io.mymanager.desktop.icon.IconUtils;
import io.mymanager.desktop.service.FileTypeService;
import io.mymanager.desktop.service.impl.FileTypeServiceImpl;
import io.mymanager.desktop.view.subviews.create.CreateFile;
import io.mymanager.desktop.view.subviews.edit.EditFile;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FileView extends JDialog {

  /**
   *
   */
  private static final long serialVersionUID = 3273760413900388001L;
  private final JPanel contentPanel = new JPanel();
  // Service fields
  private final FileTypeService fileTypeService;
  private JButton btnDelete;
  private JButton btnEdit;
  private JButton btnCreate;
  private DefaultTableModel tableModel;
  private List<FileType> fileTypeList;
  private MyTable table;
  private JScrollPane scrollPane;

  /**
   * Create the dialog.
   */
  public FileView() {
    setTitle("ALL FILE TYPES");
    this.fileTypeService = new FileTypeServiceImpl();

    initComponents();
    initEvents();

    updateTable();
  }

  public void initComponents() {
    setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-new-file-3.png"));
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 420, 380);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    btnCreate = new JButton("Create");

    btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-add-2.png"));
    btnCreate.setBounds(10, 23, 108, 23);
    contentPanel.add(btnCreate);

    btnEdit = new JButton("Edit");
    btnEdit.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-edit-3.png"));
    btnEdit.setBounds(10, 68, 108, 23);
    contentPanel.add(btnEdit);

    btnDelete = new JButton("Delete");
    btnDelete.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-minus-2.png"));
    btnDelete.setBounds(10, 116, 108, 23);
    contentPanel.add(btnDelete);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(128, 23, 266, 306);

    table = new MyTable();
    table.setCellSelectionEnabled(true);
    tableModel = new DefaultTableModel();
    tableModel.setColumnIdentifiers(new String[]{"File type"});
    table.setModel(tableModel);
    scrollPane.setViewportView(table);

    contentPanel.add(scrollPane);
  }

  private void initEvents() {
    btnCreate.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        CreateFile createFile = new CreateFile(fileTypeService);
        createFile.setModal(true);
        createFile.setVisible(true);

        updateTable();

      }
    });

    btnEdit.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        FileType oldFileType = fileTypeList.get(index);
        EditFile editFile = new EditFile(fileTypeService, oldFileType);
        editFile.setModal(true);
        editFile.setVisible(true);

        updateTable();
      }
    });

    btnDelete.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        int index = table.getSelectedRow();
        String fileType = (String) tableModel.getValueAt(index, 0);
        try {

          fileTypeService.deleteFileType(new FileType(fileType));

        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

        updateTable();
      }
    });

  }

  public void updateTable() {
    emptyTable();
    try {

      fileTypeList = fileTypeService.getAllFileTypes();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }

    if (fileTypeList != null && fileTypeList.size() != 0) {
      Object[] obj = new Object[1];
      for (FileType fileType : fileTypeList) {
        obj[0] = fileType.getFile();
        tableModel.addRow(obj);
      }

    }
  }

  private void emptyTable() {
    tableModel.setRowCount(0);
  }
}
