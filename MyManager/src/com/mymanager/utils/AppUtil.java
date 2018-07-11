package com.mymanager.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mymanager.controllers.AdminController;
import com.mymanager.controllers.AssistantController;
import com.mymanager.controllers.FinanceController;
import com.mymanager.controllers.HumanResourceController;
import com.mymanager.controllers.ManagerController;
import com.mymanager.controllers.UserController;
import com.mymanager.data.models.User;
import com.mymanager.data.models.UserType;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AppUtil {
	public static int x, y;

	public static void setBoundsAccordingToPanel(JFrame jframe, JPanel jpanel, int x, int y) {
		int width = jpanel.getWidth();
		int height = jpanel.getHeight();
		jframe.setBounds(x, y, width, height);
	}

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

	public static void changePanel(JFrame jframe, JPanel jpanel) {
		jframe.setContentPane(jpanel);
		jframe.invalidate();
		jframe.validate();
	}

	public static UserController decideController(User user) {
		if (user.getUserType().equals(UserType.ADMIN)) {
			return new AdminController(user);
		} else if (user.getUserType().equals(UserType.ASSISTANT)) {
			return new AssistantController(user);
		} else if (user.getUserType().equals(UserType.FINANCE)) {
			return new FinanceController(user);
		} else if (user.getUserType().equals(UserType.HR)) {
			return new HumanResourceController(user);
		} else {
			return new ManagerController(user);
		}
	}

	public static boolean validateUser(User user, String userId, String password) {
		boolean status = false;
		String userIdTemp = user.getUserId();
		String userPassTemp = user.getPassword();
		if ((userIdTemp.equals(userId)) && (userPassTemp.equals(password))) {
			status = true;
		}
		return status;
	}

}
