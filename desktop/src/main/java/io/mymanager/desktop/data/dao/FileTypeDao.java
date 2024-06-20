package io.mymanager.desktop.data.dao;

import io.mymanager.desktop.data.models.FileType;
import java.util.List;

public interface FileTypeDao {

  List<FileType> findAllFileTypes() throws Exception;

  FileType findFileType(String fileType) throws Exception;

  int saveFileType(FileType fileType) throws Exception;

  int updateFileType(FileType oldFileType, FileType newFileType) throws Exception;

  int deleteFileType(FileType fileType) throws Exception;

}
