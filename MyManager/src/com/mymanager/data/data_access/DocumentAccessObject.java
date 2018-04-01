package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.DocumentAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.database.QueryType;
import com.mymanager.data.models.Document;
import com.mymanager.data.models.FileType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DocumentAccessObject implements DocumentAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	private QueryType queryType;

	/**
	 * 
	 */
	public DocumentAccessObject() {
		super();
		this.queryType = QueryType.NORMAL;
	}

	/**
	 * @param queryType
	 */
	public DocumentAccessObject(QueryType queryType) {
		super();
		this.queryType = queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	@Override
	public List<Document> readAllDocuments() {

		List<Document> documentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM employee_documents";
		else
			query = "SELECT * FROM employee_documents_history";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Document temp = new Document(results.getInt("document_number"), results.getString("document_name"),
						results.getString("document_type"), results.getBlob("document_file"),
						new FileType(results.getString("file_type")), results.getString("employee_id"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				documentList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);

		return documentList;
	}

	@Override
	public List<Document> readDocuments(String documentName) {

		List<Document> documentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM employee_documents WHERE document_name LIKE '" + documentName + "%'";
		else
			query = "SELECT * FROM employee_documents_history WHERE document_name LIKE '" + documentName + "%'";

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Document temp = new Document(results.getInt("document_number"), results.getString("document_name"),
						results.getString("document_type"), results.getBlob("document_file"),
						new FileType(results.getString("file_type")), results.getString("employee_id"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				documentList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);

		return documentList;
	}

	@Override
	public List<Document> readDocumentByEmployeeId(Document document) {

		List<Document> documentList = new ArrayList<>();

		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM employee_documents WHERE employee_id=" + document.getEmployeeId();
		else
			query = "SELECT * FROM employee_documents_history WHERE employee_id=" + document.getEmployeeId();

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Document temp = new Document(results.getInt("document_number"), results.getString("document_name"),
						results.getString("document_type"), results.getBlob("document_file"),
						new FileType(results.getString("file_type")), results.getString("employee_id"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				documentList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);

		return documentList;
	}

	@Override
	public List<Document> readDocumentByDocumentNumber(Document document) {

		List<Document> documentList = new ArrayList<>();

		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM employee_documents WHERE document_number=" + document.getNumber();
		else
			query = "SELECT * FROM employee_documents_history WHERE document_number=" + document.getNumber();

		try {
			results = database.selectStatement(query);
			while (results.next()) {
				Document temp = new Document(results.getInt("document_number"), results.getString("document_name"),
						results.getString("document_type"), results.getBlob("document_file"),
						new FileType(results.getString("file_type")), results.getString("employee_id"),
						results.getString("created_by"), results.getString("updated_by"),
						results.getTimestamp("created_date").toLocalDateTime(),
						results.getTimestamp("updated_date").toLocalDateTime());

				documentList.add(temp);

			}

		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);

		return documentList;
	}

	@Override
	public int updateDocument(Document document) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDocument(Document document) {
		String query = "INSERT INTO employee_documents (document_name,document_type,document_file,file_type,document_number,employee_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, document.getName());
			pstmt.setString(2, document.getType());
			pstmt.setBlob(3, document.getFile());
			pstmt.setString(4, document.getFileType().getFile());
			pstmt.setInt(5, document.getNumber());
			pstmt.setString(6, document.getEmployeeId());
			pstmt.setString(7, document.getCreatedBy());
			pstmt.setObject(8, document.getCreatedDate());
			pstmt.setString(9, document.getUpdatedBy());
			pstmt.setObject(10, document.getUpdatedDate());

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
	public int deleteDocument(Document document) {
		String query = null;
		Object obj = null;
		if (document.getNumber() != 0) {

			query = "DELETE FROM employee_documents WHERE document_number=?";
			obj = document.getNumber();

		} else if (document.getName() != null) {

			query = "DELETE FROM employee_documents WHERE document_name=?";
			obj = document.getName();

		} else {

			query = "DELETE FROM employee_documents WHERE employee_id=?";
			obj = document.getEmployeeId();
		}

		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setObject(1, obj);
			pstmt.executeUpdate();

			i = 1;
		} catch (SQLException sql) {
			PrintUtils.print(sql, PrintType.DATABASE_QUERY);

		} catch (Exception e) {
			PrintUtils.print(e, PrintType.OTHER);

		}

		return i;
	}

	public int savePreviousRow(Document document) {
		String query = "INSERT INTO employee_documents_history (document_name,document_type,document_file,file_type,document_number,employee_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";
		int i = 0;
		try {
			PreparedStatement pstmt = database.updateStatement(query);
			pstmt.setString(1, document.getName());
			pstmt.setString(2, document.getType());
			pstmt.setBlob(3, document.getFile());
			pstmt.setString(4, document.getFileType().getFile());
			pstmt.setInt(5, document.getNumber());
			pstmt.setString(6, document.getEmployeeId());
			pstmt.setString(7, document.getCreatedBy());
			pstmt.setObject(8, document.getCreatedDate());
			pstmt.setString(9, document.getUpdatedBy());
			pstmt.setObject(10, document.getUpdatedDate());

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
