package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Document;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface DocumentAccess {

	public abstract List<Document> readAllDocuments() throws Exception;

	public abstract List<Document> readDocuments(String documentName) throws Exception;

	public abstract List<Document> readDocumentByDocumentNumber(Document document) throws Exception;

	public abstract List<Document> readDocumentByEmployeeId(Document document) throws Exception;

	public abstract int updateDocument(Document document) throws Exception;

	public abstract int insertDocument(Document document) throws Exception;

	public abstract int deleteDocument(Document document) throws Exception;

}
