package cn.edu.dao;

import java.util.List;

import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public interface IBookDao {
	
	/**
	 * 根据id查找书本
	 * @param id 书本id
	 * @return
	 */
	Book findById(String id);

	/**
	 * 查找所有书本
	 * @return
	 */
	List<Book> findAll();

	/**
	 * 根据用户id查找书本对象
	 * @param userId
	 * @return 书本对象
	 */
	List<Book> findBooks(String userId);
	
	/**
	 * 新增书本对象
	 * @param book
	 */
	void add(Book book);
	
	/**
	 * 删除书本对象
	 * @param book
	 */
	void delete(Book book);
	

}
