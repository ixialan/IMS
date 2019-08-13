package com.tecsoon.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.hibernate.HibernateSessionFactory;
import com.tecsoon.ims.util.Page;


public class UserDAOImpl  implements UserDAO{
	public User findByUserID(String uid) {
		Session session = HibernateSessionFactory.getSession();
		User user = (User) session.get(User.class, uid);
		HibernateSessionFactory.closeSession();
		return user;
	}

	public void updateUser(User user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	@SuppressWarnings("unchecked")
	public List<User> findByUserName(String name) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from User as user where user.name = ?");
		query.setString(0, name);
		@SuppressWarnings("rawtypes")
		List list = query.list();					
		HibernateSessionFactory.closeSession();		
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<User> findByUserClass(String sclass) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from User as user where user.sclass = ?");
		query.setString(0, sclass);
		@SuppressWarnings("rawtypes")
		List list = query.list();					
		HibernateSessionFactory.closeSession();		
		return list;
	}
	public void addUser(User user){
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.save(user);//保存试题信息
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
	@SuppressWarnings("rawtypes")
	public int findUserCount() {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from User");
		List list = query.list();					//查询结果保存到list中
		int count = list.size();
		HibernateSessionFactory.closeSession();//关闭Session对象
		return count;
	}
	@SuppressWarnings("unchecked")
	public List<User> findUserByPage(Page page) {
		Session session = HibernateSessionFactory.getSession();//获取session对象
		Query query = session.createQuery("from User");
		query.setMaxResults(page.getEveryPage());//设置查询记录数
		query.setFirstResult(page.getBeginIndex());//设置查询记录起始位置
		@SuppressWarnings("rawtypes")
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();//关闭session对象
		return list;

	}

	@Override
	public void deleteUser(String uid) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		User user = (User) session.get(User.class, uid);
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.delete(user);
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
}
