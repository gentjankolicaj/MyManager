package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.DocumentAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Document;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DocumentAccessObject implements DocumentAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public DocumentAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public DocumentAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Document> readAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> readDocuments(String documentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document readDocument(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Document readDocument(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDocument(Document document) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDocument(Document document) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDocument(Document document) {
		// TODO Auto-generated method stub
		return 0;
	}

}
