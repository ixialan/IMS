package com.tecsoon.ims.service;

import java.util.List;

import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.util.Page;
import com.tecsoon.ims.util.PageResult;

public interface UserService {
	public boolean allowLogin(String uid,String password);
	public List<User> getUserInfo(String uid);
	public void setUserResult(String uid,int result);
	public List<User> getUserByName(String name);
	public List<User> getUserByClass(String sclass);
	public boolean saveUser(User user);
	public PageResult queryUserByPage(Page page);
	public void updateUser(User user);
	public void deleteUser(String uid);
}
