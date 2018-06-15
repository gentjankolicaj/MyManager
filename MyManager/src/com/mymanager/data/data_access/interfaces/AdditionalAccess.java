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

	public abstract List<Additional> readAdditional(Additional additional) throws Exception;

	public abstract int updateAdditional(Additional additional) throws Exception;

	public abstract int insertAdditional(Additional additional) throws Exception;

	public abstract int deleteAdditional(Additional additional) throws Exception;

}
