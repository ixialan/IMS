package com.tecsoon.ims.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.service.UserService;
import com.tecsoon.ims.service.UserServiceImpl;
import com.tecsoon.ims.util.Page;
import com.tecsoon.ims.util.PageResult;

public class UserDeleteAction extends ActionSupport {
	/**
	 * 用户删除
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private int currentPage;	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	private UserService userService = new UserServiceImpl();
	
	public String execute() throws Exception {
		userService.deleteUser(uid);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String all()throws Exception{
	Page page = new Page();
	page.setEveryPage(8);//每页显示8条记录
	page.setCurrentPage(currentPage);//设置当前页
	PageResult pageResult = userService.queryUserByPage(page);
	List<User> users = pageResult.getList();//获得用户记录
	page = pageResult.getPage();//获得分页信息
	HttpServletRequest request = ServletActionContext.getRequest();
	request.setAttribute("users", users);
	request.setAttribute("page", page);
	return SUCCESS;
	}
}
