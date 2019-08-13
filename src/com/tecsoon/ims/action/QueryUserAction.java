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

public class QueryUserAction extends ActionSupport {
	/**
	 *查询用户
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;		//当前页
	private UserService userService = new UserServiceImpl();
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(10);//每页显示10条记录
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
