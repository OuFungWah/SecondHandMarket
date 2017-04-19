package cn.edu.dao;

import java.util.List;

import cn.edu.vo.hibernate.User;

public interface IUserDao {
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	User findById(String id);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	List<User> findAll();

	/**
	 * 根据用户名和密码查找用户对象
	 * @param userName
	 * @param userPwd
	 * @return 用户对象
	 */
	User find(String userName, String userPwd);
	
	/**
	 * 新增用户对象
	 * @param user
	 */
	void add(User user);
	
	/**
	 * 保存用户对象
	 * @param user
	 */
	void save(User user);
	
	/**
	 * 根据用户名查找用户对象
	 * @param userName
	 * @return 用户对象
	 */
	User find(String userName);
	
	/**
	 * 删除用户对象
	 * @param user
	 */
	void delete(User user);
}
