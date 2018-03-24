package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Project;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface ProjectAccess {

	public abstract List<Project> readAllProjects();

	public abstract List<Project> readAllProjectsByCustomer(String customer);

	public abstract List<Project> readAllProjectsByDescription(String projectDescription);

	public abstract List<Project> readAllProjectsByName(String projectName);

	public abstract int updateProject(Project project);

	public abstract int insertProject(Project project);

	public abstract int deleteProject(Project project);

}
