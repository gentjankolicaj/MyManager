package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Project;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ProjectAccessObject implements ProjectAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public ProjectAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public ProjectAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Project> readAllProjects() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readAllProjectsByCustomer(String customer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readAllProjectsByDescription(String projectDescription) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readAllProjectsByName(String projectName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
