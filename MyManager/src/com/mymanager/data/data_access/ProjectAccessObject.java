package com.mymanager.data.data_access;

import java.util.List;

import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.models.Project;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ProjectAccessObject implements ProjectAccess {

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
