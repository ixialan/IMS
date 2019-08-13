package com.tecsoon.ims.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tecsoon.ims.entity.Cv;
import com.tecsoon.ims.hibernate.HibernateSessionFactory;

public class CvDAOImpl implements CvDAO{
	public void addCv(Cv cv){
		Session session = HibernateSessionFactory.getSession();//获得session对象
		Transaction  transaction = null;//声明一个事务
		try{
			transaction = session.beginTransaction();//事务开始
			session.save(cv);//保存事务
			transaction.commit();//事务提交
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
	public void deleteCv(int cvid) {
		Session session = HibernateSessionFactory.getSession();//获取Session对象
		Cv cv = (Cv) session.get(Cv.class, cvid);
		Transaction  transaction = null;//声明一个事务
		try{
			transaction = session.beginTransaction();//事务开始
			session.delete(cv);
			transaction.commit();//事务提交
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
}
