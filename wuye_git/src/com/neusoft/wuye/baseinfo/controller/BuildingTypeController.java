package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/get")
	@ResponseBody
	public BuildingTypeModel get(@RequestParam(required=true) int typeNo) throws Exception {
		return buildingTypeService.get(typeNo);
	}
	
	@RequestMapping("/getListByAllWithPage")
	@ResponseBody
	public List<BuildingTypeModel> getListByAllWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
		return buildingTypeService.getListByAllWithPage(rows, page);
	}
	
}
