package com.tecsoon.ims.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.Subject;
import com.tecsoon.ims.service.SubjectService;
import com.tecsoon.ims.service.SubjectServiceImpl;

public class ShowSubjectAnswer extends ActionSupport{
	/**
	 * 显示试题答案
	 */
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService = new SubjectServiceImpl();
	@SuppressWarnings("rawtypes")
	public String execute() throws Exception {
		List<Subject> subjects = new ArrayList<Subject>();
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		@SuppressWarnings("unchecked")
		List<Integer> subjectIDs = (List<Integer>) session.get("subjectIDs");
		for(Integer subjectID : subjectIDs) {
			Subject subject = subjectService.showSubjectParticular(subjectID);
			subjects.add(subject);
		}
		request.setAttribute("subjects", subjects);
		return SUCCESS;
	}
}
