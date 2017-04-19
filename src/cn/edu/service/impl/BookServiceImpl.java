package cn.edu.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.edu.dao.IBookDao;
import cn.edu.dao.IUserDao;
import cn.edu.dao.impl.BookDaoImpl;
import cn.edu.dao.impl.UserDaoImpl;
import cn.edu.service.IBookService;
import cn.edu.util.WebUtils;
import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public class BookServiceImpl implements IBookService {
	
	private IBookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getBookList(String userId) {
		return bookDao.findBooks(userId);
	}

	@Override
	public void addBook(User user, String bookName, String keyword, String category, String description, 
			Double price) {
		BigDecimal priceBD = new BigDecimal(price);
		Book book = new Book();
		book.setId(WebUtils.makeId("B"));
		book.setBookName(bookName);
		book.setKeyword(keyword);
		book.setCategory(category);
		book.setDescription(description);
		book.setPrice(priceBD);
		book.setCreateTime(new Date());
		book.setUser(user);
		bookDao.add(book);
	}

	@Override
	public void deleteBook(String bookId) {
		Book book = bookDao.findById(bookId);
		bookDao.delete(book);
	}

	@Override
	public Book generateBook(User user, String bookName, String keyword, String category, String description,
			Double price) {
		BigDecimal priceBD = new BigDecimal(price);
		Book book = new Book();
		book.setId(WebUtils.makeId("B"));
		book.setBookName(bookName);
		book.setKeyword(keyword);
		book.setCategory(category);
		book.setDescription(description);
		book.setPrice(priceBD);
		book.setCreateTime(new Date());
		book.setUser(user);
		return book;
	}

}
