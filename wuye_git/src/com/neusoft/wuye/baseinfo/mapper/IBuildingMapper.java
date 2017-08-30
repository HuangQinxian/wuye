package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.BuildingModel;

public interface IBuildingMapper {
	// 增加楼宇
	public void insert(BuildingModel btm) throws Exception;

	// 修改楼宇
	public void update(BuildingModel btm) throws Exception;

	// 删除楼宇
	public void delete(BuildingModel btm) throws Exception;

	// 取得指定的楼宇
	public BuildingModel select(int buildingNo) throws Exception;

	// 取得所有楼宇列表
	public List<BuildingModel> selectListByAll() throws Exception;

	// 按检索条件取得楼宇列表
	public List<BuildingModel> selectListByCondition(int areaNo, int buildingTypeNo, String code) throws Exception;

	// 分页方式取得楼宇列表
	public List<BuildingModel> selectListByAllWithPage(RowBounds rb) throws Exception;

	// 按检索条件取得楼宇列表,分页方式
	public List<BuildingModel> selectListByConditionWithPage(@Param("areaNo")int areaNo, @Param("buildingTypeNo")int buildingTypeNo, @Param("code")String code, RowBounds rb)
			throws Exception;

	// 取得建筑楼宇的个数
	public int selectCountByAll() throws Exception;

	//
	// 按检索条件取得建筑楼宇的个数
	public int selectCount(@Param("areaNo")int areaNo,@Param("buildingTypeNo") int buildingTypeNo,@Param("code") String code) throws Exception;

	public List<BuildingModel> selectListByAreaNo(int areaNo) throws Exception;
	
	public List<BuildingModel> selectListByBuildingTypeNo(int buildingTypeNO) throws Exception;
	
}
