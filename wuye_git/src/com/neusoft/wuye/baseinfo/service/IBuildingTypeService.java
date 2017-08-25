package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;

public interface IBuildingTypeService {
	public void add(BuildingTypeModel btm) throws Exception;

	public void modify(BuildingTypeModel btm) throws Exception;

	public void delete(BuildingTypeModel btm) throws Exception;

	public BuildingTypeModel get(int typeNo) throws Exception;

	public List<BuildingTypeModel> getListByAll() throws Exception;

	public List<BuildingTypeModel> getListByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
	
}
