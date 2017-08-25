package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IBuildingService;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;

@RestController      //作用：相当于@Controller + @ResponseBody
@RequestMapping(value="/buildingtype")
public class BuildingTypeController {

	private IBuildingTypeService buildingTypeService;
	
	@Resource
	private IBuildingService buildingService;
	
	@Autowired
	public void setBuildingTypeService(IBuildingTypeService buildingTypeService) {
		this.buildingTypeService = buildingTypeService;
	}

	//添加楼宇类型
	@RequestMapping(value="/add")
	public ResultMessage add(BuildingTypeModel btm) throws Exception {
		buildingTypeService.add(btm);
		return new ResultMessage("200","添加成功");
	}
	
	//根据类型编号获取楼宇
	@RequestMapping(value="/get")
	public BuildingTypeModel get(@RequestParam(required=true) int typeNo) throws Exception {
		return buildingTypeService.get(typeNo);
	}
	
	//分页查询
	@RequestMapping("/getListWithPage")
	public List<BuildingTypeModel> getListWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
		return buildingTypeService.getListByAllWithPage(rows, page);
	}
	
	//分页查询
	@RequestMapping("/getListByAllWithPage")
	public PageInfo<BuildingTypeModel> getListByAllWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
		PageInfo<BuildingTypeModel> pageInfo = new PageInfo<>();
		pageInfo.setPage(page);
		pageInfo.setRows(rows);
		int totalPage = 0;
		int totalCount = buildingTypeService.getCountByAll();
		totalPage = totalCount%rows == 0?totalCount/rows:totalCount/rows+1;
		pageInfo.setTotalPage(totalPage);
		pageInfo.setTotalCount(totalCount);
		List<BuildingTypeModel> list = buildingTypeService.getListByAllWithPage(rows, page);
		pageInfo.setList(list);
		return pageInfo;
	}
	
	//删除
	@RequestMapping("/delete")
	public ResultMessage delete(BuildingTypeModel btm) throws Exception{
		System.out.println("进来了");
		buildingTypeService.delete(btm);
		return new ResultMessage("200", "删除成功");
	}
	
	//修改
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultMessage modify(BuildingTypeModel btm) throws Exception{
		buildingTypeService.modify(btm);
		return new ResultMessage("200","修改成功");
	}
	
	//检查是否能够删除
	@RequestMapping("/checkCanDelete")
	public ResultMessage checkCanDelete(int typeNo) throws Exception {
		int count = buildingService.selectCount(0, typeNo, null);
		if(count > 0) {
			return new ResultMessage("200","N");
		}
		return new ResultMessage("200","Y");
	}
	
}
