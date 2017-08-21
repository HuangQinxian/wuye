package com.neusoft.wuye.baseinfo.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;

@Controller
@RequestMapping(value="/buildingtype")
public class BuildingTypeController {

	private IBuildingTypeService buildingTypeService;
	
	@Autowired
	public void setBuildingTypeService(IBuildingTypeService buildingTypeService) {
		this.buildingTypeService = buildingTypeService;
	}

	@RequestMapping(value="/add")
	public String add(BuildingTypeModel btm) throws Exception {
		System.out.println("进来了");
		buildingTypeService.add(btm);
		return "/buildingtype/main.html";
	}
	
}
