package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IBuildingTypeMapper;
import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;

@Service("BuildingTypeService")
@Transactional
public class BuildingTypeServiceImpl implements IBuildingTypeService{

	@Resource
	private IBuildingTypeMapper mapper;
	
	@Override
	public void add(BuildingTypeModel btm) throws Exception {
		mapper.insert(btm);
		
	}

	@Override
	public void modify(BuildingTypeModel btm) throws Exception {
		mapper.update(btm);
		
	}

	@Override
	public void delete(BuildingTypeModel btm) throws Exception {
		mapper.delete(btm);
		
	}

	@Override
	public BuildingTypeModel get(int typeNo) throws Exception {
		
		return mapper.select(typeNo);
	}

	@Override
	public List<BuildingTypeModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectListByAll();
	}

	@Override
	public List<BuildingTypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		// TODO Auto-generated method stub
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return mapper.selectListByAllWithPage(rb);
	}

	@Override
	public int getCountByAll() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		// TODO Auto-generated method stub
		int count = mapper.selectCountByAll();
		int page = 0;
		if(count%rows == 0) {
			page = count/rows;
		}else {
			page = count/rows + 1;
		}
		return page;
	}
	

}
