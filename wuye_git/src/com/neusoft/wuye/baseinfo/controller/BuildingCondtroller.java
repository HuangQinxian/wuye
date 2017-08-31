package com.neusoft.wuye.baseinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.model.BuildingModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;
import com.neusoft.wuye.baseinfo.service.IBuildingService;
import com.sun.org.apache.xpath.internal.operations.Mult;

@RestController
@RequestMapping("/building")
public class BuildingCondtroller {

	@Resource
	private IBuildingService buildingService;
	
	
		
	//分页查询
	@RequestMapping("/getListByAllWithPage")
	public PageInfo<BuildingModel> getListByAllWithPage(
			@RequestParam(defaultValue="5") int rows,
			@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false,defaultValue="0") int areaNo,
			@RequestParam(required=false,defaultValue="0") int buildingTypeNo, 
			@RequestParam(required=false,defaultValue="") String code
			) throws Exception{
		PageInfo<BuildingModel> pageInfo = new PageInfo<BuildingModel>();
		pageInfo.setRows(rows);
		pageInfo.setPage(page);
		int count = buildingService.selectCount(areaNo, buildingTypeNo, code);
		pageInfo.setTotalCount(count);
		pageInfo.setTotalPage(count % rows == 0?count/rows:count/rows+1);
		List<BuildingModel> list = buildingService.getListByAllWithPageWithConditions(areaNo, buildingTypeNo, code, rows, page);
		pageInfo.setList(list);
		return pageInfo;
	}
		
		
		
}
