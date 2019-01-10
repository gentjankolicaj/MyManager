package com.mymanager.data.database;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface Connectable {
	
	void initDriver() throws Exception;

	void connect() throws Exception;

	void disconnect() throws Exception;

}
