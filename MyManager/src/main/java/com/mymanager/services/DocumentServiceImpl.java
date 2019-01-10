package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.DocumentAccessObject;
import com.mymanager.data.data_access.interfaces.DocumentAccess;
import com.mymanager.data.models.Document;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class DocumentServiceImpl implements DocumentService {

	private DocumentAccess documentAccess;
	
	public DocumentServiceImpl() {
		super();
		this.documentAccess=new DocumentAccessObject();
	}
	@Override
	public List<Document> getAllDocuments() throws Exception {
	return documentAccess.findAllDocuments();
	}

	@Override
	public List<Document> getAllDocuments(int limit, int offset) throws Exception {
		return documentAccess.findAllDocuments(limit,offset);
	}

	@Override
	public List<Document> getDocuments(String documentName) throws Exception {
		return documentAccess.findDocuments(documentName);
	}

	@Override
	public Document getDocument(int documentNumber) throws Exception {
		return documentAccess.findDocument(documentNumber);
	}

	@Override
	public List<Document> getDocumentByEmployeeId(String employeeId) throws Exception {
		return documentAccess.findDocumentByEmployeeId(employeeId);
	}

	@Override
	public int updateDocument(Document oldDocument, Document newDocument) throws Exception {
		return documentAccess.updateDocument(oldDocument, newDocument);
	}

	@Override
	public int saveDocument(Document document) throws Exception {
		return documentAccess.saveDocument(document);
	}

	@Override
	public int deleteDocument(Document document) throws Exception {
		return documentAccess.deleteDocument(document);
	}

}
