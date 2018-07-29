package com.mymanager.data.data_access.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.models.WorkingHour;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface WorkingHourAccess {

	public abstract List<WorkingHour> readAllWorkingHour() throws Exception;

	public abstract List<WorkingHour> readAllWorkingHour(int limit, int offset) throws Exception;

	public abstract List<WorkingHour> readWorkingHourByEmplyeeId(String employeeId) throws Exception;

	public abstract List<WorkingHour> readWorkingHourByDate(LocalDate date) throws Exception;

	public abstract List<WorkingHour> readWorkingHourByBetween(float minHours, float maxHours) throws Exception;

	public abstract WorkingHour readWorkingHourByIndex(int index) throws Exception;

	public abstract int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception;

	public abstract int insertWorkingHour(WorkingHour workingHour) throws Exception;

	public abstract int deleteWorkingHour(WorkingHour workingHour) throws Exception;

}
