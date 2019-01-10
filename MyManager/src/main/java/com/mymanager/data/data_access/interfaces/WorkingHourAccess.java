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

	public abstract List<WorkingHour> findAllWorkingHour() throws Exception;

	public abstract List<WorkingHour> findAllWorkingHour(int limit, int offset) throws Exception;

	public abstract List<WorkingHour> findWorkingHourByEmplyeeId(String employeeId) throws Exception;

	public abstract List<WorkingHour> findWorkingHourByDate(LocalDate date) throws Exception;

	public abstract List<WorkingHour> findWorkingHourByBetween(float minHours, float maxHours) throws Exception;

	public abstract WorkingHour findWorkingHourByIndex(int index) throws Exception;

	public abstract int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception;

	public abstract int saveWorkingHour(WorkingHour workingHour) throws Exception;

	public abstract int deleteWorkingHour(WorkingHour workingHour) throws Exception;

}
