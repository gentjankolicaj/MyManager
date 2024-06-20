package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.Document;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface DocumentDao {

  List<Document> findAllDocuments() throws Exception;

  List<Document> findAllDocuments(int limit, int offset) throws Exception;

  List<Document> findDocuments(String documentName) throws Exception;

  Document findDocument(int documentNumber) throws Exception;

  List<Document> findDocumentByEmployeeId(String employeeId) throws Exception;

  int updateDocument(Document oldDocument, Document newDocument) throws Exception;

  int saveDocument(Document document) throws Exception;

  int deleteDocument(Document document) throws Exception;

}
