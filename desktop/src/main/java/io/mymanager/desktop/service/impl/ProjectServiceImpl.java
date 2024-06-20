package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.ProjectDao;
import io.mymanager.desktop.data.dao.impl.ProjectDaoImpl;
import io.mymanager.desktop.data.models.Project;
import io.mymanager.desktop.service.ProjectService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class ProjectServiceImpl implements ProjectService {

  private final ProjectDao projectDao;

  public ProjectServiceImpl() {
    super();
    this.projectDao = new ProjectDaoImpl();
  }

  @Override
  public List<Project> getAllProjects() throws Exception {
    return projectDao.findAllProjects();
  }

  @Override
  public List<Project> getAllProjects(int limit, int offset) throws Exception {
    return projectDao.findAllProjects(limit, offset);
  }

  @Override
  public List<Project> getAllProjectsByCustomer(String customer) throws Exception {
    return projectDao.findAllProjectsByCustomer(customer);
  }

  @Override
  public List<Project> getAllProjectsByDescription(String projectDescription) throws Exception {
    return projectDao.findAllProjectsByDescription(projectDescription);
  }

  @Override
  public Project getProjectByName(String projectName) throws Exception {
    return projectDao.findProjectByName(projectName);
  }

  @Override
  public int updateProject(Project oldProject, Project newProject) throws Exception {
    return projectDao.updateProject(oldProject, newProject);
  }

  @Override
  public int saveProject(Project project) throws Exception {
    return projectDao.saveProject(project);
  }

  @Override
  public int deleteProject(Project project) throws Exception {
    return projectDao.deleteProject(project);
  }

}
