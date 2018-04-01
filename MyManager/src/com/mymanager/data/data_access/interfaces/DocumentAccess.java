package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.Document;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface DocumentAccess {

	public abstract List<Document> readAllDocuments();

	public abstract List<Document> readDocuments(String documentName);

	public abstract List<Document> readDocumentByDocumentNumber(Document document);

	public abstract List<Document> readDocumentByEmployeeId(Document document);

	public abstract int updateDocument(Document document);

	public abstract int insertDocument(Document document);

	public abstract int deleteDocument(Document document);

}
