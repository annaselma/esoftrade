package ma.esoftech.esoftrade.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import ma.esoftech.esoftrade.exeption.FileNotFoundException;
import ma.esoftech.esoftrade.service.IFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("file")
public class FileController {
	
	@Autowired
	ServletContext servletContext;
	@Autowired
	IFileService fileService;
	@RequestMapping(method = RequestMethod.GET)
	public void getFileById(HttpServletResponse response,@RequestParam long id){
	    try {
			fileService.getFileFromDisk(response, id);
		} catch (IOException | FileNotFoundException e) {
		}
		
	}

}
