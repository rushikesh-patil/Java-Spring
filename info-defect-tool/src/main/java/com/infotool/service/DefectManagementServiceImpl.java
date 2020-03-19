package com.infotool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotool.dao.DefectManagementDaoImpl;
import com.infotool.model.Defect;

@Service
public class DefectManagementServiceImpl implements DefectManagementService{

	@Autowired
	DefectManagementDaoImpl defectManagementDaoImpl;
	
	@Override
	public void saveDefect(Defect defect){
		defectManagementDaoImpl.saveDefect(defect);
	}

	@Override
	public List<Defect> getDefectList() {
		// TODO Auto-generated method stub
		return defectManagementDaoImpl.getDefectList();
	}

	@Override
	public boolean deleteDefect(String id) {
		// TODO Auto-generated method stub
		return defectManagementDaoImpl.deleteDefect(id);
	}
}
