package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public List<Document> readAllDocuments() throws Exception {
		List<Document> documentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_documents";
		else
			query = "SELECT * FROM mymanager.employee_documents_history";

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
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);
		return documentList;
	}

	@Override
	public List<Document> readDocuments(String documentName) throws Exception {
		List<Document> documentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_documents WHERE document_name LIKE '" + documentName + "%'";
		else
			query = "SELECT * FROM mymanager.employee_documents_history WHERE document_name LIKE '" + documentName
					+ "%'";

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
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);
		return documentList;
	}

	@Override
	public List<Document> readDocumentByEmployeeId(String employeeId) throws Exception {
		List<Document> documentList = new ArrayList<>();
		ResultSet results = null;
		String query = null;
		if (queryType.equals(QueryType.NORMAL))
			query = "SELECT * FROM mymanager.employee_documents WHERE employee_id=" + employeeId;
		else
			query = "SELECT * FROM mymanager.employee_documents_history WHERE employee_id=" + employeeId;

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
		PrintUtils.print(documentList, PrintType.QUERY_RESULTS);
		return documentList;
	}

	@Override
	public Document readDocument(int documentNumber) throws Exception {
		Document document = null;
		ResultSet results = null;
		String query = "SELECT * FROM mymanager.employee_documents WHERE document_number=" + documentNumber;
		results = database.selectStatement(query);
		while (results.next()) {
			document = new Document(results.getInt("document_number"), results.getString("document_name"),
					results.getString("document_type"), results.getBlob("document_file"),
					new FileType(results.getString("file_type")), results.getString("employee_id"),
					results.getString("created_by"), results.getString("updated_by"),
					results.getTimestamp("created_date").toLocalDateTime(),
					results.getTimestamp("updated_date").toLocalDateTime());

		}
		PrintUtils.print(document, PrintType.QUERY_RESULTS);
		return document;
	}

	@Override
	public int updateDocument(Document oldDocument, Document newDocument) throws Exception {
		String query = "UPDATE mymanager.employee_documents SET document_number=?,document_name=?,document_type=?,document_file=?,file_type=?,employee_id=?,created_by=?,created_date=?,updated_by=?,updated_date=? WHERE document_number=?";
		setQueryType(QueryType.NORMAL);
		Document temp = readDocument(oldDocument.getNumber());
		savePreviousRow(temp);

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setInt(1, newDocument.getNumber());
		pstmt.setString(2, newDocument.getName());
		pstmt.setString(3, newDocument.getType());
		pstmt.setBlob(4, newDocument.getFile());
		pstmt.setString(5, newDocument.getFileType().getFile());
		pstmt.setString(6, newDocument.getEmployeeId());
		pstmt.setString(7, newDocument.getCreatedBy());
		pstmt.setObject(8, newDocument.getCreatedDate());
		pstmt.setString(9, newDocument.getUpdatedBy());
		pstmt.setObject(10, newDocument.getUpdatedDate());
		pstmt.setInt(11, oldDocument.getNumber());

		return pstmt.executeUpdate();

	}

	@Override
	public int insertDocument(Document document) throws Exception {
		String query = "INSERT INTO mymanager.employee_documents (document_name,document_type,document_file,file_type,document_number,employee_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

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

		return pstmt.executeUpdate();

	}

	@Override
	public int deleteDocument(Document document) throws Exception {
		String query = null;
		Object obj = null;
		if (document.getNumber() != 0) {
			query = "DELETE FROM mymanager.employee_documents WHERE document_number=?";
			obj = document.getNumber();

		} else if (document.getName() != null) {
			query = "DELETE FROM mymanager.employee_documents WHERE document_name=?";
			obj = document.getName();

		} else {
			query = "DELETE FROM mymanager.employee_documents WHERE employee_id=?";
			obj = document.getEmployeeId();
		}

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setObject(1, obj);

		return pstmt.executeUpdate();

	}

	public int savePreviousRow(Document document) throws Exception {
		String query = "INSERT INTO mymanager.employee_documents_history (document_name,document_type,document_file,file_type,document_number,employee_id,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

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

		return pstmt.executeUpdate();
	}

}
