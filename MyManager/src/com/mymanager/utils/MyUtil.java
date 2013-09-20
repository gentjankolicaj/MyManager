package com.mymanager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author gentjan kolicaj
 *
 */
public class MyUtil {

	public static boolean areEquals(ArrayList<String> firstList, ArrayList<String> secondList) {
		if (firstList.size() != secondList.size()) {
			return true;
		} else {
			boolean flag = true;
			for (int i = 0; i < firstList.size(); i++) {
				String first = firstList.get(i);
				String second = secondList.get(i);
				if (!first.equals(second))
					flag = false;
			}
			return flag;
		}
	}

	public static Date parseDate(String stringDate, String dateFormat) throws ParseException {
		Date parsedDate = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		parsedDate = dateFormatter.parse(stringDate);
		return parsedDate;

	}

}
