package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.DTO.UserDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;

public class Assembler {

	
	
	public static User buildUserSpringFromUserDTO(UserDTO userDto){
		String username = userDto.getLogin();
	    String password = userDto.getPassword();
	    boolean enabled = userDto.isActive();
	    boolean accountNonExpired = userDto.isActive();
	    boolean credentialsNonExpired = userDto.isActive();
	    boolean accountNonLocked = userDto.isActive();
		  List<String> roles= userDto.getRoles();
		  Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		  attachRolesToAuthorities(roles, authorities);
		  List<String> permissions=userDto.getPermissions();
		  attachPerTomissionsAuthorities(permissions, authorities);  
		     User finalUser=  new User(username, password, enabled,
		    	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		     return finalUser;
	}
		
	private static void attachRolesToAuthorities(List<String> roles,
			Collection<GrantedAuthority> authorities){
		  for (String role : roles) {
			  authorities.add(new  GrantedAuthorityImpl(role));
		}
	}
	
   private static void attachPerTomissionsAuthorities(List<String> permissions,
		Collection<GrantedAuthority> authorities){
	   for (String perm : permissions) {
			  authorities.add(new  GrantedAuthorityImpl(perm));
		}
}
	
	
}
