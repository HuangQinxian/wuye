package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IBuildingMapper;
import com.neusoft.wuye.baseinfo.model.BuildingModel;
import com.neusoft.wuye.baseinfo.service.IBuildingService;

@Service("BuildingService")
@Transactional
public class BuildingService implements IBuildingService {

	@Resource
	private IBuildingMapper mapper;
	
	@Override
	public void add(BuildingModel bm) throws Exception {
		mapper.insert(bm);
		
	}

	@Override
	public BuildingModel get(int buildingNo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.select(buildingNo);
	}

	@Override
	public List<BuildingModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(rows*(page-1),page);
		return mapper.selectListByAllWithPage(rb);
	}

	@Override
	public List<BuildingModel> selectListByAreaNo(int areaNo) throws Exception {
		
		return mapper.selectListByAreaNo(areaNo);
	}

}
