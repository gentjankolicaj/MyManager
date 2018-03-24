package com.mymanager.data.database;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface Connectable {

	void initDriver();

	void connect();

	void disconnect();

	void open();

	void close();

}
