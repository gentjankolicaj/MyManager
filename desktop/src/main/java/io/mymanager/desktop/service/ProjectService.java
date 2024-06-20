package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Project;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface ProjectService {

  List<Project> getAllProjects() throws Exception;

  List<Project> getAllProjects(int limit, int offset) throws Exception;

  List<Project> getAllProjectsByCustomer(String customer) throws Exception;

  List<Project> getAllProjectsByDescription(String projectDescription) throws Exception;

  Project getProjectByName(String projectName) throws Exception;

  int updateProject(Project oldProject, Project newProject) throws Exception;

  int saveProject(Project project) throws Exception;

  int deleteProject(Project project) throws Exception;
}
