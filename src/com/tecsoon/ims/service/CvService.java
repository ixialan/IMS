package com.tecsoon.ims.service;

import com.tecsoon.ims.entity.Cv;

public interface CvService {
	public boolean saveCv(Cv cv);//添加用户信息
	public void deleteCv(int cvid);//删除用户信息

}
