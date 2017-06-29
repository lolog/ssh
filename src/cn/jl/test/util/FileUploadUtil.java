package cn.jl.test.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.jl.test.model.ImageFile;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload
{
	
	private String filePath = "D:/";
	
	@Value("#{prop.filePath}")
	public void setFilePath(String filePath) {
		System.out.println("\n++++++++++"+filePath+"\n");
		this.filePath = filePath;
	}

	// 通过文件名获得文件扩展名
	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	// 生成UUID,作为新的文件名
	private String getFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID().toString()+"."+ext;
	}
	
	@Override
	public String uploadFile(ImageFile imageFile){
		// 获取新的文件名
		String newFileName = getFileName(imageFile.getFilename());
		try {
			FileUtil.copyFile(imageFile.getFile(),new File(filePath,newFileName));
			return newFileName;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			imageFile.getFile().delete();
		}
	}
}
