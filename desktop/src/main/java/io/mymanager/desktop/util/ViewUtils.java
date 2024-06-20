package io.mymanager.desktop.util;

import io.mymanager.desktop.view.subviews.custom.MyPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author gentjan kolicaj
 */
public class ViewUtils {

  public static int x, y;

  public static void makePanelMove(JFrame jframe, JPanel jpanel) {
    jpanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
      }

    });
    jpanel.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        int xx = e.getXOnScreen();
        int yy = e.getYOnScreen();
        jframe.setLocation(xx - x, yy - y);
      }
    });

  }

  public static void openMainView(JFrame jframe, JPanel oldPanel, MyPanel newPanel) {
    jframe.getContentPane().remove(oldPanel);
    jframe.setSize(newPanel.getMyWidth(), newPanel.getMyHeight());
    jframe.setContentPane(newPanel);
    jframe.repaint();

  }

  public static void changeAccountPanel(JFrame jframe, JPanel oldPanel, MyPanel newPanel) {
    jframe.getContentPane().remove(oldPanel);
    jframe.setSize(newPanel.getMyWidth() + 10, newPanel.getMyHeight() + 50);
    jframe.setContentPane(newPanel);
    jframe.repaint();

  }

  public static void changeView(JFrame jframe, MyPanel oldPanel, MyPanel newPanel) {
    jframe.getContentPane().remove(oldPanel);
    jframe.setSize(newPanel.getMyWidth() + 10, newPanel.getMyHeight() + 10);
    newPanel.loadData(); // fills table of new view with data
    jframe.setContentPane(newPanel);
    jframe.repaint();

  }

  public static void changeUserView(MyPanel mainPanel, MyPanel newPanel, MyPanel oldPanel) {
    mainPanel.remove(oldPanel);
    mainPanel.setSize(mainPanel.getWidth() + newPanel.getMyWidth(), newPanel.getMyHeight());
    newPanel.setBounds(134, 11, newPanel.getMyWidth(), newPanel.getMyHeight());
    newPanel.loadData(); // fills table of new view with data
    mainPanel.add(newPanel);
    mainPanel.repaint();

  }

  public static void changeEmpView(MyPanel mainPanel, MyPanel newPanel, MyPanel oldPanel) {
    mainPanel.remove(oldPanel);
    mainPanel.setSize(mainPanel.getWidth() + newPanel.getMyWidth(), newPanel.getMyHeight());
    newPanel.setBounds(134, 11, newPanel.getMyWidth(), newPanel.getMyHeight());
    newPanel.loadData(); // fills table of new view with data
    mainPanel.add(newPanel);
    mainPanel.repaint();

  }

  public static void returnToMainView(JFrame jframe, MyPanel oldPanel, MyPanel mainView) {
    jframe.getContentPane().remove(oldPanel);
    jframe.setSize(mainView.getMyWidth(), mainView.getMyHeight());
    jframe.setContentPane(mainView);
    jframe.repaint();

  }


}
