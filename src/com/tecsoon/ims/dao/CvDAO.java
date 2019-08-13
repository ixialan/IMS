package com.tecsoon.ims.dao;

import com.tecsoon.ims.entity.Cv;

public interface CvDAO {

	public void addCv(Cv cv);//添加用户信息
	public void deleteCv(int cvid);//删除用户信息

}
