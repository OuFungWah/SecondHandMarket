package cn.edu.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import cn.edu.dao.IUserDao;
import cn.edu.util.HibernateSessionFactory;
import cn.edu.vo.hibernate.Book;
import cn.edu.vo.hibernate.User;

public class UserDaoImpl implements IUserDao {
	
	@Override
	public User find(String userName, String userPwd) {
		User user = null;
		Session session = HibernateSessionFactory.getSession();
		/* 带参数的查询*/
		String hql = "from User where userName=:userName and userPwd=:userPwd";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("userName", userName);
		query.setParameter("userPwd", userPwd);
		List<User> list = query.getResultList();
		if(list != null && list.size() > 0){
			user = list.get(0);
		}
		session.close();
		return user;
		
	}

	@Override
	public void add(User user) {
		Session session = HibernateSessionFactory.getSession();
		/* 定义事务开始*/
		Transaction tran = session.beginTransaction();
		session.save(user);
		/* 提交事务，真正保存到数据库中*/
		tran.commit();
		session.close();
	}

	@Override
	public User find(String userName) {
		User user = null;
		Session session = HibernateSessionFactory.getSession();
		/* 带参数的查询*/
		String hql = "from User where userName=:userName";
		Query<User> query = session.createQuery(hql, User.class);
		query.setParameter("userName", userName);
		List<User> list = query.getResultList();
		if(list != null && list.size() > 0){
			user = list.get(0);
		}
		session.close();
		return user;
	}

	@Override
	public List<User> findAll() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> list = query.getResultList();
		return list;
	}
	
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		for(User user : list){
			System.out.println(user.getId() + ": " + user.getUserName());
			Set books = user.getBooks();
			Iterator it = books.iterator();
	   	    while(it.hasNext()){
	   	        Book b = (Book)it.next();
	   	    	System.out.println(b.getBookName());
	   	    }

		}

	}

	@Override
	public User findById(String id) {
		Session session = HibernateSessionFactory.getSession();
		User user = (User)session.get(User.class, id);
		return user;
	}

	@Override
	public void delete(User user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.delete(user);
		tran.commit();
	}

	@Override
	public void save(User user) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(user);
		tran.commit();
		session.close();
	}

}
