package io.gentjankolicaj.app.mymanager.desktop.icon;

import io.gentjankolicaj.app.mymanager.desktop.enums.PrintType;
import io.gentjankolicaj.app.mymanager.desktop.util.PrintUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author gentjan kolicaj
 */
public class AppIcon {

    public static String appIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/png/Boss.png";

    public static String appImage = "io/gentjankolicaj/apps/mymanager/resources/icons/png/image.png";

    // Functionality Icons
    public static String usersIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String employeesIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String adressIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String contactIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String attemptsIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String countryIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String currencyIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String departmentIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String documentIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String fileTypeIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String jobIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String jobHistoryIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String paymentIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String projectIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String workingHourIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";

    // CRUD Icons
    public static String searchIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String saveIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String deleteIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String cancelIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String editIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String newIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";

    // Navigate Icons
    public static String backIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String backwardIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String forwardIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String loginIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String logoutIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";

    // Utils Icons
    public static String celularIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String telephoneIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String emailIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String cityIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String planetIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";

    public static String smileIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String stopIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";

    public static String dataIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String uploadIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";
    public static String downloadIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/test.jpg";

    public static String successIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";
    public static String plainIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";
    public static String warningIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";
    public static String infoIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";
    public static String errorIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";
    public static String questionIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";
    public static String inputIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";

    public static String testIcon = "io/gentjankolicaj/apps/mymanager/resources/icons/icons_45x45/icons8-warn.png";

    /**
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
