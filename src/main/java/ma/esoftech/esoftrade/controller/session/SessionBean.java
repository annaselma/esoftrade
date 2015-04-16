package ma.esoftech.esoftrade.controller.session;

import java.util.UUID;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionBean {

	@Autowired
	private IUserService userService;
	
	private final String id = UUID.randomUUID().toString();
	
	private UserDTO userDTO;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getId() {
		return id;
	}

	public UserDTO getUserDTO() {
		if(userDTO==null){
			userDTO=userService.findByName(getUserName());
			if(userDTO==null){
				userDTO=new UserDTO();
			}
		}
		return userDTO;
	}


	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	private String getUserName(){
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String nameUser = auth.getName(); 
	      return nameUser;
	}

	
}
