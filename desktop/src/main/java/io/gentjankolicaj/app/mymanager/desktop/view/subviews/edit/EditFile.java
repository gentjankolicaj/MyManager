package io.gentjankolicaj.app.mymanager.desktop.view.subviews.edit;

import io.gentjankolicaj.app.mymanager.desktop.data.models.FileType;
import io.gentjankolicaj.app.mymanager.desktop.icon.IconUtils;
import io.gentjankolicaj.app.mymanager.desktop.service.FileTypeService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditFile extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8197507233437896919L;
	private final JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldFile;
	private final FileType oldFileType;

	// Service fields
	private final FileTypeService fileTypeService;
	/**
	 * Create the dialog.
	 */
	public EditFile(FileTypeService fileTypeService, FileType oldFileType) {
		setTitle("Edit file type");
		this.selfReference = this;
	    this.fileTypeService=fileTypeService;
		this.oldFileType = oldFileType;
		initComponents();
		textFieldFile.setText(oldFileType.getFile());
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newFileType = textFieldFile.getText();
				try {
					
					fileTypeService.updateFileType(oldFileType, new FileType(newFileType));
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				selfReference.dispose();
			}
		});

		textFieldFile.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String newFileType = textFieldFile.getText();
					try {
						
						fileTypeService.updateFileType(oldFileType, new FileType(newFileType));
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
		setIconImage(IconUtils.getImage("icons/icons_24x24/icons8-edit-file-3.png"));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnCreate = new JButton("Save");
		btnCreate.setIcon(IconUtils.getIcon("icons/icons_24x24/icons8-save-2.png"));
		btnCreate.setBounds(245, 23, 113, 24);
		contentPanel.add(btnCreate);

		textFieldFile = new JTextField();
		textFieldFile.setBounds(10, 24, 225, 22);
		contentPanel.add(textFieldFile);
		textFieldFile.setColumns(10);
	}

}
