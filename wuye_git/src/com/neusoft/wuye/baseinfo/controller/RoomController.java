package com.neusoft.wuye.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.model.RoomModel;
import com.neusoft.wuye.baseinfo.service.IRoomService;

//房间控制器类
@RestController
@RequestMapping(value="/room")
public class RoomController {

	private IRoomService rs=null;
	@Autowired
	public void setRs(IRoomService rs) {
		this.rs = rs;
	}
	//增加房间
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResultMessage add(RoomModel am) throws Exception
	{
	   ResultMessage result=new ResultMessage();
	   rs.add(am);
	   return new ResultMessage("200","添加成功"); 
	}
	//修改房间
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ResultMessage modify(RoomModel am) throws Exception
	{
	   ResultMessage result=new ResultMessage();
	   rs.modify(am);
	   return new ResultMessage("200","添加成功"); 
	}
	//删除房间
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ResultMessage delete(RoomModel am) throws Exception
	{
	   ResultMessage result=new ResultMessage();
	   rs.delete(am);
	   return new ResultMessage("200","添加成功");
	}
	//取得指定的房间对象
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public RoomModel get(@RequestParam int roomNo) throws Exception
	{
	   return rs.get(roomNo);
	}
	//取得所有房间列表，不分页
	@RequestMapping(value="/list/all",method=RequestMethod.GET)
	public List<RoomModel> getListByAll() throws Exception
	{
	   return rs.getListByAll();
	}
	//取得所有房间列表，分页方式,旧的方法
	@RequestMapping(value="/list/page/old",method=RequestMethod.GET)
	public List<RoomModel> getListByAllWithPageOld(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		return rs.getListByAllWithPage(rows, page);
	}
	//取得所有房间列表，分页方式,新的方法
	@RequestMapping(value="/list/page",method=RequestMethod.GET)
	public PageInfo<RoomModel> getListByAllWithPage(@RequestParam(required=false,defaultValue="10") int rows,@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		PageInfo<RoomModel> result=new PageInfo<RoomModel>();
		result.setTotalCount(rs.getCountByAll());
		result.setTotalPage(rs.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(rs.getListByAllWithPage(rows, page));
		return result;
	}
	//按检索条件取得房间列表，分页
	@RequestMapping(value="/list/condition/page",method=RequestMethod.POST)
	public PageInfo<RoomModel> getListByConditionWithPage(
			@RequestParam(required=false,defaultValue="0") int areaNo,
			@RequestParam(required=false,defaultValue="0") int buildingTypeNo,
			@RequestParam(required=false,defaultValue="0") int buildingNo,
			@RequestParam(required=false,defaultValue="0") int houseTypeNo,
			@RequestParam(required=false,defaultValue="") String department,
			@RequestParam(required=false,defaultValue="") String floor,
			@RequestParam(required=false,defaultValue="") String code,
			@RequestParam(required=false,defaultValue="10") int rows,
			@RequestParam(required=false,defaultValue="1") int page) throws Exception
	{
		System.out.println(buildingNo);
		PageInfo<RoomModel> result=new PageInfo<RoomModel>();
		result.setTotalCount(rs.getCountByConditon(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code));
		result.setRows(rows);
		result.setPage(page);
		result.setList(rs.getListByConditionWithPage(areaNo, buildingTypeNo, buildingNo, houseTypeNo, department, floor, code, rows, page));
		return result;
	}
	
}
