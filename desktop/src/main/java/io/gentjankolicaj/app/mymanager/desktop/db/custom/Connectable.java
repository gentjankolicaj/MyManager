package io.gentjankolicaj.app.mymanager.desktop.db.custom;

/**
 * @author gentjan kolicaj
 */
public interface Connectable {
	
	void initDriver() throws Exception;

	void connect() throws Exception;

	void disconnect() throws Exception;

}
