package com.mymanager.data.database;

/**
 * 
 * @author gentjan_kolicaj
 *
 */
public interface Connectable {

	void initDriver();

	void connect();

	void disconnect();

	void start();

	void stop();

}
