package io.gentjankolicaj.app.mymanager.desktop.view.subviews.create;

import io.gentjankolicaj.app.mymanager.desktop.data.models.FileType;
import io.gentjankolicaj.app.mymanager.desktop.service.FileTypeService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateFile extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8197507233437896919L;
	private final JDialog selfReference;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCreate;
	private JTextField textFieldFile;


	// Service fields
	private final FileTypeService fileTypeService;

	/**
	 * Create the dialog.
	 */
	public CreateFile(FileTypeService fileTypeService) {
		setTitle("Create new file type");
		this.selfReference = this;
		this.fileTypeService=fileTypeService;
		
		initComponents();
		initEvents();

	}

	private void initEvents() {
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String newFileType = textFieldFile.getText();
				try {
					
					fileTypeService.saveFileType(new FileType(newFileType));
					
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
					String newFile = textFieldFile.getText();
					
					try {
						
						fileTypeService.saveFileType(new FileType(newFile));
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
					selfReference.dispose();
				}
			}
		});
	}

	private void initComponents() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(CreateFile.class.getResource("/io/gentjankolicaj/apps/mymanager/resources/icons/icons_24x24/icons8-new-file-3.png")));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 384, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

        btnCreate = new JButton("Save");
        btnCreate.setIcon(new ImageIcon(
                CreateCurrency.class.getResource("/io/gentjankolicaj/apps/mymanager/resources/icons/icons_24x24/icons8-save-2.png")));
        btnCreate.setBounds(245, 23, 113, 24);
		contentPanel.add(btnCreate);

		textFieldFile = new JTextField();
		textFieldFile.setBounds(10, 24, 215, 22);
		contentPanel.add(textFieldFile);
		textFieldFile.setColumns(10);
	}

}
