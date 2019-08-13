package com.tecsoon.ims.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tecsoon.ims.entity.Cv;
import com.tecsoon.ims.service.CvService;
import com.tecsoon.ims.service.CvServiceImpl;

public class CvAddAction extends ActionSupport {

	/**
	 *  添加用户信息
	 */
	private static final long serialVersionUID = 1L;
	private String cvid;
	private String name;
	private String sex;
	private String phone_number;
	private String nation;
	private String eduback;
	private String ehpower;
	private String ftime;
	private String jexperience;
	private String evaluation;
	private CvService cvService = new CvServiceImpl();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getEduback() {
		return eduback;
	}
	public void setEduback(String eduback) {
		this.eduback = eduback;
	}
	public String getEhpower() {
		return ehpower;
	}
	public void setEhpower(String ehpower) {
		this.ehpower = ehpower;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public String getJexperience() {
		return jexperience;
	}
	public void setJexperience(String jexperience) {
		this.jexperience = jexperience;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public String getCvid() {
		return cvid;
	}
	public void setCvid(String cvid) {
		this.cvid = cvid;
	}
	public String execute() throws Exception {
		Cv cv = new Cv();
		cv.setName(name);
		cv.setSex(sex);
		cv.setEhpower(ehpower);
		cv.setFtime(ftime);
		cv.setPhone_number(phone_number);
		cv.setNation(nation);
		cv.setJexperience(jexperience);
		cv.setEvaluation(evaluation);
		
		if(cvService.saveCv(cv)) {
			return SUCCESS;
		}else {
			this.addActionError("用户信息已添加过，请勿重复添加!");
			return INPUT;
		}
	}
}
