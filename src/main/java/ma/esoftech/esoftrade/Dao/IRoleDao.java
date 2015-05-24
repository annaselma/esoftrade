package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Role;


public interface IRoleDao {
	public Role findById(long id);
	public long createRole(Role role);
	public void updateRole(Role role);
	public void deleteRole(Role role);
	public long RoleCount(String filter);
	public List<Role> getRoles(int start, int length, String sorting,
		String filter);
	public List<Role> searchRoles(int lenght, int start,
			String search);
	
	
}
