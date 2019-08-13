package com.tecsoon.ims.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tecsoon.ims.entity.Admin;
import com.tecsoon.ims.hibernate.HibernateSessionFactory;

public class AdminDAOImpl extends HibernateDaoSupport implements AdminDAO{
	public Admin findByAdminID(String adminid) {
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Admin admin = (Admin) session.get(Admin.class, adminid);
		HibernateSessionFactory.closeSession();//关闭session对象
		return admin;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Admin> findByAdminName(String name) {
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Query query = session.createQuery("from Admin as admin where admin.name = ?");
		query.setString(0, name);
		List list = query.list();					
		HibernateSessionFactory.closeSession();		
		return list;
	}


}
