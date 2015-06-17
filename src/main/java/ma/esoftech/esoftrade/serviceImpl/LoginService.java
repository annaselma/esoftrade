package ma.esoftech.esoftrade.serviceImpl;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.service.IUserService;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class LoginService implements UserDetailsService {
	@Autowired
	private IUserService userService;

	static private Logger logger = Logger.getLogger(LoginService.class);

	public LoginService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDTO user = null;
		logger.info("entre");

		try {
			user = userService.findByName(username);
		} catch (Exception e) {
			System.out.println("afficher:" + e.getMessage());
			logger.info("no user found");
			throw new UsernameNotFoundException("user not found");
		}
		logger.info("username: " + user.getLogin() + "password: "
				+ user.getPassword());
		return Assembler.buildUserSpringFromUserDTO(user);

	}

	public IUserService getUserService() {

		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
