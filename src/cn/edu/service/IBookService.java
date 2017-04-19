package cn.edu.service;

import java.util.List;

import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public interface IBookService {

	List<Book> getBookList(String userId);
	
	/**
	 * 生成book对象
	 * @param user
	 * @param bookName
	 * @param keyword
	 * @param category
	 * @param description
	 * @param price
	 * @return
	 */
	Book generateBook(User user, String bookName, String keyword, String category, String description, Double price);
	
	/**
	 * 添加book对象
	 * @param user
	 * @param bookName
	 * @param keyword
	 * @param category
	 * @param description
	 * @param price
	 */
	void addBook(User user, String bookName, String keyword, String category, String description, Double price);
	
	void deleteBook(String bookId);
}
