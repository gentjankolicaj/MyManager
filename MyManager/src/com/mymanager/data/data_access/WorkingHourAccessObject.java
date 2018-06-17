package com.mymanager.data.data_access;

import java.time.LocalDate;
import java.util.List;

import com.mymanager.data.data_access.interfaces.WorkingHourAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.WorkingHour;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class WorkingHourAccessObject implements WorkingHourAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public WorkingHourAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public WorkingHourAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<WorkingHour> readAllWorkingHour() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingHour> readWorkingHourByEmplyeeId(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingHour> readWorkingHourByDate(LocalDate date) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkingHour> readWorkingHourByBetween(float minHours, float maxHours) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateWorkingHour(WorkingHour workingHour) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertWorkingHour(WorkingHour workingHour) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWorkingHour(WorkingHour workingHour) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
