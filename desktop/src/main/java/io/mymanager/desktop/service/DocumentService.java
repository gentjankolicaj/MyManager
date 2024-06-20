package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.Document;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface DocumentService {

  List<Document> getAllDocuments() throws Exception;

  List<Document> getAllDocuments(int limit, int offset) throws Exception;

  List<Document> getDocuments(String documentName) throws Exception;

  Document getDocument(int documentNumber) throws Exception;

  List<Document> getDocumentByEmployeeId(String employeeId) throws Exception;

  int updateDocument(Document oldDocument, Document newDocument) throws Exception;

  int saveDocument(Document document) throws Exception;

  int deleteDocument(Document document) throws Exception;

}
