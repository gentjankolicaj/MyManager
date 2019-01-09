package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		this.adressType = AdressType.USER_ADRESS;
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
	public List<Adress> readAllAdresses() throws Exception {
}

	}



	@Override
	public int updateAdress(Adress oldAdress, Adress newAdress) throws Exception {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "UPDATE mymanager.employee_adress SET adress_id=?,employee_id=?,country=?,city=?,street_name=?,zipcode=?,building=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE adress_id=?";
		else
			query = "UPDATE mymanager.user_adress SET adress_id=?,user_id=?,country=?,city=?,street_name=?,zipcode=?,building=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE adress_id=?";
		setQueryType(QueryType.NORMAL);
		Adress temp = readAdress(oldAdress.getAdressId());
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
	public int insertAdress(Adress adress) throws Exception {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "INSERT INTO mymanager.employee_adress (employee_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO mymanager.user_adress (user_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

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
	public int deleteAdress(Adress adress) throws Exception {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "DELETE FROM mymanager.employee_adress WHERE adress_id=?";
		else
			query = "DELETE FROM mymanager.user_adress WHERE adress_id=?";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, adress.getAdressId());

		return pstmt.executeUpdate();

	}

	public int savePreviousRow(Adress adress) throws Exception {
		String query = null;
		if (adressType.equals(AdressType.EMPLOYEE_ADRESS))
			query = "INSERT INTO mymanager.employee_adress_history (adress_id,employee_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		else
			query = "INSERT INTO mymanager.user_adress_history (adress_id,user_id,country,city,street_name,zipcode,building,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

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
	public List<Adress> readAdressesByCity(String city) throws Exception {
	

	@Override
	public List<Adress> readAdressesByCountry(String country) throws Exception {
		List<Adress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (adressType.equals(AdressType.EMPLOYEE_ADRESS)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_adress WHERE country LIKE '" + country + "%'";

			else
				query = "SELECT * FROM mymanager.employee_adress_history WHERE country LIKE '" + country + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Adress temp = new Adress(results.getInt("adress_id"), results.getString("employee_id"),
						new Country(results.getString("country")), results.getString("city"),
						results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				adressList.add(temp);
			}
			PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
			return adressList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.user_adress WHERE country LIKE '" + country + "%'";

			else
				query = "SELECT * FROM mymanager.user_adress_history WHERE country LIKE '" + country + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Adress temp = new Adress(results.getInt("adress_id"), results.getString("user_id"),
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

	}

	@Override
	public List<Adress> readAdressesByStreet(String streetName) throws Exception {
		List<Adress> adressList = new ArrayList<>();
		ResultSet results = null;
		String query = null;

		if (adressType.equals(AdressType.EMPLOYEE_ADRESS)) {
			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.employee_adress WHERE street_name LIKE '" + streetName + "%'";

			else
				query = "SELECT * FROM mymanager.employee_adress_history WHERE street_name LIKE '" + streetName + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Adress temp = new Adress(results.getInt("adress_id"), results.getString("employee_id"),
						new Country(results.getString("country")), results.getString("city"),
						results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
				adressList.add(temp);
			}
			PrintUtils.print(adressList, PrintType.QUERY_RESULTS);
			return adressList;

		} else {

			if (queryType.equals(QueryType.NORMAL))
				query = "SELECT * FROM mymanager.user_adress WHERE street_name LIKE '" + streetName + "%'";

			else
				query = "SELECT * FROM mymanager.user_adress_history WHERE street_name LIKE '" + streetName + "%'";

			results = database.selectStatement(query);
			while (results.next()) {
				Adress temp = new Adress(results.getInt("adress_id"), results.getString("user_id"),
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

	}

	@Override
	public Adress readAdress(int adressId) throws Exception {
		Adress adress = null;
		ResultSet results = null;
		String query = null;

		if (adressType.equals(AdressType.EMPLOYEE_ADRESS)) {
			query = "SELECT * FROM mymanager.employee_adress WHERE adress_id=" + adressId;
			results = database.selectStatement(query);
			while (results.next()) {
				adress = new Adress(results.getInt("adress_id"), results.getString("employee_id"),
						new Country(results.getString("country")), results.getString("city"),
						results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
			}
			PrintUtils.print(adress, PrintType.QUERY_RESULTS);
			return adress;

		} else {

			query = "SELECT * FROM mymanager.user_adress WHERE adress_id=" + adressId;
			results = database.selectStatement(query);
			while (results.next()) {
				adress = new Adress(results.getInt("adress_id"), results.getString("user_id"),
						new Country(results.getString("country")), results.getString("city"),
						results.getString("street_name"), results.getInt("zipcode"), results.getString("building"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());
			}
			PrintUtils.print(adress, PrintType.QUERY_RESULTS);
			return adress;
		}

	}

}
