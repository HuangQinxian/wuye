package com.neusoft.wuye.feeinfo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.neusoft.wuye.feeinfo.model.FeeTypeModel;

//缴费类型Mapper接口
public interface IFeeTypeMapper {

	void add(FeeTypeModel ftm);

	int getCountByAll();

	List<FeeTypeModel> getListByAllWithPage(RowBounds rb);

	
	
	
}
