package com.mymanager.config;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AppIcon {

	public static String appIcon = "com/mymanager/resources/icons/png/Boss.png";

	public static String appImage = "com/mymanager/resources/icons/png/image.png";

	// Functionality Icons
	public static String usersIcon = "com/mymanager/resources/icons/test.jpg";
	public static String employeesIcon = "com/mymanager/resources/icons/test.jpg";
	public static String adressIcon = "com/mymanager/resources/icons/test.jpg";
	public static String contactIcon = "com/mymanager/resources/icons/test.jpg";
	public static String attemptsIcon = "com/mymanager/resources/icons/test.jpg";
	public static String countryIcon = "com/mymanager/resources/icons/test.jpg";
	public static String currencyIcon = "com/mymanager/resources/icons/test.jpg";
	public static String departmentIcon = "com/mymanager/resources/icons/test.jpg";
	public static String documentIcon = "com/mymanager/resources/icons/test.jpg";
	public static String fileTypeIcon = "com/mymanager/resources/icons/test.jpg";
	public static String jobIcon = "com/mymanager/resources/icons/test.jpg";
	public static String jobHistoryIcon = "com/mymanager/resources/icons/test.jpg";
	public static String paymentIcon = "com/mymanager/resources/icons/test.jpg";
	public static String projectIcon = "com/mymanager/resources/icons/test.jpg";
	public static String workingHourIcon = "com/mymanager/resources/icons/test.jpg";

	// CRUD Icons
	public static String searchIcon = "com/mymanager/resources/icons/test.jpg";
	public static String saveIcon = "com/mymanager/resources/icons/test.jpg";
	public static String deleteIcon = "com/mymanager/resources/icons/test.jpg";
	public static String cancelIcon = "com/mymanager/resources/icons/test.jpg";
	public static String editIcon = "com/mymanager/resources/icons/test.jpg";
	public static String newIcon = "com/mymanager/resources/icons/test.jpg";

	// Navigate Icons
	public static String backIcon = "com/mymanager/resources/icons/test.jpg";
	public static String backwardIcon = "com/mymanager/resources/icons/test.jpg";
	public static String forwardIcon = "com/mymanager/resources/icons/test.jpg";
	public static String loginIcon = "com/mymanager/resources/icons/test.jpg";
	public static String logoutIcon = "com/mymanager/resources/icons/test.jpg";

	// Utils Icons
	public static String celularIcon = "com/mymanager/resources/icons/test.jpg";
	public static String telephoneIcon = "com/mymanager/resources/icons/test.jpg";
	public static String emailIcon = "com/mymanager/resources/icons/test.jpg";
	public static String cityIcon = "com/mymanager/resources/icons/test.jpg";
	public static String planetIcon = "com/mymanager/resources/icons/test.jpg";

	public static String smileIcon = "com/mymanager/resources/icons/test.jpg";
	public static String stopIcon = "com/mymanager/resources/icons/test.jpg";

	public static String dataIcon = "com/mymanager/resources/icons/test.jpg";
	public static String uploadIcon = "com/mymanager/resources/icons/test.jpg";
	public static String downloadIcon = "com/mymanager/resources/icons/test.jpg";

	public static String successIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";
	public static String plainIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";
	public static String warningIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";
	public static String infoIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";
	public static String errorIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";
	public static String questionIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";
	public static String inputIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";

	public static String testIcon = "com/mymanager/resources/icons/icons_45x45/icons8-warn.png";

	/**
	 *
	 * 
	 * Methods for loading images
	 */
	public static ImageIcon getImageIcon(String iconPath) {
		ImageIcon icon = new ImageIcon(AppIcon.class.getClassLoader().getResource(iconPath));
		return icon;
	}

	public static Icon getIcon(String iconPath) {
		Icon icon = new ImageIcon(AppIcon.class.getClassLoader().getResource(iconPath));
		return icon;
	}

	public static Image getImage(String imagePath) {
		Image img = null;
		try {
			img = ImageIO.read(AppIcon.class.getClassLoader().getResourceAsStream(imagePath));
		} catch (IOException io) {

			PrintUtils.print(io, PrintType.EXCEPTION);

		}
		return img;
	}

	/**
	 * To be fixed below method because are throwing NPE
	 * 
	 * 
	 * 
	 * 
	 */
	public static ImageIcon getImageIcon(Object obj, String iconPath) {
		ImageIcon icon = new ImageIcon(obj.getClass().getResource(iconPath));
		return icon;
	}

	public static Icon getIcon(Object obj, String iconPath) {
		Icon icon = new ImageIcon(obj.getClass().getResource(iconPath));
		return icon;
	}

	public static Image getImage(Object obj, String imagePath) {
		Image img = null;
		try {
			img = ImageIO.read(obj.getClass().getResourceAsStream(imagePath));
		} catch (IOException io) {

			PrintUtils.print(io, PrintType.EXCEPTION);

		}
		return img;
	}
}
