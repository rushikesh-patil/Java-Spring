package com.infotool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infotool.model.Defect;
@Service
public interface DefectManagementService {
	void saveDefect(Defect defect);
	List<Defect> getDefectList();
	boolean deleteDefect(String id);
}
