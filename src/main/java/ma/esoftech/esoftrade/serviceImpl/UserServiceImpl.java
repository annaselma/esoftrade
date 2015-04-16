package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IUserDao;
import ma.esoftech.esoftrade.converter.UserConverter;
import ma.esoftech.esoftrade.exeption.UserNameException;
import ma.esoftech.esoftrade.exeption.UserNotFoundException;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.service.IUserService;
import ma.esoftech.esoftrade.service.ServiceUtils;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    
	@Autowired
    Mapper mapper;
    @Autowired
    IUserDao userDao;
    
    
	@Override
	@Transactional(readOnly=true)
	public UserDTO findByName(String login) {
		User user=  userDao.findByName(login);
		if(user==null){
			return null;
		}
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
		if(user==null){
			return null;
		}
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
	if(user==null){
		return null;
	}
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
	public void createUser(UserDTO creator,UserDTO user) throws UserNameException {
		//convertir le UserDto vers User via mapper dozer
		if(isUserNameExist(user.getLogin())){
			throw new  UserNameException("userName: "+user.getLogin()+" is already exist");
		}
		User userEntity=(User) mapper.map(user, User.class);
		ServiceUtils.buildEntityModel(creator, userEntity);
		String hashedPassword=ServiceUtils.getHashedPasswordBySHA(userEntity.getPasswd());
		userEntity.setRef(ServiceUtils.TMP_REF);
		userEntity.setPasswd(hashedPassword);
		Long idUser=userDao.createUser(userEntity);
		userEntity.setId(idUser);
		userEntity.generateReference();
		System.out.println("referenceccc: "+userEntity.getRef());
		userDao.updateUser(userEntity);

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
	public void updateUser(UserDTO modifer,UserDTO user) throws UserNameException, UserNotFoundException {
		User userEntity= mapper.map(user, User.class);
	     User usertmp=userDao.findById(userEntity.getId());
	     if(usertmp==null){
	    	 throw new UserNotFoundException();
	     }
	     if(!userEntity.getLogin().equals(usertmp.getLogin())){
	    	 if(isUserNameExist(userEntity.getLogin())){
	    		 throw new UserNameException("userName: "+user.getLogin()+" is already exist");
	    	 }
	     }
	     userEntity.setRef(usertmp.getRef());
	     userEntity.setRoles(usertmp.getRoles());
	     userEntity.setCreator(usertmp.getCreator());
	     userEntity.setCreateDate(usertmp.getCreateDate());
	     userEntity.setDeleted(false);
	     userEntity.setPasswd(usertmp.getPasswd());
	     userEntity.setLastEdit(new Date());
		userDao.updateUser(userEntity);
	}
	@Override
	public void editPassword(String newPassword, long id) throws UserNotFoundException {
		 User user=userDao.findById(id);
		 if(user==null){
			 throw new UserNotFoundException();
		 }
		 user.setPasswd(newPassword);
		 userDao.updateUser(user);
	}
    
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteUser(UserDTO user) {
		User userEntity= (User) mapper.map(user, User.class);
		userDao.deleteUser(userEntity);
	}
	

	@Override
	@Transactional(rollbackFor=Exception.class)
	public long userCount(String filter) {
		return userDao.userCount(filter);
	}
	
	private boolean isUserNameExist(String userName){
		User userFinder=userDao.findByName(userName);
		if(userFinder==null){
			return false;
		}
		return true;
	}

	
	
	
}
