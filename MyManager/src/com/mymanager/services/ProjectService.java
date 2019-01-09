package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Project;

public interface ProjectService {

	public abstract List<Project> getAllProjects() throws Exception;

	public abstract List<Project> getAllProjects(int limit, int offset) throws Exception;

	public abstract List<Project> getAllProjectsByCustomer(String customer) throws Exception;

	public abstract List<Project> getAllProjectsByDescription(String projectDescription) throws Exception;

	public abstract Project getProjectByName(String projectName) throws Exception;

	public abstract int updateProject(Project oldProject, Project newProject) throws Exception;

	public abstract int saveProject(Project project) throws Exception;

	public abstract int deleteProject(Project project) throws Exception;
}
