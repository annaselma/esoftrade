package ma.esoftech.esoftrade.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exeption.FileNotFoundException;

public interface IFileService {

	public FileDTO createFile(byte[] file,String nameFile,String path,UserDTO creator)throws IOException ;
	public FileDTO findFileById(long id);
	public HttpServletResponse getFileFromDisk(HttpServletResponse response,long id) throws IOException,FileNotFoundException ;
	public void deleteFile(FileDTO file) throws FileNotFoundException;
	
}
