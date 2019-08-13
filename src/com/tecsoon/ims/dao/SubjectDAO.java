package com.tecsoon.ims.dao;

import java.util.List;

import com.tecsoon.ims.entity.Subject;
import com.tecsoon.ims.util.Page;

public interface SubjectDAO {
	public void addSubject(Subject subject);//保存方法，用来保存试题
	public Subject findSubjectByTitle(String subjectTitle);//根据试题标题查找试题
	public List<Subject> findSubjectByPage(Page page);//分页查询试题
	public int findSubjectCount();//查询试题总量
	public Subject findSubjectByID(int subjectID);//根据试题ID查找试题
	public void updateSubject(Subject subject);//更新方法，用来更新试题
	public void deleteSubject(int subjectID);//根据试题ID删除试题
	public List<Subject> likeQueryByTitle(String subjectTitle,Page page);//根据试题标题模糊查询试题
	public int findLinkQueryCount(String subjectTitle);//查询模糊记录数
	public List<Subject> randomFindSubject(int number);//随时取出记录
}

