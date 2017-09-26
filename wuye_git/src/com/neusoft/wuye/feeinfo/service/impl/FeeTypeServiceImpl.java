package com.neusoft.wuye.feeinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.neusoft.wuye.feeinfo.mapper.IFeeTypeMapper;
import com.neusoft.wuye.feeinfo.model.FeeTypeModel;
import com.neusoft.wuye.feeinfo.service.IFeeTypeService;

//缴费类型业务实现类
@Service("feeTypeService")
public class FeeTypeServiceImpl implements IFeeTypeService {

	@Resource
	private IFeeTypeMapper feeTypeMapper;
	
	@Override
	public void add(FeeTypeModel ftm) throws Exception {
		feeTypeMapper.add(ftm);
	}

	@Override
	public void modify(FeeTypeModel ftm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(FeeTypeModel ftm) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public FeeTypeModel get(int typeNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeeTypeModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeeTypeModel> getListByAllWithPage(int rows, int page) throws Exception {
		RowBounds rb = new RowBounds(rows*(page-1),rows);
		return feeTypeMapper.getListByAllWithPage(rb); 
	}

	@Override
	public int getCountByAll() throws Exception {
		int count = feeTypeMapper.getCountByAll();
		return 0;
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int count = this.getCountByAll();
		return count%rows == 0?count/rows:count/rows+1;
	}

}
