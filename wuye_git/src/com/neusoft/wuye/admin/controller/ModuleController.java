package com.neusoft.wuye.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.ModuleModel;
import com.neusoft.wuye.admin.model.UserModel;
import com.neusoft.wuye.admin.service.IModuleService;
import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;

//系统模块控制器类
@RestController
@RequestMapping(value="/module")
public class ModuleController {
	private IModuleService ms=null;
	@Autowired
	public void setMs(IModuleService ms) {
		this.ms = ms;
	}
	
	//增加模块
	@RequestMapping("/add")
	public ResultMessage add(ModuleModel um, @RequestParam(required = false) int[] functionNos) throws Exception {
		ms.add(um);
		return new ResultMessage("200", "增加系统模块成功");

	}
	
	//取得指定的模块对象
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ModuleModel get(@RequestParam int moduleNo) throws Exception{
		return ms.get(moduleNo);
	}
	
	//取得所有的模块对象列表
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<ModuleModel> getListByAll() throws Exception{
		return ms.getListByAll();
	}
	
	// 取得所有操作员列表，分页模式
	@RequestMapping(value = "/list/page", method = RequestMethod.GET)
	public PageInfo<ModuleModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		PageInfo<ModuleModel> result = new PageInfo<ModuleModel>();
		result.setTotalCount(ms.getCountByAll());
		result.setTotalPage(ms.getPageCountByAll(rows));
		result.setPage(page);
		result.setRows(rows);
		result.setList(ms.getListByAllWithPage(rows, page));
		return result;

	}

	
	
}
