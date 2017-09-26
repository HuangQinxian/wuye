package com.neusoft.wuye.admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.wuye.admin.mapper.IFunctionMapper;
import com.neusoft.wuye.admin.mapper.IModuleMapper;
import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.model.ModuleModel;
import com.neusoft.wuye.admin.service.IFunctionService;
import com.neusoft.wuye.admin.service.IModuleService;
//模块功能实现类
@Service("ModuleService")
@Transactional
public class ModuleServiceImpl implements IModuleService {

	private IModuleMapper mmp=null;
	
	private IFunctionMapper fm = null;
	
	@Autowired
	public void setMmp(IModuleMapper mmp) {
		this.mmp = mmp;
	}
	
	@Autowired
	public void setFm(IFunctionMapper fm) {
		this.fm = fm;
	}



	@Override
	public ModuleModel get(int moduleNo) throws Exception {
		
		return mmp.select(moduleNo);
	}

	@Override
	public List<ModuleModel> getListByAll() throws Exception {
		
		return mmp.selectListByAll();
	}

	@Override
	public int getCountByAll() {
		// TODO Auto-generated method stub
		return mmp.getCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0){
			pageCount=count/rows;
		}
		else{
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<ModuleModel> getListByAllWithPage(int rows, int page) {
		RowBounds rb = new RowBounds(rows*(page - 1), rows);
		return mmp.getListByAllWithPage(rb);
	}

	@Override
	public void add(ModuleModel um) {
		mmp.add(um);
	}

	@Override
	public void delete(ModuleModel um) throws Exception {
		mmp.delete(um);
	}

	@Override
	public boolean checkCanDelete(String no) {
		List<FunctionModel> list = fm.selectListByMNO(no);
		if(list != null && list.size() > 0)
			return false;
		return true;
	}

	@Override
	public void modify(ModuleModel um) {
		mmp.modify(um);
	}

}
