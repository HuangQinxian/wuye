package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.model.BuildingModel;
import com.neusoft.wuye.baseinfo.model.BuildingTypeModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;
import com.neusoft.wuye.baseinfo.service.IBuildingService;
import com.neusoft.wuye.baseinfo.service.IBuildingTypeService;

public class Main {
	public static void main(String[] args) throws Exception {
		testGetAreaWithCollection();
	}
	
	public static void testAdd() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IBuildingTypeService service = ac.getBean("BuildingTypeService",IBuildingTypeService.class);
		BuildingTypeModel btm = new BuildingTypeModel();
		btm.setName("one");
		service.add(btm);
	}
	
	public static void testGet() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IBuildingTypeService service = ac.getBean("BuildingTypeService",IBuildingTypeService.class);
		BuildingTypeModel btm = service.get(1);
		System.out.println(btm.getNo()+"----"+btm.getName());
	}
	
	public static void testAddArea() throws Exception{
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IAreaService areaService = ac.getBean("AreaService",IAreaService.class);
		AreaModel am = new AreaModel();
		am.setName("区域2");
		am.setAaddress("");
		am.setDeveloper("");
		am.setTotalBuildingArea(0.0);
		am.setTotalHome(0);
		am.setTotalHouse(0);
		am.setTotalPack(0);
		am.setTotalPackArea(0.0);
		am.setTotalUserArea(0.0);
		areaService.add(am);
	}
	
	public static void testAddBuildingType() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IBuildingTypeService buildingTypeService = ac.getBean("BuildingTypeService",IBuildingTypeService.class);
		BuildingTypeModel btm = new BuildingTypeModel();
		btm.setName("建筑类型3");	
		buildingTypeService.add(btm);
	}
	
	public static void testAddBuilding() throws Exception{
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IBuildingService buildingService = ac.getBean("BuildingService",IBuildingService.class);
		
		AreaModel am = new AreaModel();
		am.setNo(7);
		am.setName("区域3");
		am.setAaddress("");
		am.setDeveloper("");
		am.setTotalBuildingArea(0.0);
		am.setTotalHome(0);
		am.setTotalHouse(0);
		am.setTotalPack(0);
		am.setTotalPackArea(0.0);
		am.setTotalUserArea(0.0);
		
		BuildingTypeModel btm1 = new BuildingTypeModel();
		btm1.setNo(1);
		btm1.setName("建筑类型3");
		
		BuildingTypeModel btm2 = new BuildingTypeModel();
		btm2.setNo(21);
		btm2.setName("建筑类型3");
		
		List<BuildingTypeModel> list = new ArrayList<BuildingTypeModel>();
		list.add(btm1);
		list.add(btm2);
		
		BuildingModel bm = new BuildingModel();
		bm.setAddress("building地址2");
		bm.setArea(am);
		bm.setBuildingType(btm2);
		bm.setCode("A1");
		bm.setDirection("南");
		bm.setTotalHome(0);
		bm.setTotalHouse(0);
		
		
		buildingService.add(bm);
	}
	
	public static void testGetAreaWithCollection() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IAreaService areaService = ac.getBean("AreaService",IAreaService.class);
		AreaModel am = areaService.get(7);
		System.out.println(am.getName());
		System.out.println(am.getBuildings());
		
	}
	
	public static void testSelectListByAreaNo() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:context.xml");
		IBuildingService buildingService = ac.getBean("BuildingService",IBuildingService.class);
		List<BuildingModel> list = buildingService.selectListByAreaNo(7);
		System.out.println(list.size());
		
	}
	
}
