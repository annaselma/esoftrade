package ma.esoftech.esoftrade.serviceImpl;

import java.util.List;

import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IUserDao;
import ma.esoftech.esoftrade.converter.UserConverter;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.service.IUserService;

import org.dozer.Mapper;
import org.dozer.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
class UserServiceImpl implements IUserService {
    @Autowired
    Mapper mapper;
    @Autowired
    IUserDao userDao;
    
    
	@Override
	@Transactional(readOnly=true)
	public UserDTO findByName(String login) {
		User user=  userDao.findByName(login);
		UserConverter converter= new UserConverter();
		UserDTO userFinal=mapper.map(user, UserDTO.class);
		userFinal.setRoles(converter.toRoleNameList(user.getRoles()));
		userFinal.setPermissions(converter.toPermissionList(user.getRoles()));
		return userFinal;
	}

	@Override
	public UserDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findByRef(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers(int start, int length, String sorting,
			String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDTO> getRolesByUser(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(UserDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRoleToUser(RoleDTO role, UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoleFromUser(RoleDTO role, UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(UserDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long userCount(String filter) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
