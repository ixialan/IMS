package com.tecsoon.ims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.service.UserService;
import com.tecsoon.ims.service.UserServiceImpl;

public class QueryUserByName extends ActionSupport{
	/**
	 * 查询用户名字
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private UserService userService = new UserServiceImpl();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@SuppressWarnings("static-access")
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> users = userService.getUserByName(name);
		request.setAttribute("users", users);
		return this.SUCCESS;
	}
	
}
