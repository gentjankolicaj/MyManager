package io.mymanager.desktop.config;

import io.mymanager.desktop.enums.PrintEnvironment;
import io.mymanager.desktop.enums.PrintFormatType;

/**
 * @author gentjan kolicaj
 */
public class Config {

  // ====================================================
  // ====================================================
  public static final int ROW_LIMIT = 1000;
  public static final int USER_OFFSET = 0;
  public static final int EMPLOYEE_OFFSET = 0;
  public static final int USER_ADRESS_OFFSET = 0;
  public static final int EMPLOYEE_ADRESS_OFFSET = 0;
  public static final int USER_CONTACT_OFFSET = 0;
  public static final int EMPLOYEE_CONTACT_OFFSET = 0;
  public static final int EMPLOYEE_DOCUMENT_OFFSET = 0;
  public static final int PAYMENTS_OFFSET = 0;
  public static final int DEPARTMENT_OFFSET = 0;
  public static final int JOB_OFFSET = 0;
  public static final int PROJECT_OFFSET = 0;
  public static final int ATTEMPT_OFFSET = 0;
  public static final int WORKINGHOUR_OFFSET = 0;
  public static final int ADDITIONAL_OFFSET = 0;
  public static int FRAME_WIDTH = 910;
  public static int FRAME_HEIGHT = 690;

  // ================================================
  // ================================================
  public static boolean PRINT_EXCEPTION = true;
  public static boolean PRINT_FILE_IO = true;
  public static boolean PRINT_DATABASE_QUERY = true;
  public static boolean PRINT_DATABASE_IO = true;
  public static boolean PRINT_LOG = true;
  public static boolean PRINT_OTHER = true;
  public static boolean PRINT_QUERY_RESULTS = true;

  public static PrintFormatType PRINT_FORMAT = PrintFormatType.JSON;
  public static PrintEnvironment PRINT_ENV = PrintEnvironment.LOG;

  // Message Pain
  public static boolean MESSAGE_WINDOWS = true;

  public static boolean PLAIN_MESSAGE = true;
  public static boolean WARNING_MESSAGE = true;
  public static boolean ERROR_MESSAGE = true;
  public static boolean INFO_MESSAGE = true;
  public static boolean QUESTION_MESSAGE = true;

  // decides for scope of message window
  public static boolean ADMIN_CONTROLLER = true;
  public static boolean ASSISTANT_CONTROLLER = true;
  public static boolean FINANCE_CONTROLLER = true;
  public static boolean HR_CONTROLLER = true;
  public static boolean MANAGER_CONTROLLER = true;

  // OPTION Pane
  public static boolean OPTION_WINDOWS = true;

  public static boolean DEFAULT = true;
  public static boolean YES_NO = true;
  public static boolean YES_NO_CANCEL = true;
  public static boolean OK_CANCEL = true;

  // INPUT PANE
  public static boolean INPUT_WINDOWS = true;

  /*
   * Config values are overriden by application.properties file is necesary
   */
  static {

  }

}
