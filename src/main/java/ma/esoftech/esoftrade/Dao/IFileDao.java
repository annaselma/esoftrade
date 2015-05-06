package ma.esoftech.esoftrade.Dao;

import ma.esoftech.esoftrade.model.File;

public interface IFileDao {
	
	public long createFile(File file);
	public void updateFile(File file);
	public void deleteFile(File file);
	public File findFileById(long id);
	
}
