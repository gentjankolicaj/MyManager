package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.data.dao.ProjectDao;
import io.mymanager.desktop.data.models.Country;
import io.mymanager.desktop.data.models.Project;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.enums.PrintType;
import io.mymanager.desktop.util.PrintUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class ProjectDaoImpl implements ProjectDao {

  protected static Database database = DatabaseManager.getDb();

  public ProjectDaoImpl() {
    super();
  }

  @Override
  public List<Project> findAllProjects() throws Exception {
    List<Project> projectList = new ArrayList<>();
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.projects";

    results = database.selectStatement(query);
    while (results.next()) {
      Project temp = new Project(results.getString("project_name"),
          results.getString("description"),
          results.getString("customer"), new Country(results.getString("country")),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      projectList.add(temp);

    }
    PrintUtils.print(projectList, PrintType.QUERY_RESULTS);
    return projectList;
  }

  @Override
  public List<Project> findAllProjects(int limit, int offset) throws Exception {
    List<Project> projectList = new ArrayList<>();
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.projects LIMIT " + limit + " OFFSET " + offset;

    results = database.selectStatement(query);
    while (results.next()) {
      Project temp = new Project(results.getString("project_name"),
          results.getString("description"),
          results.getString("customer"), new Country(results.getString("country")),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      projectList.add(temp);

    }
    PrintUtils.print(projectList, PrintType.QUERY_RESULTS);
    return projectList;
  }

  @Override
  public List<Project> findAllProjectsByCustomer(String customer) throws Exception {
    List<Project> projectList = new ArrayList<>();
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.projects WHERE customer LIKE '" + customer + "%'";

    results = database.selectStatement(query);
    while (results.next()) {
      Project temp = new Project(results.getString("project_name"),
          results.getString("description"),
          results.getString("customer"), new Country(results.getString("country")),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      projectList.add(temp);
    }
    PrintUtils.print(projectList, PrintType.QUERY_RESULTS);
    return projectList;
  }

  @Override
  public List<Project> findAllProjectsByDescription(String projectDescription) throws Exception {
    List<Project> projectList = new ArrayList<>();
    ResultSet results = null;
    String query =
        "SELECT * FROM mymanager.projects WHERE description LIKE '" + projectDescription + "%'";

    results = database.selectStatement(query);
    while (results.next()) {
      Project temp = new Project(results.getString("project_name"),
          results.getString("description"),
          results.getString("customer"), new Country(results.getString("country")),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      projectList.add(temp);
    }
    PrintUtils.print(projectList, PrintType.QUERY_RESULTS);
    return projectList;
  }

  @Override
  public Project findProjectByName(String projectName) throws Exception {
    Project project = null;
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.projects WHERE project_name LIKE '" + projectName + "'";

    results = database.selectStatement(query);
    while (results.next()) {
      project = new Project(results.getString("project_name"), results.getString("description"),
          results.getString("customer"), new Country(results.getString("country")),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
    }
    PrintUtils.print(project, PrintType.QUERY_RESULTS);
    return project;
  }

  @Override
  public int updateProject(Project oldProject, Project newProject) throws Exception {
    String query = "UPDATE mymanager.projects SET project_name=?,description=?,customer=?,country=?,created_by,created_date=?,updated_by=?,updated_date=? WHERE project_name=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newProject.getProjectName());
    pstmt.setString(2, newProject.getDescription());
    pstmt.setString(3, newProject.getCustomer());
    pstmt.setString(4, newProject.getCountry().getCountryName());
    pstmt.setString(5, newProject.getCreatedBy());
    pstmt.setObject(6, newProject.getCreatedDate());
    pstmt.setString(7, newProject.getUpdatedBy());
    pstmt.setObject(8, newProject.getUpdatedDate());
    pstmt.setString(9, oldProject.getProjectName());

    return pstmt.executeUpdate();
  }

  @Override
  public int saveProject(Project project) throws Exception {
    String query = "INSERT INTO mymanager.projects (project_name,description,customer,country,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, project.getProjectName());
    pstmt.setString(2, project.getDescription());
    pstmt.setString(3, project.getCustomer());
    pstmt.setString(4, project.getCountry().getCountryName());
    pstmt.setString(5, project.getCreatedBy());
    pstmt.setObject(6, project.getCreatedDate());
    pstmt.setString(7, project.getUpdatedBy());
    pstmt.setObject(8, project.getUpdatedDate());

    return pstmt.executeUpdate();
  }

  @Override
  public int deleteProject(Project project) throws Exception {
    String query = "DELETE FROM mymanager.projects WHERE project_name=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, project.getProjectName());

    return pstmt.executeUpdate();
  }

}
