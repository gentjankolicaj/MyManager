package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.models.FileType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

public class FileTypeAccessObject implements FileTypeAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

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
