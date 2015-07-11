package ma.esoftech.esoftrade.utils;

import java.net.MalformedURLException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class FileUploadUTILS {
	@Autowired
	ServletContext servletContext;
	
	
	public static final String DEFAULT_PICTURE_USER_NAME="avatar.png";
	public static final String DEFAULT_PICTURE_PRODUCT_NAME="product.png";
	private  static String PATH_FILE="/WEB-INF/FILES";
	private static String FULL_PATH;
	
	@PostConstruct
	public void initialize(){
		try {
			FULL_PATH=servletContext.getResource(PATH_FILE).getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  static void prepareTabProfil(ModelMap model,boolean file){
		if(file){
			System.out.println(file+"actiiive");
			model.addAttribute("defaultActive","");
			model.addAttribute("fileActive","active");
			model.addAttribute("defaultIn","");
			model.addAttribute("fileIn","in");
		}else{
			model.addAttribute("defaultActive","active");
			model.addAttribute("fileActive","");
			model.addAttribute("defaultIn","in");
			model.addAttribute("fileIn","");
		}
	}

	public static String getPathFile() {
		return FULL_PATH ;
	}

}
