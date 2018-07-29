package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Additional;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdditionalAccess {

	public abstract List<Additional> readAllAdditionals() throws Exception;

	public abstract List<Additional> readAllAdditionals(int limit, int offset) throws Exception;

	public abstract Additional readAdditional(String employeeId) throws Exception;

	public abstract int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception;

	public abstract int insertAdditional(Additional additional) throws Exception;

	public abstract int deleteAdditional(Additional additional) throws Exception;

}
