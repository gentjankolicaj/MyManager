package com.mymanager.data.data_access;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.models.WorkingHour;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class WorkingHourAccessObject implements WorkingHourAccess {

	@Override
	public List<WorkingHour> readAllWorkingHour() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingHour> readWorkingHourByEmplyeeId(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingHour> readWorkingHourByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingHour> readWorkingHourByBetween(float minHours, float maxHours) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateWorkingHour(WorkingHour workingHour) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertWorkingHour(WorkingHour workingHour) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWorkingHour(WorkingHour workingHour) {
		// TODO Auto-generated method stub
		return 0;
	}

}
