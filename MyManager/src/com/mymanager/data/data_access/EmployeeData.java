package com.mymanager.data.data_access;

import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabasePool;

public class EmployeeData {

	private static Database database = DatabasePool.getReference(new Integer(1));

}
