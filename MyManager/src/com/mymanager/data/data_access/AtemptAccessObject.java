package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.AtemptAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.models.Atempt;
import com.mymanager.data.models.Status;
import com.mymanager.data.models.User;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AtemptAccessObject implements AtemptAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	public AtemptAccessObject() {
		super();

	}

	@Override
	public List<Atempt> readAllAtempts() {

		List<Atempt> atemptList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM atempts";
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Atempt temp = new Atempt(results.getInt("index"), results.getString("user"),
						results.getString("password"), Status.valueOf(results.getString("status")),
						results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());

				atemptList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);

		return atemptList;
	}

	@Override
	public List<Atempt> readAtempts(User user) {

		List<Atempt> atemptList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM atempts where user=" + user.getUserId();
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Atempt temp = new Atempt(results.getInt("index"), results.getString("user"),
						results.getString("password"), Status.valueOf(results.getString("status")),
						results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());

				atemptList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);

		return atemptList;
	}

	@Override
	public List<Atempt> readAtempts(Status status) {

		List<Atempt> atemptList = new ArrayList<>();

		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM atempts where status=" + status.name();
		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Atempt temp = new Atempt(results.getInt("index"), results.getString("user"),
						results.getString("password"), Status.valueOf(results.getString("status")),
						results.getString("description"), results.getTimestamp("date_time").toLocalDateTime());

				atemptList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);

		return atemptList;
	}

	@Override
	public int insertAtempt(Atempt atempt) {

		String query = "INSERT INTO atempts (user,password,status,description,date_time) VALUES (?,?,?,?,?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, atempt.getUser());
			pstmt.setString(2, atempt.getPassword());
			pstmt.setString(3, atempt.getStatus().name());
			pstmt.setString(4, atempt.getDescription());
			pstmt.setObject(5, atempt.getDateTime());

			pstmt.executeUpdate();
			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	@Override
	public int deleteAtempt(Atempt atempt) {

		String query = "DELETE FROM atempts WHERE index=?";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setInt(1, atempt.getIndex());
			pstmt.executeUpdate();

			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

}
