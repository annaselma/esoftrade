package ma.esoftech.esoftrade.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.Role;

public class UserConverter {
 public List<String> toRoleNameList(Set<Role> roles){

	 
	 List<String>result= new ArrayList<String>();
	 for (Role role : roles) {
		result.add(role.getRole());
	}
	 return result;
 }
 public List<String> toPermissionList(Set<Role> roles){
	 List<String>resultperm= new ArrayList<String>();
	 for (Role role : roles) {
		List<Permission> permissions= role.getPermissions();
		for (Permission permission : permissions) {
			resultperm.add(permission.getLabel());
		}
	}
	 return resultperm;
 }
}
