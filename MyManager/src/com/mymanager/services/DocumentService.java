package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.Document;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface DocumentService {
	
	public abstract List<Document> getAllDocuments() throws Exception;

	public abstract List<Document> getAllDocuments(int limit, int offset) throws Exception;

	public abstract List<Document> getDocuments(String documentName) throws Exception;

	public abstract Document getDocument(int documentNumber) throws Exception;

	public abstract List<Document> getDocumentByEmployeeId(String employeeId) throws Exception;

	public abstract int updateDocument(Document oldDocument, Document newDocument) throws Exception;

	public abstract int saveDocument(Document document) throws Exception;

	public abstract int deleteDocument(Document document) throws Exception;

}
