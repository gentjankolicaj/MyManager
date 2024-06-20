package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.WorkingHour;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface WorkingHourService {

  List<WorkingHour> getAllWorkingHour() throws Exception;

  List<WorkingHour> getAllWorkingHour(int limit, int offset) throws Exception;

  List<WorkingHour> getWorkingHourByEmplyeeId(String employeeId) throws Exception;

  List<WorkingHour> getWorkingHourByDate(LocalDate date) throws Exception;

  List<WorkingHour> getWorkingHourByBetween(float minHours, float maxHours) throws Exception;

  WorkingHour getWorkingHourByIndex(int index) throws Exception;

  int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception;

  int saveWorkingHour(WorkingHour workingHour) throws Exception;

  int deleteWorkingHour(WorkingHour workingHour) throws Exception;
}
