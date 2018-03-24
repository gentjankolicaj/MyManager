package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Additional;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdditionalAccess {

	public abstract List<Additional> readAllAdditionals();

	public abstract Additional readAdditional(String employeeId);

	public abstract int updateAdditional(Additional additional);

	public abstract int insertAdditional(Additional additional);

	public abstract int deleteAdditional(Additional additional);

}
