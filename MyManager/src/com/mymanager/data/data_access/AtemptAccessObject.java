package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public List<Atempt> readAllAtempts() throws Exception {
		List<Atempt> atemptList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM mymanager.atempts";

		results = database.selectStatement(query);
		while (results.next()) {
			Atempt temp = new Atempt(results.getInt("index"), results.getString("user"), results.getString("password"),
					Status.valueOf(results.getString("status")), results.getString("description"),
					results.getTimestamp("date_time").toLocalDateTime());
			atemptList.add(temp);

		}

		PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);

		return atemptList;
	}

	@Override
	public List<Atempt> readAtempts(User user) throws Exception {
		List<Atempt> atemptList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM mymanager.atempts where user LIKE'%" + user.getUserId() + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			Atempt temp = new Atempt(results.getInt("index"), results.getString("user"), results.getString("password"),
					Status.valueOf(results.getString("status")), results.getString("description"),
					results.getTimestamp("date_time").toLocalDateTime());
			atemptList.add(temp);

		}
		PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);
		return atemptList;
	}

	@Override
	public List<Atempt> readAtempts(Status status) throws Exception {
		List<Atempt> atemptList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		query = "SELECT * FROM mymanager.atempts where status=" + status.name();

		results = database.selectStatement(query);
		while (results.next()) {
			Atempt temp = new Atempt(results.getInt("index"), results.getString("user"), results.getString("password"),
					Status.valueOf(results.getString("status")), results.getString("description"),
					results.getTimestamp("date_time").toLocalDateTime());
			atemptList.add(temp);
		}
		PrintUtils.print(atemptList, PrintType.QUERY_RESULTS);
		return atemptList;
	}

	@Override
	public int insertAtempt(Atempt atempt) throws Exception {
		String query = "INSERT INTO mymanager.atempts (user,password,status,description,date_time) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, atempt.getUser());
		pstmt.setString(2, atempt.getPassword());
		pstmt.setString(3, atempt.getStatus().name());
		pstmt.setString(4, atempt.getDescription());
		pstmt.setObject(5, atempt.getDateTime());

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteAtempt(Atempt atempt) throws Exception {
		String query = "DELETE FROM mymanager.atempts WHERE index=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, atempt.getIndex());

		return pstmt.executeUpdate();

	}

}
