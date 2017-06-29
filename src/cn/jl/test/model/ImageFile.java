package cn.jl.test.model;

import java.io.File;

public class ImageFile
{
	private File file;
	private String contentType;
	private String filename;

	public void setUpload(File file)
	{
		this.file = file;
	}

	public void setUploadContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename)
	{
		this.filename = filename;
	}

	public File getFile()
	{
		return file;
	}

	public String getContentType()
	{
		return contentType;
	}

	public String getFilename()
	{
		return filename;
	}
}
