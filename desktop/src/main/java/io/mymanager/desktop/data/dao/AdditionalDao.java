package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Additional;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface AdditionalDao {

  List<Additional> findAllAdditionals() throws Exception;

  List<Additional> findAllAdditionals(int limit, int offset) throws Exception;

  Additional findAdditional(String employeeId) throws Exception;

  int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception;

  int saveAdditional(Additional additional) throws Exception;

  int deleteAdditional(Additional additional) throws Exception;

}
