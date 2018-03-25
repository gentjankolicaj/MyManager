package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Adress;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AdressAccessObject implements AdressAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * @param queryType
	 */
	public AdressAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public AdressAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Adress> readAllAdresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adress readAdress(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAdress(Adress adress) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAdress(Adress adress) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAdress(Adress adress) {
		// TODO Auto-generated method stub
		return 0;
	}

}
