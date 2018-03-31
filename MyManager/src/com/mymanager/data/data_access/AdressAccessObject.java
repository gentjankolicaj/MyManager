package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.AdressAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Adress;
import com.mymanager.data.models.AdressType;
import com.mymanager.data.models.Country;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class AdressAccessObject implements AdressAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;
	private AdressType adressType;

	/**
	 * @param queryType
	 */
	public AdressAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	/**
	 * @param queryType
	 */
	public AdressAccessObject(QueryType queryType, AdressType adressType) {
		super();
		this.queryType = queryType;
		this.adressType = adressType;
	}

	/**
	 * @param queryType
	 */
	public AdressAccessObject(AdressType adressType) {
		super();
		this.adressType = adressType;
	}

	public AdressAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	public void setAdressType(AdressType adressType) {
		this.adressType = adressType;
	}

	@Override
	public List<Adress> readAllAdresses() {

		List<Adress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (adressType.equals(AdressType.EMPLOYEE_ADRESS)) {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM employee_adress";
			else
				query = "SELECT * FROM employee_adress_history";

			try {

				results = database.selectStatement(query);

				while (results.next()) {

					Adress temp = new Adress(results.getString("employee_id"),
							new Country(results.getString("country")), results.getString("city"),
							results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
							results.getString("created_by"), results.getString("updated_by"),
							results.getTimestamp("created_date").toLocalDateTime(),
							results.getTimestamp("updated_date").toLocalDateTime());

					adressList.add(temp);

				}

			} catch (SQLException sql) {
				PrintUtils.print(sql, PrintType.DATABASE_QUERY);

			} catch (Exception e) {
				PrintUtils.print(e, PrintType.OTHER);

			}
			PrintUtils.print(adressList, PrintType.QUERY_RESULTS);

			return adressList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM user_adress";
			else
				query = "SELECT * FROM user_adress_history";

			try {

				results = database.selectStatement(query);

				while (results.next()) {

					Adress temp = new Adress(results.getString("user_id"), new Country(results.getString("country")),
							results.getString("city"), results.getString("street_name"), results.getInt("zipcode"),
							results.getString("building"), results.getString("created_by"),
							results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
							results.getTimestamp("updated_date").toLocalDateTime());

					adressList.add(temp);

				}

			} catch (SQLException sql) {
				PrintUtils.print(sql, PrintType.DATABASE_QUERY);

			} catch (Exception e) {
				PrintUtils.print(e, PrintType.OTHER);

			}
			PrintUtils.print(adressList, PrintType.QUERY_RESULTS);

			return adressList;

		}

	}

	@Override
	public List<Adress> readAdress(Adress adress) {

		List<Adress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (adressType.equals(AdressType.EMPLOYEE_ADRESS)) {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM employee_adress WHERE employee_id=" + adress.getId();
			else
				query = "SELECT * FROM employee_adress_history WHERE employee_id=" + adress.getId();

			try {

				results = database.selectStatement(query);

				while (results.next()) {

					Adress temp = new Adress(results.getString("employee_id"),
							new Country(results.getString("country")), results.getString("city"),
							results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
							results.getString("created_by"), results.getString("updated_by"),
							results.getTimestamp("created_date").toLocalDateTime(),
							results.getTimestamp("updated_date").toLocalDateTime());

					adressList.add(temp);
				}

			} catch (SQLException sql) {
				PrintUtils.print(sql, PrintType.DATABASE_QUERY);

			} catch (Exception e) {
				PrintUtils.print(e, PrintType.OTHER);

			}
			PrintUtils.print(adressList, PrintType.QUERY_RESULTS);

			return adressList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM user_adress WHERE user_id=" + adress.getId();
			else
				query = "SELECT * FROM user_adress_history WHERE user_id=" + adress.getId();

			try {

				results = database.selectStatement(query);

				while (results.next()) {

					Adress temp = new Adress(results.getString("user_id"), new Country(results.getString("country")),
							results.getString("city"), results.getString("street_name"), results.getInt("zipcode"),
							results.getString("building"), results.getString("created_by"),
							results.getString("updated_by"), results.getTimestamp("created_date").toLocalDateTime(),
							results.getTimestamp("updated_date").toLocalDateTime());

					adressList.add(temp);

				}

			} catch (SQLException sql) {
				PrintUtils.print(sql, PrintType.DATABASE_QUERY);

			} catch (Exception e) {
				PrintUtils.print(e, PrintType.OTHER);

			}
			PrintUtils.print(adressList, PrintType.QUERY_RESULTS);

			return adressList;

		}

	}

	@Override
	public int updateAdress(Adress adress) {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "UPDATE employee_adress SET country=?,city=?,street_name=?,zipcode=?,building=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE employee_id=?";
		else
			query = "UPDATE user_adress SET country=?,city=?,street_name=?,zipcode=?,building=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE user_id=?";

		setQueryType(QueryType.NORMAL);
		List<Adress> temp = readAdress(adress);
		savePreviousRow(temp);

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);

			pstmt.setString(1, adress.getCountry().getCountryName());
			pstmt.setString(2, adress.getCity());
			pstmt.setString(3, adress.getStreetName());
			pstmt.setInt(4, adress.getZipCode());
			pstmt.setString(5, adress.getBuilding());
			pstmt.setString(6, adress.getCreatedBy());
			pstmt.setObject(7, adress.getCreatedDate());
			pstmt.setString(8, adress.getUpdatedBy());
			pstmt.setObject(9, adress.getUpdatedDate());
			pstmt.setString(10, adress.getId());

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
	public int insertAdress(Adress adress) {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "INSERT INTO employee_adress (employee_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO user_adress (user_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, adress.getId());
			pstmt.setString(2, adress.getCountry().getCountryName());
			pstmt.setString(3, adress.getCity());
			pstmt.setString(4, adress.getStreetName());
			pstmt.setInt(5, adress.getZipCode());
			pstmt.setString(6, adress.getBuilding());
			pstmt.setString(7, adress.getCreatedBy());
			pstmt.setObject(8, adress.getCreatedDate());
			pstmt.setString(9, adress.getUpdatedBy());
			pstmt.setObject(10, adress.getUpdatedDate());

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
	public int deleteAdress(Adress adress) {
		String query = null;

		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "DELETE FROM employee_adress WHERE employee_id=?" + adress.getId();
		else
			query = "DELETE FROM user_adress WHERE user_id=?" + adress.getId();
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, adress.getId());
			pstmt.executeUpdate();

			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	public int savePreviousRow(List<Adress> adressList) {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "INSERT INTO employee_adress_history (employee_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO user_adress_history (user_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

		Adress temp = adressList.get(0);
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, temp.getId());
			pstmt.setString(2, temp.getCountry().getCountryName());
			pstmt.setString(3, temp.getCity());
			pstmt.setString(4, temp.getStreetName());
			pstmt.setInt(5, temp.getZipCode());
			pstmt.setString(6, temp.getBuilding());
			pstmt.setString(7, temp.getCreatedBy());
			pstmt.setObject(8, temp.getCreatedDate());
			pstmt.setString(9, temp.getUpdatedBy());
			pstmt.setObject(10, temp.getUpdatedDate());

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
