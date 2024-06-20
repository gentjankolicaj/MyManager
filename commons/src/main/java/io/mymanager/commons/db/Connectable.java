package io.mymanager.commons.db;

/**
 * @author gentjan kolicaj
 */
public interface Connectable {

  void initDriver() throws Exception;

  void connect() throws Exception;

  void disconnect() throws Exception;

  boolean isConnected();

}
