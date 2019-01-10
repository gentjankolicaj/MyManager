package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Additional;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdditionalService {
	
	public abstract List<Additional> getAllAdditionals() throws Exception;

	public abstract List<Additional> getAllAdditionals(int limit, int offset) throws Exception;

	public abstract Additional getAdditional(String employeeId) throws Exception;

	public abstract int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception;

	public abstract int saveAdditional(Additional additional) throws Exception;

	public abstract int deleteAdditional(Additional additional) throws Exception;

}
