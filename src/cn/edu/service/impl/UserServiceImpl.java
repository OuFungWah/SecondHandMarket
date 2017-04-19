package cn.edu.service.impl;

import java.util.List;
import java.util.Set;

import cn.edu.dao.IUserDao;
import cn.edu.dao.impl.UserDaoImpl;
import cn.edu.exception.UserExistException;
import cn.edu.service.IUserService;
import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public void registerUser(User user) throws UserExistException {
		if(userDao.find(user.getUserName()) != null){
			throw new UserExistException("用户名已存在");
		}
		userDao.add(user);
	}

	@Override
	public User loginUser(String userName, String userPwd) {
		return userDao.find(userName, userPwd);
	}

	@Override
	public List<User> getUserList() {
		return userDao.findAll();
	}

	@Override
	public void deleteUser(String userId) {
		User user = userDao.findById(userId);
		userDao.delete(user);
		
	}

	@Override
	public void addBook(User user, Book book) {
		user.getBooks().add(book);
		userDao.save(user);
	}

}
