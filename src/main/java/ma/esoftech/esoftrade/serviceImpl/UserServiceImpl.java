package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IUserDao;
import ma.esoftech.esoftrade.converter.UserConverter;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.service.IUserService;

import org.dozer.Mapper;
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
		UserConverter converter= new UserConverter();//
		UserDTO userFinal=mapper.map(user, UserDTO.class);
		userFinal.setRoles(converter.toRoleNameList(user.getRoles()));
		userFinal.setPermissions(converter.toPermissionList(user.getRoles()));
		return userFinal;
	}

	@Override
	@Transactional(readOnly=true)
	public UserDTO findById(long id) {
		User user= userDao.findById(id);
		UserConverter converter= new UserConverter();
		UserDTO userFinal= mapper.map(user, UserDTO.class);
		userFinal.setRoles(converter.toRoleNameList(user.getRoles()));
		userFinal.setPermissions(converter.toPermissionList(user.getRoles()));
		return userFinal;
	}

	@Override
	@Transactional(readOnly=true)
	public UserDTO findByRef(String ref) {
	User user= userDao.findByRef(ref);
	UserConverter converter= new UserConverter();
	UserDTO userFinal= mapper.map(user, UserDTO.class);
	userFinal.setRoles(converter.toRoleNameList(user.getRoles()));
	userFinal.setPermissions(converter.toPermissionList(user.getRoles()));
	return userFinal;
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserDTO> getAllUsers(int start, int length, String sorting,
			String filter) {
		List<User> userEntityList= userDao.getAllUsers(start, length, sorting, filter);
		List<UserDTO> userDTOList=new ArrayList<UserDTO>(); 
		for ( User user : userEntityList) {
					userDTOList.add((UserDTO) mapper.map(user,UserDTO.class));			
		}	
		return userDTOList;
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleDTO> getRolesByUser(UserDTO user) {
		User userEntity= mapper.map(user, User.class);
		List<RoleDTO>roleDTOList=new ArrayList<RoleDTO>();
	 List<Role>roleEntityList =userDao.getRolesByUser(userEntity);
	 for (Role role: roleEntityList) {
		 roleDTOList.add((RoleDTO)mapper.map(role, RoleDTO.class));
	}
		return roleDTOList;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void createUser(UserDTO user) {
		//convertir le UserDto vers User via mapper dozer
		User userEntity=(User) mapper.map(user, User.class);
		user.setCreator(null);
		userEntity.setCreateDate(new Date());
		userEntity.setLastEdit(new Date());
		Long idUser=userDao.createUser(userEntity);
		userEntity.setId(idUser);
		userEntity.generateReference();
		//userDao.updateUser(userEntity);

	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addRoleToUser(RoleDTO role, UserDTO userDTO) {
		//List<String>role= userDTO.getRoles().iterator();
		//pour récuperer et persister l'utilisateur ainsi récupérer tous 
		User usertmp=userDao.findById(userDTO.getId());
		// pour assurer que le role n'éxiste pas encore dans les role de user
		if(roleIsIncluded(usertmp.getRoles(),role.getId())){
			return;
		}
		//si il n'existe pas
		Role roleEntity=new Role();
		roleEntity.setId(role.getId());
		//ajouter le role a la liste des roles
		usertmp.getRoles().add(roleEntity);
		
		//faire la mise a jour a l'utilisateur 
		userDao.updateUser(usertmp);
	}

	private boolean roleIsIncluded(Set<Role> roles, long roleId) {
		for (Role roletmp : roles) {
			if (roletmp.getId() == roleId) {
				return true;
			}
		}
		return false;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteRoleFromUser(RoleDTO role, UserDTO userDTO) {
		User userId= userDao.findById(userDTO.getId());
		if (!roleIsIncluded(userId.getRoles(),role.getId())){
			return;
		}
	    Set<Role>roles=userId.getRoles();
	    Iterator<Role> it=roles.iterator();
	    while(it.hasNext()){
	    	Role roleEntity=it.next();
	    	if(roleEntity.getId()==role.getId()){
	    		roles.remove(roleEntity);
	    		break;
	    	}
	    }
		userDao.updateUser(userId);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateUser(UserDTO user) {
		User userObject= mapper.map(user, User.class);
	     User usertmp=userDao.findById(userObject.getId());
	     userObject.setRoles(usertmp.getRoles());
	     userObject.setCreator(usertmp.getCreator());
	     userObject.setCreateDate(usertmp.getCreateDate());
	     userObject.setLastEdit(new Date());
		userDao.updateUser(userObject);
	}
    
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteUser(UserDTO user) {
		// TODO Auto-generated method
		User userClass= (User) mapper.map(user, User.class);
		userDao.deleteUser(userClass);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public long userCount(String filter) {
		// TODO Auto-generated method stub
		return userDao.userCount(filter);
	}

	
}
