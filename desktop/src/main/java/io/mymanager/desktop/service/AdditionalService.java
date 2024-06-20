package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Additional;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface AdditionalService {

  List<Additional> getAllAdditionals() throws Exception;

  List<Additional> getAllAdditionals(int limit, int offset) throws Exception;

  Additional getAdditional(String employeeId) throws Exception;

  int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception;

  int saveAdditional(Additional additional) throws Exception;

  int deleteAdditional(Additional additional) throws Exception;

}
