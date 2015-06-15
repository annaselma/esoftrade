package ma.esoftech.esoftrade.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.esoftech.esoftrade.DTO.PermissionDTO;
import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IRoleDao;
import ma.esoftech.esoftrade.exception.RoleNotFoundException;
import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.service.IRoleService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

@Service
public class RoleServiceImpl  implements IRoleService{

	@Autowired
	IRoleDao roleDao;
	@Autowired
	Mapper mapper;
	@Override
	@Transactional(readOnly=true)
	public RoleDTO findById(long id) throws RoleNotFoundException {
		Role role=roleDao.findById(id);
		if(role==null){
			throw new RoleNotFoundException(id);
		}
		return mapper.map(role, RoleDTO.class);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createRole(RoleDTO role,UserDTO creator) {
		Role roleEntity=mapper.map(role, Role.class);
		System.out.println("soooo"+roleEntity.getPermissions().size());
		ServiceUtils.buildEntityModel(creator, roleEntity);
		Set<Permission> permissions=roleEntity.getPermissions();
		roleEntity.setPermissions(new HashSet<Permission>());
		 long id=roleDao.createRole(roleEntity);
		 roleEntity.setPermissions(permissions);
		 roleEntity.setId(id);
		 roleDao.updateRole(roleEntity);
		 return id;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateRole(RoleDTO role,UserDTO editor) throws RoleNotFoundException {
		Role roleEntity=mapper.map(role, Role.class);
		Role roleTmp= roleDao.findById(role.getId());
		if(roleTmp==null){
			throw new RoleNotFoundException(role.getId());
		}
		ServiceUtils.EditEntityModel(editor, roleEntity);
		roleEntity.setDeleted(false);
		roleEntity.setCreator(roleTmp.getCreator());
		roleEntity.setCreateDate(roleTmp.getCreateDate());
		roleDao.updateRole(roleEntity);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteRole(RoleDTO role) throws RoleNotFoundException {
		Role roleEntity= roleDao.findById(role.getId());
		if(roleEntity==null){
			throw new RoleNotFoundException(role.getId());
		}
		roleDao.deleteRole(roleEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public long RoleCount(String filter) {
		
		return roleDao.RoleCount(filter);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PermissionDTO> getPermissions(int start, int lenght) {
		List<Permission> permissions=roleDao.getPermissions(start, lenght);
		return DozerHelper.map(mapper, permissions, PermissionDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleDTO> getRoles(int start, int length, String sorting,
			String filter) {
		List<Role> roles=roleDao.getRoles(start, length, sorting, filter);
		return DozerHelper.map(mapper, roles, RoleDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleDTO> searchRoles(int lenght, int start, String search) {
		List<Role> roles=roleDao.searchRoles(lenght, start, search);
		return DozerHelper.map(mapper, roles, RoleDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PermissionDTO> searchPermissions(int lenght, int start,
			String search) {
		List<Permission> permissions=roleDao.searchPermissions(lenght, start, search);
		return DozerHelper.map(mapper, permissions, PermissionDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<RoleDTO> searchRoleNotIN(int lenght, int start, UserDTO id,
			String search) {
		User u=new User();
		u.setId(id.getId());
		List<Role> roles=roleDao.searchRoleNotIN(lenght, start, u, search);
		return DozerHelper.map(mapper, roles, RoleDTO.class);
	}

}
