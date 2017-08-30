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
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return mapper.selectListByAllWithPage(rb);
	}
	
	@Override
	public List<BuildingModel> getListByAllWithPageWithConditions(int areaNo, int buildingTypeNo, String code,int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return mapper.selectListByConditionWithPage(areaNo, buildingTypeNo, code, rb);
	}

	@Override
	public List<BuildingModel> selectListByAreaNo(int areaNo) throws Exception {
		
		return mapper.selectListByAreaNo(areaNo);
	}

	@Override
	public int selectCount(int areaNo, int buildingTypeNo, String code) throws Exception {
		
		return mapper.selectCount(areaNo, buildingTypeNo, code);
	}

	@Override
	public int getPageCountByAll(int areaNo, int buildingTypeNo, String code,int rows) throws Exception {
		int count = this.selectCount(areaNo, buildingTypeNo, code);
		return count%rows == 0?count/rows:count/rows+1;
	}

}
