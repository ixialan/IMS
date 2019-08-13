package com.tecsoon.ims.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.Subject;
import com.tecsoon.ims.service.SubjectService;
import com.tecsoon.ims.service.SubjectServiceImpl;
public class SubjectUpdateBefore extends ActionSupport {
	/**
	 * 获得更新试题前的试题
	 */
	private static final long serialVersionUID = 1L;
	private int subjectID;
	private SubjectService subjectService = new SubjectServiceImpl();
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public String execute() throws Exception {
		Subject subject = subjectService.showSubjectParticular(subjectID);
		ServletActionContext.getRequest().setAttribute("subject", subject);
		return SUCCESS;
	}
}
