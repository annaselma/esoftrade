package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.associated.RoleAssociated;

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
		  List<RoleAssociated> roles= userDto.getRoles();
		  Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		  attachRolesToAuthorities(roles, authorities);
		  List<String> permissions=userDto.getPermissions();
		  attachPerTomissionsAuthorities(permissions, authorities);  
		     User finalUser=  new User(username, password, enabled,
		    	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		     return finalUser;
	}
		
	private static void attachRolesToAuthorities(List<RoleAssociated> roles,
			Collection<GrantedAuthority> authorities){
		  for (RoleAssociated role : roles) {
			  authorities.add(new  GrantedAuthorityImpl(role.getRole()));
		}
	}
	
   private static void attachPerTomissionsAuthorities(List<String> permissions,
		Collection<GrantedAuthority> authorities){
	   for (String perm : permissions) {
			  authorities.add(new  GrantedAuthorityImpl(perm));
		}
}
	
	
}
