package cn.edu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.edu.dao.IBookDao;
import cn.edu.util.HibernateSessionFactory;
import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public class BookDaoImpl implements IBookDao {

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	@Override
	public List<Book> findBooks(String userId) {
		Session session = HibernateSessionFactory.getSession();
		User user = (User)session.get(User.class, userId);
		String hql = "from Book where user=:user";
		Query<Book> query = session.createQuery(hql, Book.class);
		query.setParameter("user", user);
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public void add(Book book) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.save(book);
		tran.commit();
	}




	@Override
	public Book findById(String id) {
		Session session = HibernateSessionFactory.getSession();
		return session.get(Book.class, id);
	}




	@Override
	public void delete(Book book) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.delete(book);
		tran.commit();
		
	}

}
