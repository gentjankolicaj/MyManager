package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Atempt;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AtemptAccess {

	public abstract List<Atempt> readAllAtempts() throws Exception;

	public abstract List<Atempt> readAtempts(User user) throws Exception;

	public abstract List<Atempt> readAtempts(Status status) throws Exception;

	public abstract int insertAtempt(Atempt atempt) throws Exception;

	public abstract int deleteAtempt(Atempt atempt) throws Exception;

}
