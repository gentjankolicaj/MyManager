package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.AdditionalAccessObject;
import com.mymanager.data.data_access.interfaces.AdditionalAccess;
import com.mymanager.data.models.Additional;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AdditionalServiceImpl implements AdditionalService {
	
	private AdditionalAccess additionalAccess;
	
	public AdditionalServiceImpl() {
		super();
		this.additionalAccess=new AdditionalAccessObject();
	}

	@Override
	public List<Additional> getAllAdditionals() throws Exception {
		return additionalAccess.findAllAdditionals();
	}

	@Override
	public List<Additional> getAllAdditionals(int limit, int offset) throws Exception {
		return additionalAccess.findAllAdditionals(limit, offset);	
	}

	@Override
	public Additional getAdditional(String employeeId) throws Exception {
		return additionalAccess.findAdditional(employeeId);
	}

	@Override
	public int updateAdditional(Additional oldAdditional, Additional newAdditional) throws Exception {
		return additionalAccess.updateAdditional(oldAdditional, newAdditional	);
	}

	@Override
	public int saveAdditional(Additional additional) throws Exception {
		return additionalAccess.saveAdditional(additional);
	}

	@Override
	public int deleteAdditional(Additional additional) throws Exception {
		return additionalAccess.deleteAdditional(additional);
	}

}
