package com.tecsoon.ims.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.service.UserService;
import com.tecsoon.ims.service.UserServiceImpl;

public class UserAddAction extends ActionSupport {
	/**
	 * 用户添加
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private String password;
	private String name;
	private Integer result;
	private String sclass;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	private UserService userService = new UserServiceImpl();
	
	
	public String execute() throws Exception {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setResult(result);
		user.setSclass(sclass);		
		if(userService.saveUser(user)) {
			return SUCCESS;
		}else {
			this.addActionError("该信息已经添加过，请勿重复操作!");
			return INPUT;
		}
	}
}
