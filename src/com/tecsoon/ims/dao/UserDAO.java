package com.tecsoon.ims.dao;

import java.util.List;

import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.util.Page;

public interface UserDAO {
	public User findByUserID(String uid);//以编号进行查询
	public void updateUser(User user);//更新用户
	public List<User> findByUserName(String name);//以用户名进行查询
	public List<User> findByUserClass(String sclass);//以专业进行查询
	public void addUser(User user);//添加用户
	public int findUserCount();
	public List<User> findUserByPage(Page page);//查找全部用户
	public void deleteUser(String uid);
	
}
