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

	public abstract List<WorkingHour> readAllWorkingHour();

	public abstract List<WorkingHour> readWorkingHourByEmplyeeId(String employeeId);

	public abstract List<WorkingHour> readWorkingHourByDate(LocalDate date);

	public abstract List<WorkingHour> readWorkingHourByBetween(float minHours, float maxHours);

	public abstract int updateWorkingHour(WorkingHour workingHour);

	public abstract int insertWorkingHour(WorkingHour workingHour);

	public abstract int deleteWorkingHour(WorkingHour workingHour);

}
