package com.neusoft.wuye.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.baseinfo.model.AreaModel;

public interface IAreaMapper {
	public void insert(AreaModel am) throws Exception;
	public void insertWithPhoto(AreaModel am) throws Exception;
	public void update(AreaModel am) throws Exception;
	public void delete(AreaModel am) throws Exception;
	public AreaModel select(int areaNo) throws Exception;
	public List<AreaModel> selectListByAll() throws Exception;
	public List<AreaModel> selectListByAllWithPage(RowBounds rb) throws Exception;
	public int selectCountByAll() throws Exception;
}
