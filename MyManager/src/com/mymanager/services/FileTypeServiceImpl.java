package com.mymanager.services;

import java.util.List;

import com.mymanager.data.data_access.FileTypeAccessObject;
import com.mymanager.data.data_access.interfaces.FileTypeAccess;
import com.mymanager.data.models.FileType;
/**
 * 
 * @author gentjan koliçaj
 *
 */
public class FileTypeServiceImpl implements FileTypeService {
	
	private FileTypeAccess fileTypeAccess;
	
	public FileTypeServiceImpl() {
		super();
		this.fileTypeAccess=new FileTypeAccessObject();
	}

	@Override
	public List<FileType> getAllFileTypes() throws Exception {
		return fileTypeAccess.findAllFileTypes();
	}

	@Override
	public FileType getFileType(String fileType) throws Exception {
		return fileTypeAccess.findFileType(fileType);
	}

	@Override
	public int saveFileType(FileType fileType) throws Exception {
		return fileTypeAccess.saveFileType(fileType);
	}

	@Override
	public int updateFileType(FileType oldFileType, FileType newFileType) throws Exception {
		return fileTypeAccess.updateFileType(oldFileType, newFileType);
	}

	@Override
	public int deleteFileType(FileType fileType) throws Exception {
		return fileTypeAccess.deleteFileType(fileType);
	}

}
