package com.neusoft.wuye.baseinfo.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.wuye.baseinfo.common.ResultMessage;
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
		if (am.getPhotoFileName() != null) {
			mapper.insertWithPhoto(am);
		} else {
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
		RowBounds rb = new RowBounds(rows * (page - 1), rows);
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
		if (count % rows == 0) {
			page = count / rows;
		} else {
			page = count / rows + 1;
		}
		return page;
	}

	@Override
	public boolean checkNameExist(String name) throws Exception {
		List<AreaModel> list = getListByAll();
		for (AreaModel am : list) {
			if (am.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public AreaModel selectAreaWithPhoto(int areaNo) throws Exception {

		return mapper.selectAreaWithPhoto(areaNo);
	}

	@Override
	public ResultMessage importFromExcel(MultipartFile uploadExcel) throws Exception {

		if (uploadExcel != null) {
			InputStream inputStream = uploadExcel.getInputStream();
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = wb.getSheetAt(0);
			for (Row row : sheet) {
				if (row.getRowNum() != 0) {
					Cell c0 = row.getCell(0);
					String name = c0.getStringCellValue();
					Cell c1 = row.getCell(1);
					String address = c1.getStringCellValue();
					Cell c2 = row.getCell(2);
					String developer = c2.getStringCellValue();
					Cell c3 = row.getCell(3);
					double totalBuildingArea = c3.getNumericCellValue();
					Cell c4 = row.getCell(4);
					double totalUserArea = c4.getNumericCellValue();
					Cell c5 = row.getCell(5);
					double totalParkArea = c5.getNumericCellValue();
					Cell c6 = row.getCell(6);
					int totalHome = (int) c6.getNumericCellValue();
					Cell c7 = row.getCell(7);
					int totalHouse = (int) c7.getNumericCellValue();
					Cell c8 = row.getCell(8);
					int totalPark = (int) c8.getNumericCellValue();
					Cell c9 = row.getCell(9);
					Date creatDate = c9.getDateCellValue();
					AreaModel am = new AreaModel();
					am.setName(name);
					am.setAaddress(address);
					am.setDeveloper(developer);
					am.setTotalBuildingArea(totalBuildingArea);
					am.setTotalUserArea(totalUserArea);
					am.setTotalPackArea(totalParkArea);
					am.setTotalHome(totalHome);
					am.setTotalHouse(totalHouse);
					am.setTotalPack(totalPark);
					am.setStartDate(creatDate);
					this.add(am);
				}
			}
		}
		return new ResultMessage("200", "导入成功");
	}

	@Override
	public void exportToExcel(File source,File target) throws Exception {
		//读取模板文件的内容
		XSSFWorkbook wb = new XSSFWorkbook(source);
		XSSFSheet sheet = wb.getSheetAt(0);
		List<AreaModel> list = this.getListByAll();
		int i = 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(AreaModel am : list) {
			Row row = sheet.createRow(i);
			Cell c0 = row.createCell(0);
			c0.setCellValue(am.getName());			
			Cell c1 = row.createCell(1);
			c1.setCellValue(am.getAaddress());
			Cell c2 = row.createCell(2);
			c2.setCellValue(am.getDeveloper());
			Cell c3 = row.createCell(3);
			c3.setCellValue(am.getTotalBuildingArea());
			Cell c4 = row.createCell(4);
			c4.setCellValue(am.getTotalUserArea());
			Cell c5 = row.createCell(5);
			c5.setCellValue(am.getTotalPackArea());
			Cell c6 = row.createCell(6);
			c6.setCellValue(am.getTotalHome());
			Cell c7 = row.createCell(7);
			c7.setCellValue(am.getTotalHouse());
			Cell c8 = row.createCell(8);
			c8.setCellValue(am.getTotalPackArea());
			Cell c9 = row.createCell(9);
			if(am.getStartDate()!=null){
				c9.setCellValue(sdf.format(am.getStartDate()));
			}			
			i++;
		}
		//将内容写出到目标文件
		FileOutputStream fileOutputStream = new FileOutputStream(target);
		wb.write(fileOutputStream);
		fileOutputStream.close();
		wb.close();
	}

}
