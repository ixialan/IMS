package com.tecsoon.ims.service;

import com.tecsoon.ims.dao.CvDAO;
import com.tecsoon.ims.dao.CvDAOImpl;
import com.tecsoon.ims.entity.Cv;

public class CvServiceImpl implements CvService{
	private CvDAO cvDAO =  new CvDAOImpl();
	public boolean saveCv(Cv cv) {
			cvDAO.addCv(cv);
			return true;
	}
	public void deleteCv(int cvid) {
		cvDAO.deleteCv(cvid);
	}

}
