package com.mymanager.services;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.WorkingHourAccessObject;
import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.models.WorkingHour;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class WorkingHourServiceImpl implements WorkingHourService {

	private WorkingHourAccess workingHourAccess;
	
	public WorkingHourServiceImpl() {
		super();
		this.workingHourAccess=new WorkingHourAccessObject();
	}
	
	
	@Override
	public List<WorkingHour> getAllWorkingHour() throws Exception {
		return workingHourAccess.findAllWorkingHour();
	}

	@Override
	public List<WorkingHour> getAllWorkingHour(int limit, int offset) throws Exception {
		return workingHourAccess.findAllWorkingHour(limit, offset);
	}

	@Override
	public List<WorkingHour> getWorkingHourByEmplyeeId(String employeeId) throws Exception {
		return workingHourAccess.findWorkingHourByEmplyeeId(employeeId);
	}

	@Override
	public List<WorkingHour> getWorkingHourByDate(LocalDate date) throws Exception {
		return workingHourAccess.findWorkingHourByDate(date);
	}

	@Override
	public List<WorkingHour> getWorkingHourByBetween(float minHours, float maxHours) throws Exception {
		return workingHourAccess.findWorkingHourByBetween(minHours,maxHours);
	}

	@Override
	public WorkingHour getWorkingHourByIndex(int index) throws Exception {
		return workingHourAccess.findWorkingHourByIndex(index);
	}

	@Override
	public int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour) throws Exception {
		return workingHourAccess.updateWorkingHour(oldWorkingHour, newWorkingHour);
	}

	@Override
	public int saveWorkingHour(WorkingHour workingHour) throws Exception {
		return workingHourAccess.saveWorkingHour(workingHour);
	}

	@Override
	public int deleteWorkingHour(WorkingHour workingHour) throws Exception {
		return workingHourAccess.deleteWorkingHour(workingHour);
	}

}
