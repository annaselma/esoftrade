package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exeption.UserNameException;
import ma.esoftech.esoftrade.exeption.UserNotFoundException;

public interface IUserService {

	public UserDTO findByName(String login);
	public UserDTO findById(long id);
	public UserDTO findByRef(String ref);
	public List<UserDTO> getAllUsers(int start, int length,String sorting, String filter);
    public List<RoleDTO> getRolesByUser(UserDTO user);
	public void createUser(UserDTO creator,UserDTO user) throws UserNameException;
	public void addRoleToUser(RoleDTO role, UserDTO userDTO) ;
	public void deleteRoleFromUser(RoleDTO role, UserDTO userDTO);
    public void updateUser(UserDTO modifer,UserDTO user)throws UserNameException,UserNotFoundException;
    public void editPassword(String newPassword,long id) throws UserNotFoundException;
    public void deleteUser(UserDTO user);
    public long userCount( String filter);
	
}
