package io.mymanager.desktop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author gentjan kolicaj
 */
public class DateTimeUtils {

  public static Date parseDate(String stringDate, String pattern) throws ParseException {
    Date parsedDate = null;
    SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
    parsedDate = dateFormatter.parse(stringDate);
    return parsedDate;

  }

  public static LocalDate parseToLocalDate(String stringDate, String pattern)
      throws ParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    LocalDate localDate = LocalDate.parse(stringDate, formatter);
    return localDate;

  }


}
