package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.data.dao.FileTypeDao;
import io.mymanager.desktop.data.models.FileType;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.enums.PrintType;
import io.mymanager.desktop.util.PrintUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FileTypeDaoImpl implements FileTypeDao {

  protected static Database database = DatabaseManager.getDb();

  @Override
  public List<FileType> findAllFileTypes() throws Exception {
    List<FileType> fileTypeList = new ArrayList<>();
    ResultSet results = null;
    String query = "Select * FROM mymanager.file_types";

    results = database.selectStatement(query);
    while (results.next()) {
      FileType temp = new FileType(results.getString("file_type"));
      fileTypeList.add(temp);
    }
    PrintUtils.print(fileTypeList, PrintType.QUERY_RESULTS);
    return fileTypeList;

  }

  @Override
  public FileType findFileType(String fileType) throws Exception {
    FileType fileTypeObj = null;
    ResultSet results = null;
    String query = "Select * FROM mymanager.file_types WHERE file_type=" + fileType;

    results = database.selectStatement(query);
    while (results.next()) {
      fileTypeObj = new FileType(results.getString("file_type"));
    }
    PrintUtils.print(fileTypeObj, PrintType.QUERY_RESULTS);
    return fileTypeObj;

  }

  @Override
  public int saveFileType(FileType fileType) throws Exception {
    String query = "INSERT INTO mymanager.file_types (file_type) VALUES (?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, fileType.getFile());

    return pstmt.executeUpdate();
  }

  @Override
  public int updateFileType(FileType oldFileType, FileType newFileType) throws Exception {
    String query = "UPDATE mymanager.file_types SET file_type=? WHERE file_type=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newFileType.getFile());
    pstmt.setString(2, oldFileType.getFile());

    return pstmt.executeUpdate();
  }

  @Override
  public int deleteFileType(FileType fileType) throws Exception {
    String query = "DELETE FROM mymanager.file_types WHERE file_type=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, fileType.getFile());

    return pstmt.executeUpdate();
  }

}
