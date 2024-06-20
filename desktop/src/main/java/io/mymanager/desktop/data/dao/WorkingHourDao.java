package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.WorkingHour;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface WorkingHourDao {

  List<WorkingHour> findAllWorkingHour() throws Exception;

  List<WorkingHour> findAllWorkingHour(int limit, int offset) throws Exception;

  List<WorkingHour> findWorkingHourByEmplyeeId(String employeeId) throws Exception;

  List<WorkingHour> findWorkingHourByDate(LocalDate date) throws Exception;

  List<WorkingHour> findWorkingHourByBetween(float minHours, float maxHours) throws Exception;

  WorkingHour findWorkingHourByIndex(int index) throws Exception;

  int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception;

  int saveWorkingHour(WorkingHour workingHour) throws Exception;

  int deleteWorkingHour(WorkingHour workingHour) throws Exception;

}
