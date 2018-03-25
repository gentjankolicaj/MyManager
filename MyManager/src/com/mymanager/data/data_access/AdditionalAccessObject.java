package com.mymanager.data.data_access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.AdditionalAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Additional;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AdditionalAccessObject implements AdditionalAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	public AdditionalAccessObject() {
		this.queryType = QueryType.NORMAL;
	}

	public AdditionalAccessObject(QueryType queryType) {
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;

	}

	@Override
	public List<Additional> readAllAdditionals() {
		List<Additional> additionalList = new ArrayList<>();
		try {

			ResultSet res = database.selectStatement("Select * from ");

		} catch (SQLException e) {
			PrintUtils.print(e, PrintType.DATABASE_QUERY);
		}

		return additionalList;

	}

	@Override
	public Additional readAdditional(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAdditional(Additional additional) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAdditional(Additional additional) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAdditional(Additional additional) {
		// TODO Auto-generated method stub
		return 0;
	}

}
