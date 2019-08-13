package com.tecsoon.ims.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.User;
import com.tecsoon.ims.service.SubjectService;
import com.tecsoon.ims.service.SubjectServiceImpl;
import com.tecsoon.ims.service.UserService;
import com.tecsoon.ims.service.UserServiceImpl;

public class SubmitExamAction extends ActionSupport{
	/**
	 * 提交试卷并打分
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> subjectID;//考试题目
	private SubjectService subjectService = new SubjectServiceImpl();
	private UserService userService = new UserServiceImpl();
	public List<Integer> getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(List<Integer> subjectID) {
		this.subjectID = subjectID;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> userAnswers = new ArrayList<String>();
		for(int i = 0; i < 20; i++) {
			String answer = request.getParameter("subjectAnswer"+i);
			userAnswers.add(answer);
		}
		int GeneralPoint = subjectService.accountResult(subjectID, userAnswers);
		
		
		@SuppressWarnings("rawtypes")
		Map session = ActionContext.getContext().getSession();
		User user = (User)session.get("userInfo");
		String uid = user.getUid();
		userService.setUserResult(uid, GeneralPoint);
		request.setAttribute("name", user.getName());
		request.setAttribute("GeneralPoint", GeneralPoint);
		session.put("subjectIDs", subjectID);
		return SUCCESS;
	}
}
