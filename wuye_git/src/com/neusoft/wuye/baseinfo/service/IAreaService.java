package com.neusoft.wuye.baseinfo.service;

import java.io.File;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.model.AreaModel;

public interface IAreaService {
	public void add(AreaModel am) throws Exception;

	public void modify(AreaModel am) throws Exception;

	public void delete(AreaModel am) throws Exception;

	public AreaModel get(int areaNo) throws Exception;

	public List<AreaModel> getListByAll() throws Exception;

	public List<AreaModel> getListByAllWithPage(int rows, int page) throws Exception;

	public int getCountByAll() throws Exception;

	public int getPageCountByAll(int rows) throws Exception;
	
	public boolean checkNameExist(String name) throws Exception;
	
	public AreaModel selectAreaWithPhoto(int areaNo) throws Exception;
	
	public ResultMessage importFromExcel(MultipartFile uploadExcel) throws Exception;
	
	public void exportToExcel(File source,File target) throws Exception;
}
