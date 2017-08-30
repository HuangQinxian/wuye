package com.neusoft.wuye.baseinfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.model.AreaModel;
import com.neusoft.wuye.baseinfo.service.IAreaService;
import com.sun.org.apache.xpath.internal.operations.Mult;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Resource
	private IAreaService areaService;
	
	//添加小区
		@RequestMapping(value="/add")
		public ResultMessage add(AreaModel am,@RequestParam(required=false)MultipartFile uploadPhoto,HttpSession session) throws Exception {
			if(uploadPhoto != null) {
//				System.out.println(uploadFile.getOriginalFilename());
//				System.out.println(uploadFile.getContentType());
				am.setPhoto(uploadPhoto.getBytes());
				am.setPhotoContentType(uploadPhoto.getContentType());
				am.setPhotoFileName(uploadPhoto.getOriginalFilename());
				String realPath = session.getServletContext().getRealPath("/upload/"+am.getPhotoFileName());
				uploadPhoto.transferTo(new File(realPath));
			}	
			areaService.add(am);
			return new ResultMessage("200","添加成功");
		}
		
		//根据编号获取小区
		@RequestMapping(value="/get")
		public AreaModel get(@RequestParam(required=true) int no) throws Exception {
			return areaService.get(no);
		}
		
		//获取所有小区
		@RequestMapping("/getAll")
		public List<AreaModel> getAll() throws Exception{
			return areaService.getListByAll();
		}
		
		//分页查询
		@RequestMapping("/getListWithPage")
		public List<AreaModel> getListWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
			return areaService.getListByAllWithPage(rows, page);
		}
		
		//分页查询
		@RequestMapping("/getListByAllWithPage")
		public PageInfo<AreaModel> getListByAllWithPage(@RequestParam(defaultValue="5")int rows,@RequestParam(defaultValue="1") int page) throws Exception{
			PageInfo<AreaModel> pageInfo = new PageInfo<AreaModel>();
			pageInfo.setRows(rows);
			pageInfo.setPage(page);
			pageInfo.setTotalPage(areaService.getPageCountByAll(rows));
			pageInfo.setTotalCount(areaService.getCountByAll());
			pageInfo.setList(areaService.getListByAllWithPage(rows, page));
			return pageInfo;
		}
		
		//删除
		@RequestMapping("/delete")
		public ResultMessage delete(AreaModel am) throws Exception{
			areaService.delete(am);
			return new ResultMessage("200", "删除成功");
		}
		
		//修改
		@RequestMapping(value="/modify",method=RequestMethod.POST)
		public ResultMessage modify(AreaModel am) throws Exception{
			areaService.modify(am);
			return new ResultMessage("200","修改成功");
		}
		
		//判断名称是否存在
		@RequestMapping(value="/checkNameExist",method=RequestMethod.POST)
		public boolean checkNameExist(String name) throws Exception {
			boolean result = true;
			if(areaService.checkNameExist(name)) {
				result = false;
			}
			return result;
			
		}
		
		//根据小区号获取带附件的小区
		@RequestMapping("/selectAreaWithPhoto")
		public AreaModel selectAreaWithPhoto(@RequestParam int areaNo) throws Exception{
			return areaService.selectAreaWithPhoto(areaNo);
		}
		
		//附件下载
		@RequestMapping("/downPhoto")
		public ResponseEntity<byte[]> downPhoto(@RequestParam int areaNo) throws Exception{
			AreaModel am = selectAreaWithPhoto(areaNo);
			String contentType = am.getPhotoContentType();
			String fileName = am.getPhotoFileName();
			if(contentType != null && fileName != null) {
				String[] str = contentType.split("/");
				if(str.length == 2) {
					HttpHeaders headers = new HttpHeaders();
					fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
					headers.setContentDispositionFormData("attachment", fileName);
					headers.setContentType(new MediaType(str[0], str[1]));
					//设置响应状态码create （201）
					return new ResponseEntity<byte[]>(am.getPhoto(),headers, HttpStatus.CREATED);
				}
			}
			return null;			
		}
		
		//excel数据导入
		@RequestMapping("importFromExcel")
		public ResultMessage importFromExcel(@RequestParam MultipartFile uploadExcel) throws Exception{
			if(uploadExcel != null)
				return areaService.importFromExcel(uploadExcel);
			return new ResultMessage("","");	
			
			
		}
		
		//excel数据导出
		@RequestMapping("exportToExcel")
		public ResponseEntity<byte[]> exportToExcel(HttpSession session) throws Exception{
			String sourcePath = session.getServletContext().getRealPath("/areaexport/areaexport.xlsx");
			String targetPath = session.getServletContext().getRealPath("/areaexport/areaexport"+(int)(Math.random()*1000)+".xlsx");
			
			File source = new File(sourcePath);
			File target = new File(targetPath);
			
			areaService.exportToExcel(source, target);
			
			File tempFile = new File(targetPath);
			FileInputStream in = new FileInputStream(tempFile);
			byte[] data = new byte[in.available()];
			in.read(data, 0, data.length);
			
			//临时文件的内容已经读取到内存中，此时可以删除临时文件
			in.close();
			tempFile.delete();
			
			HttpHeaders headers = new HttpHeaders();
			String fileName = new String("小区资料.xlsx".getBytes("UTF-8"),"ISO-8859-1");
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(new MediaType("application","vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
			//设置响应状态码create （201）
			return new ResponseEntity<byte[]>(data,headers, HttpStatus.CREATED);
			
		}
		
}
