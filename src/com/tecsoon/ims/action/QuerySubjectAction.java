package com.tecsoon.ims.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.Subject;
import com.tecsoon.ims.service.SubjectService;
import com.tecsoon.ims.service.SubjectServiceImpl;
import com.tecsoon.ims.util.Page;
import com.tecsoon.ims.util.PageResult;

public class QuerySubjectAction extends ActionSupport {
	/**
	 * 查询试题页面
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;		//当前页
	private SubjectService subjectService = new SubjectServiceImpl();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Page page = new Page();
		page.setEveryPage(8);//每页显示8条记录
		page.setCurrentPage(currentPage);//设置当前页
		PageResult pageResult = subjectService.querySubjectByPage(page);
		List<Subject> subjects = pageResult.getList();//获得试题记录
		page = pageResult.getPage();//获得分页信息
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		return SUCCESS;
	}
}
