package com.mymanager.data.database;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface Connectable extends ConnectionDriver {

	void connect() throws Exception;

	void disconnect() throws Exception;

}
