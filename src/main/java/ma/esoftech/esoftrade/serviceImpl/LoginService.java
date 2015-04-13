package ma.esoftech.esoftrade.serviceImpl;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.service.IUserService;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service("userDetailsService")
public class LoginService  implements UserDetailsService{
	@Autowired
	private IUserService userService;


	SessionFactory sessionFactory;

	 public LoginService() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		 System.out.println("naamgggge"+username);
		 UserDTO user=null;
		 if(sessionFactory==null){
			 System.out.println("session null");
			 
		 }else
			 
			 System.out.println("not null session");
		 if(userService==null)
			 System.out.println("is nnull");
		  user= userService.findByName(username);
	System.out.println("complet");
		System.out.println("password"+user.getLogin()+user.getPassword());
		if( user == null){
			System.out.println("nulll");
			throw new UsernameNotFoundException("user not found");
		}
		 return Assembler.buildUserSpringFromUserDTO(user);
		 
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
		 

}
