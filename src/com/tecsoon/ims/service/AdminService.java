package com.tecsoon.ims.service;

public interface AdminService {
	//判断是否为合法管理员，从而决定是否允许登录
	public boolean allowLogin(String adminid,String password);

}
