package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.AtemptAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Atempt;
import com.mymanager.data.models.Status;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AtemptAccessObject implements AtemptAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	@Override
	public List<Atempt> readAllAtempts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atempt> readAtempts(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atempt> readAtempts(Status status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAtempt(Atempt atempt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAtempt(Atempt atempt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
