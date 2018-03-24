package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Atempt;
import com.mymanager.data.models.Status;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AtemptAccess {

	public abstract List<Atempt> readAllAtempts();

	public abstract List<Atempt> readAtempts(String user);

	public abstract List<Atempt> readAtempts(Status status);

	public abstract int insertAtempt(Atempt atempt);

	public abstract int deleteAtempt(Atempt atempt);

}
