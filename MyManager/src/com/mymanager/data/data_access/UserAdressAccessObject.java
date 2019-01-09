package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.UserAdressAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.Country;
import com.mymanager.data.models.UserAdress;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class UserAdressAccessObject implements UserAdressAccess {
	
	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;
	
	/**
	 * @param queryType
	 */
	public UserAdressAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}



	public UserAdressAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}



	@Override
	public List<UserAdress> readAllAdresses() throws Exception {
		List<UserAdress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.user_adress";
		else
			query = "SELECT * FROM mymanager.user_adress_history";

		results = database.selectStatement(query);
		while (results.next()) {
			UserAdress temp = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			adressList.add(temp);
		}
		PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
		return adressList;
	}

	@Override
	public List<UserAdress> readAllAdresses(int limit, int offset) throws Exception {
		List<UserAdress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.user_adress LIMIT " + limit + " OFFSET " + offset;
		else
			query = "SELECT * FROM mymanager.user_adress_history LIMIT " + limit + " OFFSET " + offset;

		results = database.selectStatement(query);
		while (results.next()) {
			UserAdress temp = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			adressList.add(temp);
		}
		PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
		return adressList;
	}

	@Override
	public UserAdress readAdressesByPersonId(String personId) throws Exception {
		UserAdress adress = null;
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.user_adress WHERE user_id LIKE '" + personId + "'";
		else
			query = "SELECT * FROM mymanager.user_adress_history WHERE user_id LIKE '" + personId + "'";

		results = database.selectStatement(query);
		while (results.next()) {
			adress = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtils.print(adress, PrintType.QUERY_RESULTS);
		return adress;
	

	}

	@Override
	public List<UserAdress> readAdressesByCity(String city) throws Exception {
		List<UserAdress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.user_adress WHERE city LIKE '" + city + "%'";

		else
			query = "SELECT * FROM mymanager.user_adress_history WHERE city LIKE '" + city + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			UserAdress temp = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			adressList.add(temp);
		}
		PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
		return adressList;
	}

	@Override
	public List<UserAdress> readAdressesByCountry(String country) throws Exception {
		List<UserAdress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.user_adress WHERE country LIKE '" + country + "%'";

		else
			query = "SELECT * FROM mymanager.user_adress_history WHERE country LIKE '" + country + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			UserAdress temp = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			adressList.add(temp);
		}
		PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
		return adressList;
		
	}

	@Override
	public List<UserAdress> readAdressesByStreet(String streetName) throws Exception {
		List<UserAdress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.user_adress WHERE street_name LIKE '" + streetName + "%'";

		else
			query = "SELECT * FROM mymanager.user_adress_history WHERE street_name LIKE '" + streetName + "%'";

		results = database.selectStatement(query);
		while (results.next()) {
			UserAdress temp = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
			adressList.add(temp);
		}
		PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
		return adressList;
		
	}

	@Override
	public UserAdress readAdress(int adressId) throws Exception {
		UserAdress adress = null;
		ResultSet results = null;
		String query = "SELECT * FROM mymanager.user_adress WHERE adress_id=" + adressId;
		results = database.selectStatement(query);
		while (results.next()) {
			adress = new UserAdress(results.getInt("adress_id"), results.getString("user_id"),
					new Country(results.getString("country")), results.getString("city"),
					results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());
		}
		PrintUtils.print(adress, PrintType.QUERY_RESULTS);
		return adress;
	}

	@Override
	public int updateAdress(UserAdress oldAdress, UserAdress newAdress) throws Exception {
		String 		query = "UPDATE mymanager.user_adress SET adress_id=?,user_id=?,country=?,city=?,street_name=?,zipcode=?,building=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE adress_id=?";
		
		setQueryType(QueryType.NORMAL);
		
		UserAdress temp = readAdress(oldAdress.getAdressId());
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, newAdress.getAdressId());
		pstmt.setString(2, newAdress.getPersonId());
		pstmt.setString(3, newAdress.getCountry().getCountryName());
		pstmt.setString(4, newAdress.getCity());
		pstmt.setString(5, newAdress.getStreetName());
		pstmt.setInt(6, newAdress.getZipCode());
		pstmt.setString(7, newAdress.getBuilding());
		pstmt.setString(8, newAdress.getCreatedBy());
		pstmt.setObject(9, newAdress.getCreatedDate());
		pstmt.setString(10, newAdress.getUpdatedBy());
		pstmt.setObject(11, newAdress.getUpdatedDate());
		pstmt.setInt(12, oldAdress.getAdressId());

		return pstmt.executeUpdate();
	}

	@Override
	public int insertAdress(UserAdress adress) throws Exception {
		String query = "INSERT INTO mymanager.user_adress (user_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, adress.getPersonId());
		pstmt.setString(2, adress.getCountry().getCountryName());
		pstmt.setString(3, adress.getCity());
		pstmt.setString(4, adress.getStreetName());
		pstmt.setInt(5, adress.getZipCode());
		pstmt.setString(6, adress.getBuilding());
		pstmt.setString(7, adress.getCreatedBy());
		pstmt.setObject(8, adress.getCreatedDate());
		pstmt.setString(9, adress.getUpdatedBy());
		pstmt.setObject(10, adress.getUpdatedDate());

		return pstmt.executeUpdate();
	}

	@Override
	public int deleteAdress(UserAdress adress) throws Exception {
		String 	query = "DELETE FROM mymanager.user_adress WHERE adress_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, adress.getAdressId());

		return pstmt.executeUpdate();
	}
	
	public int savePreviousRow(UserAdress adress) throws Exception {
	   String	query = "INSERT INTO mymanager.user_adress_history (adress_id,user_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, adress.getAdressId());
		pstmt.setString(2, adress.getPersonId());
		pstmt.setString(3, adress.getCountry().getCountryName());
		pstmt.setString(4, adress.getCity());
		pstmt.setString(5, adress.getStreetName());
		pstmt.setInt(6, adress.getZipCode());
		pstmt.setString(7, adress.getBuilding());
		pstmt.setString(8, adress.getCreatedBy());
		pstmt.setObject(9, adress.getCreatedDate());
		pstmt.setString(10, adress.getUpdatedBy());
		pstmt.setObject(11, adress.getUpdatedDate());

		return pstmt.executeUpdate();

	}

	@Override
	public void setQueryType(QueryType queryType) {
		this.queryType=queryType;

	}

	

}
