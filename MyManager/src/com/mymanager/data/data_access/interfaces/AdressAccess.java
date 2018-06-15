package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Adress;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdressAccess {

	public abstract List<Adress> readAllAdresses() throws Exception;

	public abstract List<Adress> readAdress(Adress adress) throws Exception;

	public abstract int updateAdress(Adress adress) throws Exception;

	public abstract int insertAdress(Adress adress) throws Exception;

	public abstract int deleteAdress(Adress adress) throws Exception;

}
