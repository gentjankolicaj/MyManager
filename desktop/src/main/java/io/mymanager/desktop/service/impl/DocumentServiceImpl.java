package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.DocumentDao;
import io.mymanager.desktop.data.dao.impl.DocumentDaoImpl;
import io.mymanager.desktop.data.models.Document;
import io.mymanager.desktop.service.DocumentService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class DocumentServiceImpl implements DocumentService {

  private final DocumentDao documentDao;

  public DocumentServiceImpl() {
    super();
    this.documentDao = new DocumentDaoImpl();
  }

  @Override
  public List<Document> getAllDocuments() throws Exception {
    return documentDao.findAllDocuments();
  }

  @Override
  public List<Document> getAllDocuments(int limit, int offset) throws Exception {
    return documentDao.findAllDocuments(limit, offset);
  }

  @Override
  public List<Document> getDocuments(String documentName) throws Exception {
    return documentDao.findDocuments(documentName);
  }

  @Override
  public Document getDocument(int documentNumber) throws Exception {
    return documentDao.findDocument(documentNumber);
  }

  @Override
  public List<Document> getDocumentByEmployeeId(String employeeId) throws Exception {
    return documentDao.findDocumentByEmployeeId(employeeId);
  }

  @Override
  public int updateDocument(Document oldDocument, Document newDocument) throws Exception {
    return documentDao.updateDocument(oldDocument, newDocument);
  }

  @Override
  public int saveDocument(Document document) throws Exception {
    return documentDao.saveDocument(document);
  }

  @Override
  public int deleteDocument(Document document) throws Exception {
    return documentDao.deleteDocument(document);
  }

}
