package com.tecsoon.ims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.service.UserService;
import com.tecsoon.ims.service.UserServiceImpl;

public class QueryUserByClass extends ActionSupport{
	/**
	 * 查询用户专业
	 */
	private static final long serialVersionUID = 1L;
	private String sclass;
	private UserService userService = new UserServiceImpl();
	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	@SuppressWarnings("static-access")
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> users = userService.getUserByClass(sclass);
		request.setAttribute("users", users);
		return this.SUCCESS;
	}
	
}
