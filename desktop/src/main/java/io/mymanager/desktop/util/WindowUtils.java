package io.mymanager.desktop.util;

import io.mymanager.desktop.config.AppText;
import io.mymanager.desktop.config.Config;
import io.mymanager.desktop.domain.Answer;
import io.mymanager.desktop.enums.MessageType;
import io.mymanager.desktop.enums.OptionType;
import io.mymanager.desktop.icon.IconUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * @author gentjan kolicaj
 */
public class WindowUtils {

  public static void showMessage(Component component, String text, MessageType messageType) {
    if (Config.MESSAGE_WINDOWS) {
      if (messageType.equals(MessageType.PLAIN) && Config.PLAIN_MESSAGE) {
        JOptionPane.showMessageDialog(component, text, AppText.plainLabel,
            JOptionPane.PLAIN_MESSAGE);
      } else if (messageType.equals(MessageType.INFORMATION) && Config.INFO_MESSAGE) {
        JOptionPane.showMessageDialog(component, text, AppText.infoLabel,
            JOptionPane.INFORMATION_MESSAGE);
      } else if (messageType.equals(MessageType.QUESTION) && Config.QUESTION_MESSAGE) {
        JOptionPane.showMessageDialog(component, text, AppText.questionLabel,
            JOptionPane.QUESTION_MESSAGE);
      } else if (messageType.equals(MessageType.WARNING) && Config.WARNING_MESSAGE) {
        JOptionPane.showMessageDialog(component, text, AppText.warningLabel,
            JOptionPane.WARNING_MESSAGE);
      } else if (messageType.equals(MessageType.ERROR) && Config.ERROR_MESSAGE) {
        JOptionPane.showMessageDialog(component, text, AppText.errorLabel,
            JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public static void showMessage(Component component, String text, MessageType messageType,
      String scope) {
    if (Config.MESSAGE_WINDOWS) {
      if (decideScope(scope)) {
        if (messageType.equals(MessageType.PLAIN) && Config.PLAIN_MESSAGE) {
          JOptionPane.showMessageDialog(component, text, AppText.plainLabel,
              JOptionPane.PLAIN_MESSAGE);
        } else if (messageType.equals(MessageType.INFORMATION) && Config.INFO_MESSAGE) {
          JOptionPane.showMessageDialog(component, text, AppText.infoLabel,
              JOptionPane.INFORMATION_MESSAGE);
        } else if (messageType.equals(MessageType.QUESTION) && Config.QUESTION_MESSAGE) {
          JOptionPane.showMessageDialog(component, text, AppText.questionLabel,
              JOptionPane.QUESTION_MESSAGE);
        } else if (messageType.equals(MessageType.WARNING) && Config.WARNING_MESSAGE) {
          JOptionPane.showMessageDialog(component, text, AppText.warningLabel,
              JOptionPane.WARNING_MESSAGE);
        } else if (messageType.equals(MessageType.ERROR) && Config.ERROR_MESSAGE) {
          JOptionPane.showMessageDialog(component, text, AppText.errorLabel,
              JOptionPane.ERROR_MESSAGE);
        }
      }
    }
  }

  public static Answer showOption(Component component, String text, OptionType optionType) {
    int choiceValue = 10;
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
    return translateValue(choiceValue);
  }

  public static String showInput(Component component, String text, String[] choices,
      String defaultChoice) {
    String result = null;
    if (Config.INPUT_WINDOWS) {
      Icon icon = IconUtils.getIcon(IconUtils.inputIcon);
      result = (String) JOptionPane.showInputDialog(component, text, AppText.inputLabel,
          JOptionPane.QUESTION_MESSAGE, icon, choices, defaultChoice);
    }
    return result;

  }

  public static String showInput(Component component, String text, String[] choices) {
    Icon icon = IconUtils.getIcon(IconUtils.inputIcon);
    String result = null;
    result = (String) JOptionPane.showInputDialog(component, text, AppText.inputLabel,
        JOptionPane.QUESTION_MESSAGE,
        icon, choices, choices[0]);
    return result;

  }

  public static String showInput(Component component, String text) {
    Icon icon = IconUtils.getIcon(IconUtils.inputIcon);
    String result = null;
    result = JOptionPane.showInputDialog(component, text);
    return result;

  }

  private static Answer translateValue(int value) {
    if (value == -1) {
      return Answer.ClOSE;
    } else if (value == 0) {
      return Answer.YES;
    } else if (value == 1) {
      return Answer.NO;
    } else if (value == 2) {
      return Answer.CANCEL;
    } else {
      return Answer.UNKNOWN;
    }

  }

  private static boolean decideScope(String scope) {
    if (scope.equalsIgnoreCase("admin")) {
      return Config.ADMIN_CONTROLLER;
    } else if (scope.equalsIgnoreCase("assistant")) {
      return Config.ASSISTANT_CONTROLLER;
    } else if (scope.equalsIgnoreCase("finance")) {
      return Config.FINANCE_CONTROLLER;
    } else if (scope.equalsIgnoreCase("hr")) {
      return Config.HR_CONTROLLER;
    } else if (scope.equalsIgnoreCase("manager")) {
      return Config.MANAGER_CONTROLLER;
    } else {
      return false;
    }
  }
}
