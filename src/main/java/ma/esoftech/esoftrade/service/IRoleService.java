package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.PermissionDTO;
import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.RoleNotFoundException;
import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;

public interface IRoleService {
	public RoleDTO findById(long id) throws RoleNotFoundException;
	public long createRole(RoleDTO role,UserDTO creator);
	public void updateRole(RoleDTO role,UserDTO editor)throws RoleNotFoundException;
	public void deleteRole(RoleDTO role)throws RoleNotFoundException;
	public long RoleCount(String filter);
	public List<PermissionDTO> getPermissions(int start, int lenght);
	public List<RoleDTO> getRoles(int start, int length, String sorting,
		String filter);
	public List<RoleDTO> searchRoles(int lenght, int start,
			String search);
	public List<PermissionDTO> searchPermissions(int lenght, int start,
			String search);
	public List<RoleDTO> searchRoleNotIN(int lenght,int start,UserDTO id, String search);
}
