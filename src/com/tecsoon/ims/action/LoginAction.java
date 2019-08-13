package com.tecsoon.ims.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.service.AdminService;
import com.tecsoon.ims.service.AdminServiceImpl;
import com.tecsoon.ims.service.UserService;
import com.tecsoon.ims.service.UserServiceImpl;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id; // 接受用户编号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String password; // 接受用户密码
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private UserService userService = new UserServiceImpl();// 用户业务逻辑组件引用
	private AdminService adminService = new AdminServiceImpl();// 管理员业务组件
	private User user;
	private String role;//接受用户角色

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if ("user".equals(role)) {// 如果以用户身份登录
			if (userService.allowLogin(id, password)) {
				List<User> userInfo = userService.getUserInfo(id);
				for (int i = 0; i < userInfo.size(); i++) {
					// 保存用户记录到session范围
					@SuppressWarnings("rawtypes")
					Map session = ActionContext.getContext().getSession();
					session.put("userInfo", userInfo.get(i));
				}
				return "userSuccess";
			} else {
				addActionError("该用户名字不存在，或者密码不正确!");
				return Action.INPUT;
			}
		} else {
			if (adminService.allowLogin(id, password)) {
				return "adminSuccess";
			} else {
				addActionError("该管理名字不存在，或者密码不正确!");
				return Action.INPUT;
			}
		}
	}
}
