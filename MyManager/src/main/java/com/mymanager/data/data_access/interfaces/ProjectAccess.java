package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Project;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface ProjectAccess {

	public abstract List<Project> findAllProjects() throws Exception;

	public abstract List<Project> findAllProjects(int limit, int offset) throws Exception;

	public abstract List<Project> findAllProjectsByCustomer(String customer) throws Exception;

	public abstract List<Project> findAllProjectsByDescription(String projectDescription) throws Exception;

	public abstract Project findProjectByName(String projectName) throws Exception;

	public abstract int updateProject(Project oldProject, Project newProject) throws Exception;

	public abstract int saveProject(Project project) throws Exception;

	public abstract int deleteProject(Project project) throws Exception;

}
