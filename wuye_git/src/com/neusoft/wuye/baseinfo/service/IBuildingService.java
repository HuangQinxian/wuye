package com.neusoft.wuye.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.wuye.baseinfo.model.BuildingModel;

public interface IBuildingService {
	public void add(BuildingModel bm) throws Exception;

	public BuildingModel get(int buildingNo) throws Exception;
	
	public List<BuildingModel> selectListByAreaNo(int areaNo) throws Exception;

	public List<BuildingModel> getListByAllWithPage(int rows, int page) throws Exception;

	// 按检索条件取得建筑楼宇的个数
	public int selectCount(int areaNo,int buildingTypeNo,String code) throws Exception;

	public int getPageCountByAll(int areaNo, int buildingTypeNo, String code,int rows) throws Exception;

	List<BuildingModel> getListByAllWithPageWithConditions(int areaNo, int buildingTypeNo, String code, int rows,
			int page) throws Exception;

}
