package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class FileType extends MyModel {

	private String file;

	/**
	 * 
	 */
	public FileType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param file
	 */
	public FileType(String file) {
		super();
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileType [file=" + file + "]";
	}

}
