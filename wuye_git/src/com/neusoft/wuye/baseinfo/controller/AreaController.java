package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Resource
	private IAreaService areaService;
	
	//添加小区
		@RequestMapping(value="/add")
		public ResultMessage add(AreaModel am) throws Exception {
			areaService.add(am);
			return new ResultMessage("200","添加成功");
		}
		
		//根据编号获取小区
		@RequestMapping(value="/get")
		public AreaModel get(@RequestParam(required=true) int no) throws Exception {
			return areaService.get(no);
		}
		
		//分页查询
		@RequestMapping("/getListWithPage")
		public List<AreaModel> getListWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
			return areaService.getListByAllWithPage(rows, page);
		}
		
		//分页查询
		@RequestMapping("/getListByAllWithPage")
		public PageInfo<AreaModel> getListByAllWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
			PageInfo<AreaModel> pageInfo = new PageInfo<AreaModel>();
			pageInfo.setRows(rows);
			pageInfo.setPage(page);
			pageInfo.setTotalPage(areaService.getPageCountByAll(rows));
			pageInfo.setTotalCount(areaService.getCountByAll());
			pageInfo.setList(areaService.getListByAllWithPage(rows, page));
			return pageInfo;
		}
		
		//删除
		@RequestMapping("/delete")
		public ResultMessage delete(AreaModel am) throws Exception{
			areaService.delete(am);
			return new ResultMessage("200", "删除成功");
		}
		
		//修改
		@RequestMapping(value="/modify",method=RequestMethod.POST)
		public ResultMessage modify(AreaModel am) throws Exception{
			areaService.modify(am);
			return new ResultMessage("200","修改成功");
		}
		
		//判断名称是否存在
		@RequestMapping(value="/checkNameExist",method=RequestMethod.POST)
		public boolean checkNameExist(String name) throws Exception {
			boolean result = true;
			if(areaService.checkNameExist(name)) {
				result = false;
			}
			return result;
			
		}
		
	
}
