package com.tecsoon.ims.service;

import java.util.List;

import com.tecsoon.ims.dao.UserDAO;
import com.tecsoon.ims.dao.UserDAOImpl;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.util.Page;
import com.tecsoon.ims.util.PageResult;
import com.tecsoon.ims.util.PageUtil;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();

	public boolean allowLogin(String uid, String password) {

		List<User> userlist = userDAO.findByUserName(uid);
		if(userlist.size() != 0) {//判断是否存在该名字的学生
			for(int i =0; i<=0;) {
			if(password.equals(userlist.get(i).getPassword())
					&& uid.equals(userlist.get(i).getName())) {//判断密码是否相同
					return true;
				}else{
					return false;
				}	
			}
		}
		return false;
	}

	public List<User> getUserInfo(String uid) {
		return userDAO.findByUserName(uid);
	}

	public void setUserResult(String uid, int result) {
		User user = userDAO.findByUserID(uid);
		user.setResult(result);
		userDAO.updateUser(user);
	}

	public List<User> getUserByName(String name) {
		return userDAO.findByUserName(name);
	}

	public List<User> getUserByClass(String sclass) {
		return userDAO.findByUserClass(sclass);
	}

	@Override
	public boolean saveUser(User user) {
		userDAO.addUser(user);
		return true;
}

	public PageResult queryUserByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(),
				userDAO.findUserCount(),page.getCurrentPage());//根据总记录数创建分页信息
		List<User> list = userDAO.findUserByPage(page);//通过分页信息取得试题
		PageResult result = new PageResult(page,list);//封装分页信息和记录信息，返回给调用处
		return result;
	}
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(String uid) {
		userDAO.deleteUser(uid);
	}
}
