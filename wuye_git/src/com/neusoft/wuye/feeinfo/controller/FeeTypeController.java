package com.neusoft.wuye.feeinfo.controller;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.ModuleModel;
import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.feeinfo.model.FeeTypeModel;
import com.neusoft.wuye.feeinfo.service.IFeeTypeService;

@RestController
@RequestMapping(value="/feetype")
public class FeeTypeController {
	
	@Resource
	private IFeeTypeService fts;
	
	@RequestMapping("/add")
	public ResultMessage add(FeeTypeModel ftm) throws Exception {
		fts.add(ftm);
		return new ResultMessage("200", "增加收费类型成功");
	}
	
	// 取得所有操作员列表，分页模式
		@RequestMapping(value = "/list/page", method = RequestMethod.GET)
		public PageInfo<FeeTypeModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
				@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
			PageInfo<FeeTypeModel> result = new PageInfo<FeeTypeModel>();
			result.setTotalCount(fts.getCountByAll());
			result.setTotalPage(fts.getPageCountByAll(rows));
			result.setPage(page);
			result.setRows(rows);
			result.setList(fts.getListByAllWithPage(rows, page));
			return result;
		}
	
	
}
