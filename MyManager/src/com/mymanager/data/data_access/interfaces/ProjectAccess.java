package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Project;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface ProjectAccess {

	public abstract List<Project> readAllProjects() throws Exception;

	public abstract List<Project> readAllProjectsByCustomer(String customer) throws Exception;

	public abstract List<Project> readAllProjectsByDescription(String projectDescription) throws Exception;

	public abstract List<Project> readAllProjectsByName(String projectName) throws Exception;

	public abstract int updateProject(Project project) throws Exception;

	public abstract int insertProject(Project project) throws Exception;

	public abstract int deleteProject(Project project) throws Exception;

}
