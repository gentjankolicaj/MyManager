package com.mymanager.data.database;

/**
 * 
 * @author gentjan koli�aj
 *
 */
public interface Connectable {
	
	void initDriver() throws Exception;

	void connect() throws Exception;

	void disconnect() throws Exception;

}
