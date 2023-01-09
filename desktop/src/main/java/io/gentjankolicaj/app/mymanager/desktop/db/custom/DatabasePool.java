package io.gentjankolicaj.app.mymanager.desktop.db.custom;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gentjan kolicaj
 */
public class DatabasePool {

	public static Map<Integer, Database> dbPool = new HashMap<>();

	public static Map<Integer, Database> getDbPool() {
		return dbPool;
	}

	public static Database getReference(Integer key) {
		return dbPool.get(key);
	}

	public static void putReference(Integer key, Database value) {
		dbPool.put(key, value);
	}

	public static void removeReference(Integer key, Database value) {
		dbPool.remove(key, value);
	}

	public static void clearMap() {
		dbPool.clear();
	}
}
