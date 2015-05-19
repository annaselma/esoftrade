package ma.esoftech.esoftrade.controller.session;

import java.util.UUID;

import javax.annotation.PostConstruct;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS )
@Component
public class SessionBean {

	@Autowired
	private IUserService userService;
	
	private final String id = UUID.randomUUID().toString();
	
	private UserDTO userDTO;

	public IUserService getUserService() {
		return userService;
	}
	
    @PostConstruct
	public void initializeUserDTO() {
		this.userDTO=userService.findByName(getUserName());
		if(userDTO==null){
			userDTO=new UserDTO();
		}
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
