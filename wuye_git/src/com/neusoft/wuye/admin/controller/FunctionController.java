package com.neusoft.wuye.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.service.IFunctionService;

//系统功能控制器类
@RestController
@RequestMapping(value="/function")
public class FunctionController {
	
	private IFunctionService fs=null;
	@Autowired
	public void setFs(IFunctionService fs) {
		this.fs = fs;
	}
	//取得指定的功能对象
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public FunctionModel get(@RequestParam int functionNo) throws Exception{
		return fs.get(functionNo);
	}
	
	//取得所有功能列表
	@RequestMapping(value="/list/all")
	public List<FunctionModel> getListByAll() throws Exception
	{
		return fs.getListByAll();
	}
	//取得指定用户的功能列表
	@RequestMapping(value="/list/user")
	public List<FunctionModel> getListByUser(@RequestParam String userid) throws Exception
	{
		return fs.getListByUser(userid);
	}

}
