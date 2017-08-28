package com.neusoft.wuye.baseinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.baseinfo.mapper.IAreaMapper;
import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;

@Service("AreaService")
@Transactional
public class AreaService implements IAreaService {

	@Resource
	private IAreaMapper mapper;
	
	@Override
	public void add(AreaModel am) throws Exception {
		if(am.getPhotoFileName() != null) {
			mapper.insertWithPhoto(am);
		}else {
			mapper.insert(am);			
		}
	}

	@Override
	public void modify(AreaModel am) throws Exception {
		mapper.update(am);

	}

	@Override
	public void delete(AreaModel am) throws Exception {
		mapper.delete(am);

	}

	@Override
	public AreaModel get(int areaNo) throws Exception {
		return mapper.select(areaNo);
	}

	@Override
	public List<AreaModel> getListByAll() throws Exception {
		
		return mapper.selectListByAll();
	}

	@Override
	public List<AreaModel> getListByAllWithPage(int rows, int page) throws Exception {
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
		int count = this.getCountByAll();
		int page = 0;
		if(count%rows == 0) {
			page = count/rows;
		}else {
			page = count/rows + 1;
		}
		return page;
	}

	@Override
	public boolean checkNameExist(String name) throws Exception {
		List<AreaModel> list = getListByAll();
		for(AreaModel am : list) {
			if(am.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public AreaModel selectAreaWithPhoto(int areaNo) throws Exception {
		
		return mapper.selectAreaWithPhoto(areaNo);
	}

}
