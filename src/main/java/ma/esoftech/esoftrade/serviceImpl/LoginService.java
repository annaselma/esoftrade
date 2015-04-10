package ma.esoftech.esoftrade.serviceImpl;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service("userDetailsService")
public class LoginService  implements UserDetailsService{
	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		 System.out.println("naamgggge"+username);
		 UserDTO user=null;
		 if(userService==null)
			 System.out.println("null");
		  user= userService.findByName(username);
	System.out.println("complet");
		System.out.println("password"+user.getLogin()+user.getPassword());
		if( user == null){
			System.out.println("nulll");
			throw new UsernameNotFoundException("user not found");
		}
		 return Assembler.buildUserSpringFromUserDTO(user);
		 
	}
		 

}
