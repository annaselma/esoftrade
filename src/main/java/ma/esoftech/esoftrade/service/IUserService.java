package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;

public interface IUserService {

	public UserDTO findByName(String login);
	public UserDTO findById(long id);
	public UserDTO findByRef(String ref);
	public List<UserDTO> getAllUsers(int start, int length,String sorting, String filter);
    public List<RoleDTO> getRolesByUser(UserDTO user);
	public void createUser(UserDTO user);
	public void addRoleToUser(RoleDTO role, UserDTO userDTO);
	public void deleteRoleFromUser(RoleDTO role, UserDTO userDTO);
    public void updateUser(UserDTO user);
    public void deleteUser(UserDTO user);
    public long userCount( String filter);
	
}
