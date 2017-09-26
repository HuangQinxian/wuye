package com.neusoft.wuye.admin.service;

import java.util.List;

import com.neusoft.wuye.admin.model.ModuleModel;

//系统模块业务接口

public interface IModuleService {
	//取得指定的模块
	public ModuleModel get(int moduleNo) throws Exception;
	//取得所有的模块列表
	public List<ModuleModel> getListByAll() throws Exception;
	public int getCountByAll();
	public int getPageCountByAll(int rows);
	public List<ModuleModel> getListByAllWithPage(int rows, int page);
	public void add(ModuleModel um);
	public void delete(ModuleModel um) throws Exception;
	public boolean checkCanDelete(String no);
	
}
