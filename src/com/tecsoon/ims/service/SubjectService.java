package com.tecsoon.ims.service;

import java.util.List;

import com.tecsoon.ims.entity.Subject;
import com.tecsoon.ims.util.Page;
import com.tecsoon.ims.util.PageResult;

public interface SubjectService {
	// 添加试题，首先判断该试题标题是否已经存在，如果已经则不能添加
	public boolean saveSubject(Subject subject);
	// 按分页信息查询试
	public PageResult querySubjectByPage(Page page);
	// 查看试题详细信息
	public Subject showSubjectParticular(int subjectID);
	// 更新试题信息
	public void updateSubject(Subject subject);
	// 删除试题信息
	public void deleteSubject(int subjectID);
	//模糊查询试题信息
	public PageResult likeQueryBySubjectTitle(String subjectTitle,Page page);
	//随机查询试题记录
	public List<Subject> randomFindSubject(int number);
	//计算用户得分
	public int accountResult(List<Integer> subjectIDs,List<String> Answers);
}
