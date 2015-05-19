package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.File;

public interface IFileDao {
	
	public long createFile(File file);
	public void updateFile(File file);
	public void deleteFile(File file);
	public File findFileById(long id);
	public List<File> getFileList(int start, int length, String sorting,String className,long id);
	public long countFile(String className,long id);
	
}
