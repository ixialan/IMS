package com.tecsoon.ims.service;

import java.util.List;

import com.tecsoon.ims.dao.AdminDAO;
import com.tecsoon.ims.dao.AdminDAOImpl;
import com.tecsoon.ims.entity.Admin;

public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAO = new AdminDAOImpl();
	public boolean allowLogin(String adminid, String password) {
		List<Admin> admin = adminDAO.findByAdminName(adminid);
		if(admin.size() != 0)
		for(int i =0 ; i<=0;) {
			if(password.equals(admin.get(i).getPassword())
					&& adminid.equals(admin.get(i).getName())) {//获取管理员名字
					return true;
				}else{
					return false;
				}	
			}
	
		return false;
	}
}

