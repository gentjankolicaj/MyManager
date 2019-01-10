package com.mymanager.services;

import java.util.List;

import com.mymanager.data.models.FileType;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public interface FileTypeService {
	
	public abstract List<FileType> getAllFileTypes() throws Exception;

	public abstract FileType getFileType(String fileType) throws Exception;

	public abstract int saveFileType(FileType fileType) throws Exception;

	public abstract int updateFileType(FileType oldFileType, FileType newFileType) throws Exception;

	public abstract int deleteFileType(FileType fileType) throws Exception;

}
