package com.mymanager.utils;

import java.awt.Component;

import javax.swing.JOptionPane;

import com.mymanager.config.AppIcon;
import com.mymanager.config.AppText;
import com.mymanager.config.Config;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UtilWindow {

	public static void showMessage(Component component, String text, MessageType messageType) {
		if (Config.MESSAGE_WINDOWS) {
			if (messageType.equals(MessageType.PLAIN) && Config.PLAIN_MESSAGE) {
				JOptionPane.showMessageDialog(component, text, AppText.plainLabel, JOptionPane.PLAIN_MESSAGE,
						AppIcon.getIcon(AppIcon.plainIcon));
			} else if (messageType.equals(MessageType.INFORMATION) && Config.INFO_MESSAGE) {
				JOptionPane.showMessageDialog(component, text, AppText.infoLabel, JOptionPane.INFORMATION_MESSAGE,
						AppIcon.getIcon(AppIcon.infoIcon));
			} else if (messageType.equals(MessageType.QUESTION) && Config.QUESTION_MESSAGE) {
				JOptionPane.showMessageDialog(component, text, AppText.questionLabel, JOptionPane.QUESTION_MESSAGE,
						AppIcon.getIcon(AppIcon.questionIcon));
			} else if (messageType.equals(MessageType.WARNING) && Config.WARNING_MESSAGE) {
				JOptionPane.showMessageDialog(component, text, AppText.warningLabel, JOptionPane.WARNING_MESSAGE,
						AppIcon.getIcon(AppIcon.warningIcon));
			} else if (messageType.equals(MessageType.ERROR) && Config.ERROR_MESSAGE) {
				JOptionPane.showMessageDialog(component, text, AppText.errorLabel, JOptionPane.ERROR_MESSAGE,
						AppIcon.getIcon(AppIcon.errorIcon));
			}
		}
	}

	public static OptionType showOption(Component component, String text, OptionType optionType) {
		int choiceValue = 0;
		OptionType type = null;
		if (Config.OPTION_WINDOWS) {
			if (optionType.equals(OptionType.DEFAULT) && Config.DEFAULT) {
				choiceValue = JOptionPane.showConfirmDialog(component, text, AppText.questionLabel,
						JOptionPane.DEFAULT_OPTION);
			} else if (optionType.equals(OptionType.OK_CANCEL) && Config.OK_CANCEL) {
				choiceValue = JOptionPane.showConfirmDialog(component, text, AppText.questionLabel,
						JOptionPane.OK_CANCEL_OPTION);
			} else if (optionType.equals(OptionType.YES_NO_CANCEL) && Config.YES_NO_CANCEL) {
				choiceValue = JOptionPane.showConfirmDialog(component, text, AppText.questionLabel,
						JOptionPane.YES_NO_CANCEL_OPTION);
			} else if (optionType.equals(OptionType.YES_NO) && Config.YES_NO) {
				choiceValue = JOptionPane.showConfirmDialog(component, text, AppText.questionLabel,
						JOptionPane.YES_NO_OPTION);
			}
		}

		return type;
	}

	public static void showInput(Component component, String text, MessageType messageType) {

	}

	private static OptionType translateValue(int value) {
		OptionType type = OptionType.DEFAULT;
		return type;
	}
}
