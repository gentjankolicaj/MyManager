package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Project;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface ProjectDao {

  List<Project> findAllProjects() throws Exception;

  List<Project> findAllProjects(int limit, int offset) throws Exception;

  List<Project> findAllProjectsByCustomer(String customer) throws Exception;

  List<Project> findAllProjectsByDescription(String projectDescription) throws Exception;

  Project findProjectByName(String projectName) throws Exception;

  int updateProject(Project oldProject, Project newProject) throws Exception;

  int saveProject(Project project) throws Exception;

  int deleteProject(Project project) throws Exception;

}
