package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.WorkingHourDao;
import io.mymanager.desktop.data.dao.impl.WorkingHourDaoImpl;
import io.mymanager.desktop.data.models.WorkingHour;
import io.mymanager.desktop.service.WorkingHourService;
import java.time.LocalDate;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class WorkingHourServiceImpl implements WorkingHourService {

  private final WorkingHourDao workingHourDao;

  public WorkingHourServiceImpl() {
    super();
    this.workingHourDao = new WorkingHourDaoImpl();
  }


  @Override
  public List<WorkingHour> getAllWorkingHour() throws Exception {
    return workingHourDao.findAllWorkingHour();
  }

  @Override
  public List<WorkingHour> getAllWorkingHour(int limit, int offset) throws Exception {
    return workingHourDao.findAllWorkingHour(limit, offset);
  }

  @Override
  public List<WorkingHour> getWorkingHourByEmplyeeId(String employeeId) throws Exception {
    return workingHourDao.findWorkingHourByEmplyeeId(employeeId);
  }

  @Override
  public List<WorkingHour> getWorkingHourByDate(LocalDate date) throws Exception {
    return workingHourDao.findWorkingHourByDate(date);
  }

  @Override
  public List<WorkingHour> getWorkingHourByBetween(float minHours, float maxHours)
      throws Exception {
    return workingHourDao.findWorkingHourByBetween(minHours, maxHours);
  }

  @Override
  public WorkingHour getWorkingHourByIndex(int index) throws Exception {
    return workingHourDao.findWorkingHourByIndex(index);
  }

  @Override
  public int updateWorkingHour(WorkingHour oldWorkingHour, WorkingHour newWorkingHour)
      throws Exception {
    return workingHourDao.updateWorkingHour(oldWorkingHour, newWorkingHour);
  }

  @Override
  public int saveWorkingHour(WorkingHour workingHour) throws Exception {
    return workingHourDao.saveWorkingHour(workingHour);
  }

  @Override
  public int deleteWorkingHour(WorkingHour workingHour) throws Exception {
    return workingHourDao.deleteWorkingHour(workingHour);
  }

}
