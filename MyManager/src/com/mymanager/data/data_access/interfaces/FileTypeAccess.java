package com.mymanager.data.data_access.interfaces;

import java.util.List;

import com.mymanager.data.models.FileType;

public interface FileTypeAccess {

	public abstract List<FileType> findAllFileTypes() throws Exception;

	public abstract FileType findFileType(String fileType) throws Exception;

	public abstract int saveFileType(FileType fileType) throws Exception;

	public abstract int updateFileType(FileType oldFileType, FileType newFileType) throws Exception;

	public abstract int deleteFileType(FileType fileType) throws Exception;

}
