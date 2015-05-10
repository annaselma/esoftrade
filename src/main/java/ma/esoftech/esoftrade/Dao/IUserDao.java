package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.datatablesAPI.FilterCriterias;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;

public interface IUserDao {
	public User findByName(String login);
	public User findById(long id);
	public User findByRef(String ref);
	public List<User> getAllUsers(int start, int length,String sorting, String filter);
    public List<Role> getRolesByUser(User user);
	public Long createUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public long userCount( String filter);

}
