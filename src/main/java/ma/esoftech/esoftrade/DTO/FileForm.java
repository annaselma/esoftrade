package ma.esoftech.esoftrade.DTO;

import org.springframework.web.multipart.MultipartFile;

public class FileForm {
	
	private MultipartFile file;
	private long id;
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
