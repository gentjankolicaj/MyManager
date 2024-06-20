package io.mymanager.desktop.service;

import io.mymanager.desktop.data.models.FileType;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public interface FileTypeService {

  List<FileType> getAllFileTypes() throws Exception;

  FileType getFileType(String fileType) throws Exception;

  int saveFileType(FileType fileType) throws Exception;

  int updateFileType(FileType oldFileType, FileType newFileType) throws Exception;

  int deleteFileType(FileType fileType) throws Exception;

}
