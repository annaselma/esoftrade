package ma.esoftech.esoftrade.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exeption.FileNotFoundException;
import ma.esoftech.esoftrade.model.File;

public interface IFileService {

	public FileDTO createFile(byte[] file,String nameFile,String path,UserDTO creator)throws IOException ;
	public FileDTO findFileById(long id);
	public HttpServletResponse getFileFromDisk(HttpServletResponse response,long id) throws IOException,FileNotFoundException ;
	public void deleteFile(FileDTO file) throws FileNotFoundException;
	public List<FileDTO> getFileList(int start, int length, String sorting,String className,long id);
	public long countFile(String className,long id);
	
}
