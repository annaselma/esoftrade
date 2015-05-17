package ma.esoftech.esoftrade.serviceImpl;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.dozer.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.exeption.FileNotFoundException;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.ServiceUtils;
@Service
public class FileServiceImpl implements IFileService {

	@Autowired
	IFileDao fileDao;
	@Autowired
	ServletContext servletContext;
	@Autowired
	Mapper mapper;
	@Transactional(rollbackFor=Exception.class)
	public FileDTO createFile(byte[] file, String nameFile, String path,
			UserDTO creator)throws IOException {
		File fileEntity= new File();
		ServiceUtils.buildEntityModel(creator, fileEntity);
		fileEntity.setDescription("File Description");
		fileEntity.setMask(700);
		fileEntity.setName(nameFile);
		fileEntity.setPath(path);
		fileEntity.setSize(file.length);
		fileEntity.setType("");
		long id=fileDao.createFile(fileEntity);
		fileEntity.setId(id);
		fileEntity.generatePath(path);
		fileDao.updateFile(fileEntity);
	
			saveFileInDisk(fileEntity, file);
			
		return mapper.map(fileEntity, FileDTO.class);
	
		
	}

	@Transactional(readOnly=true)
	public FileDTO findFileById(long id) {
		File fileEntity=fileDao.findFileById(id);
		return mapper.map(fileEntity,FileDTO.class);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void deleteFile(FileDTO file) throws FileNotFoundException {
		File fileEntity=fileDao.findFileById(file.getId());
		if(fileEntity==null)
			throw new FileNotFoundException("file how his id="+file.getId()+" doesn't exist");
		
	}
	private void saveFileInDisk(File file,byte[] data) throws IOException {
        BufferedOutputStream stream;
			stream = new BufferedOutputStream(new FileOutputStream(new java.io.File(file.getPath())));
		    stream.write(data);
	        stream.close();
	}

	@Override
	@Transactional(readOnly=true)
	public HttpServletResponse getFileFromDisk(HttpServletResponse response,
			long id) throws IOException,java.io.FileNotFoundException,FileNotFoundException {
		File fileEntity=fileDao.findFileById(id);
		if(fileEntity==null)
			throw new FileNotFoundException("file id:"+id+" not found");
		response.setContentLength((int) fileEntity.getSize());
        response.setHeader("Content-Disposition","attachment; filename=\"" + fileEntity.getName() +"\"");
        FileInputStream inputStream;
			inputStream = new FileInputStream(fileEntity.getPath());
				FileCopyUtils.copy(inputStream, response.getOutputStream());
	
		return response;
	}

}
