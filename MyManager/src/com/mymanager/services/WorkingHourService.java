package com.mymanager.services;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.models.WorkingHour;

public interface WorkingHourService {

	public abstract List<WorkingHour> getAllWorkingHour() throws Exception;

	public abstract List<WorkingHour> getAllWorkingHour(int limit, int offset) throws Exception;

	public abstract List<WorkingHour> getWorkingHourByEmplyeeId(String employeeId) throws Exception;

	public abstract List<WorkingHour> getWorkingHourByDate(LocalDate date) throws Exception;

	public abstract List<WorkingHour> getWorkingHourByBetween(float minHours, float maxHours) throws Exception;

	public abstract WorkingHour getWorkingHourByIndex(int index) throws Exception;

	public abstract int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception;

	public abstract int saveWorkingHour(WorkingHour workingHour) throws Exception;

	public abstract int deleteWorkingHour(WorkingHour workingHour) throws Exception;
}
