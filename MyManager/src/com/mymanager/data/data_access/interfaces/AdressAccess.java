package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Adress;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface AdressAccess {

	public abstract List<Adress> readAllAdresses();

	public abstract Adress readAdress(String employeeId);

	public abstract int updateAdress(Adress adress);

	public abstract int insertAdress(Adress adress);

	public abstract int deleteAdress(Adress adress);

}
