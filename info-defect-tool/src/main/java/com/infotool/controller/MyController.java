package com.infotool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infotool.exception.UserNotFoundException;
import com.infotool.model.Defect;
import com.infotool.service.DefectManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 
@CrossOrigin(origins = "http://localhost:4200", maxAge = 6000)
@Controller
@Api(value = "DefectAPI", tags = { "Defect Management API" })
public class MyController {
	
	@Autowired
	DefectManagementService defectManagementService;
 
	@ApiOperation(value = "View a list of available employees", response = List.class)
    @RequestMapping("/getDefects")
    public @ResponseBody List<Defect> getPerson(){
    	List<Defect> defectList = defectManagementService.getDefectList();
    	
        return defectList;
    }
    
    @RequestMapping("/getDefects/{id}")
    public @ResponseBody Defect getDefect(@PathVariable("id") String id){
    	List<Defect> defectList = defectManagementService.getDefectList();
    	if(!defectList.stream().anyMatch(value -> value.getId()==Integer.parseInt(id))) {
    		throw new UserNotFoundException("User not found="+id);
    	}
    	else{
	    		for(Defect defect:defectList) {
	    			if(defect.getId()==Integer.parseInt(id)) {
	    				return defect;
	    			}
	    		}
    	}
    	
        return null;
    }
 
    @PostMapping("/saveDefect")
    public @ResponseBody String createCustomer(@RequestBody Defect defect) {
		
    	defectManagementService.saveDefect(defect);
    	
		return "Success creation";
	}
   
    @DeleteMapping("/deleteDefect/{id}")
   	public @ResponseBody String deleteCustomer(@PathVariable("id") String id) {
   		
   		if(defectManagementService.deleteDefect(id)) {
   			return "Success deletion";
   		}else 
   			return "failure deletion";
   	}
    
}
