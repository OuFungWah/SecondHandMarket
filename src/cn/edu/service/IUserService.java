package cn.edu.service;

import java.util.List;

import cn.edu.exception.UserExistException;
import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public interface IUserService {
	
	/**
	 * 获取用户列表，以后可增加条件
	 * @return
	 */
	List<User> getUserList();

	/**
	 * 注册
	 * @param user
	 */
	void registerUser(User user) throws UserExistException;
	
	/**
	 * 登录
	 * @param 用户名
	 * @param 密码
	 * @return
	 */
	User loginUser(String userName, String userPwd);
	
	/**
	 * 删除用户
	 * @param userId 用户id
	 */
	void deleteUser(String userId);
	
	/**
	 * 添加用户书本
	 * @param user
	 * @param book
	 */
	void addBook(User user, Book book);
}
