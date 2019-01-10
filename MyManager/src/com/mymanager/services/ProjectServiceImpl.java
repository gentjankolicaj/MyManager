package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.ProjectAccessObject;
import com.mymanager.data.data_access.interfaces.ProjectAccess;
import com.mymanager.data.models.Project;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class ProjectServiceImpl implements ProjectService {
	
	private ProjectAccess projectAccess;
	
	public ProjectServiceImpl() {
		super();
		this.projectAccess=new ProjectAccessObject();
	}

	@Override
	public List<Project> getAllProjects() throws Exception {
    	return projectAccess.findAllProjects();
	}

	@Override
	public List<Project> getAllProjects(int limit, int offset) throws Exception {
		return projectAccess.findAllProjects(limit,offset);
	}

	@Override
	public List<Project> getAllProjectsByCustomer(String customer) throws Exception {
		return projectAccess.findAllProjectsByCustomer(customer);
	}

	@Override
	public List<Project> getAllProjectsByDescription(String projectDescription) throws Exception {
		return projectAccess.findAllProjectsByDescription(projectDescription);
	}

	@Override
	public Project getProjectByName(String projectName) throws Exception {
		return projectAccess.findProjectByName(projectName);
	}

	@Override
	public int updateProject(Project oldProject, Project newProject) throws Exception {
		return projectAccess.updateProject(oldProject, newProject);
	}

	@Override
	public int saveProject(Project project) throws Exception {
		return projectAccess.saveProject(project);
	}

	@Override
	public int deleteProject(Project project) throws Exception {
		return projectAccess.deleteProject(project);
	}

}
