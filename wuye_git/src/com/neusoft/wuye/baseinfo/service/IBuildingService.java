package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import com.neusoft.wuye.baseinfo.model.BuildingModel;

public interface IBuildingService {
	public void add(BuildingModel bm) throws Exception;

	public BuildingModel get(int buildingNo) throws Exception;
	
	public List<BuildingModel> selectListByAreaNo(int areaNo) throws Exception;

	public List<BuildingModel> getListByAllWithPage(int rows, int page) throws Exception;

}
