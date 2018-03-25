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

	@Override
	public List<Project> readAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readAllProjectsByCustomer(String customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readAllProjectsByDescription(String projectDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readAllProjectsByName(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProject(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertProject(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProject(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

}
