package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.FileType;

public interface FileTypeAccess {

	public abstract List<FileType> readAllFileTypes() throws Exception;

	public abstract int insertFileType(FileType fileType) throws Exception;

	public abstract int updateFileType(FileType newFileType, FileType oldFileType) throws Exception;

	public abstract int deleteFileType(FileType fileType) throws Exception;

}
