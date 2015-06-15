package ma.esoftech.esoftrade.Dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.ProductCategory;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;


public interface IRoleDao {
	public Role findById(long id);
	public long createRole(Role role);
	public void updateRole(Role role);
	public void deleteRole(Role role);
	public long RoleCount(String filter);
	public List<Permission> getPermissions(int start, int lenght);
	public List<Role> getRoles(int start, int length, String sorting,
		String filter);
	public List<Role> searchRoles(int lenght, int start,
			String search);
	public List<Permission> searchPermissions(int lenght,int start,String search);
	public List<Role> searchRoleNotIN(int lenght,int start,User id, String search);
	
	
}
