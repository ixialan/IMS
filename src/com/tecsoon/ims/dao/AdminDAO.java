package com.tecsoon.ims.dao;

import java.util.List;

import com.tecsoon.ims.entity.Admin;

public interface AdminDAO {
	public Admin findByAdminID(String adminid);//查询方法，根据管理员ID查询

	public List<Admin> findByAdminName(String name);

	
}
