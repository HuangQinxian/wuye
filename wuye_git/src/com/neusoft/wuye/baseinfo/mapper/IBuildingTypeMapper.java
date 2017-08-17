package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;

public interface IBuildingTypeMapper {
	public void insert(BuildingTypeModel btm) throws Exception;
	public void update(BuildingTypeModel btm) throws Exception;
	public void delete(BuildingTypeModel btm) throws Exception;
	public BuildingTypeModel select(int typeNo) throws Exception;
	public List<BuildingTypeModel> selectListByAll() throws Exception;
	public List<BuildingTypeModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	public int selectCountByAll() throws Exception;
	
}
