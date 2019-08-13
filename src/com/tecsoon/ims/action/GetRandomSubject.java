package com.tecsoon.ims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.Subject;
import com.tecsoon.ims.service.SubjectService;
import com.tecsoon.ims.service.SubjectServiceImpl;
public class GetRandomSubject extends ActionSupport{
	/**
	 * 获得随机试题
	 */
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService = new SubjectServiceImpl();
	public String execute() throws Exception {
		List<Subject> subjects = subjectService.randomFindSubject(20);//获得试题记录
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		return SUCCESS;
	}
}
