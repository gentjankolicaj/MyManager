package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Document;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface DocumentAccess {

	public abstract List<Document> findAllDocuments() throws Exception;

	public abstract List<Document> findAllDocuments(int limit, int offset) throws Exception;

	public abstract List<Document> findDocuments(String documentName) throws Exception;

	public abstract Document findDocument(int documentNumber) throws Exception;

	public abstract List<Document> findDocumentByEmployeeId(String employeeId) throws Exception;

	public abstract int updateDocument(Document oldDocument, Document newDocument) throws Exception;

	public abstract int saveDocument(Document document) throws Exception;

	public abstract int deleteDocument(Document document) throws Exception;

}
