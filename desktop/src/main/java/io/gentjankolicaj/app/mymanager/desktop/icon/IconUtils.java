package io.gentjankolicaj.app.mymanager.desktop.icon;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * @author gentjan kolicaj
 */
@Slf4j
public class IconUtils {


    public static String inputIcon = "icons/icons_45x45/icons8-warn.png";


    public static Image getImage(String filename) {
        try {
            return ImageIO.read(Thread.currentThread().getContextClassLoader().getResource(filename));
        } catch (Exception e) {
            log.error("Error loading image {}.", filename, e);
            return null;
        }
    }

    public static Icon getIcon(String filename) {
        try {
            return new ImageIcon(Thread.currentThread().getContextClassLoader().getResource(filename));
        } catch (Exception e) {
            log.error("Error loading image {}.", filename, e);
            return null;
        }
    }
}
