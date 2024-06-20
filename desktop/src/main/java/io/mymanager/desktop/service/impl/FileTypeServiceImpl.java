package io.mymanager.desktop.service.impl;

import io.mymanager.desktop.data.dao.FileTypeDao;
import io.mymanager.desktop.data.dao.impl.FileTypeDaoImpl;
import io.mymanager.desktop.data.models.FileType;
import io.mymanager.desktop.service.FileTypeService;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class FileTypeServiceImpl implements FileTypeService {

  private final FileTypeDao fileTypeDao;

  public FileTypeServiceImpl() {
    super();
    this.fileTypeDao = new FileTypeDaoImpl();
  }

  @Override
  public List<FileType> getAllFileTypes() throws Exception {
    return fileTypeDao.findAllFileTypes();
  }

  @Override
  public FileType getFileType(String fileType) throws Exception {
    return fileTypeDao.findFileType(fileType);
  }

  @Override
  public int saveFileType(FileType fileType) throws Exception {
    return fileTypeDao.saveFileType(fileType);
  }

  @Override
  public int updateFileType(FileType oldFileType, FileType newFileType) throws Exception {
    return fileTypeDao.updateFileType(oldFileType, newFileType);
  }

  @Override
  public int deleteFileType(FileType fileType) throws Exception {
    return fileTypeDao.deleteFileType(fileType);
  }

}
