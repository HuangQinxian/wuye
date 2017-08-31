package com.neusoft.wuye.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.wuye.admin.model.FunctionModel;
import com.neusoft.wuye.admin.model.UserModel;
import com.neusoft.wuye.admin.service.IUserService;
import com.neusoft.wuye.baseinfo.common.PageInfo;
import com.neusoft.wuye.baseinfo.common.ResultMessage;
import com.neusoft.wuye.baseinfo.common.UserInfo;

//系统操作员控制器类
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private IUserService us = null;

	@Autowired
	public void setUs(IUserService us) {
		this.us = us;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResultMessage add(UserModel um, @RequestParam(required = false) int[] functionNos) throws Exception {
		us.add(um);
		if (functionNos != null) {
			us.grantFunctions(um.getUserid(), functionNos);
		}
		return new ResultMessage("200", "增加系统操作员成功");

	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResultMessage modify(UserModel um, @RequestParam(required = false) int[] functionNos) throws Exception {
		us.modify(um);
		us.revoleFunctions(um.getUserid());
		if (functionNos != null) {
			us.grantFunctions(um.getUserid(), functionNos);
		}
		return new ResultMessage("200", "修改系统操作员成功");

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultMessage delete(UserModel um) throws Exception {
		us.delete(um);
		return new ResultMessage("200", "删除系统操作员成功");

	}

	// 验证操作员方法,用于操作员登录验证
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ResultMessage validate(@RequestParam String userid, @RequestParam String password, HttpSession session)
			throws Exception {
		if (us.validate(userid, password)) {
			// 将用户保存到会话对象
			UserModel um = us.get(userid);
			System.out.println(um.getName());
//			List<FunctionModel> functions = um.getFunctions();
//			for(FunctionModel fm : functions) {
//				System.out.println(fm.getNo()+"  "+fm.getName());
//			}
			session.setAttribute("user", um);
			return new ResultMessage("Y", "验证系统操作员成功");
		} else {
			return new ResultMessage("N", "验证系统操作员失败");
		}
	}

	// 取得指定的系统操作员
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public UserModel get(@RequestParam String userid) throws Exception {
		return us.get(userid);

	}

	// 取得所有操作员列表，无分页
	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public List<UserModel> getListByAll() throws Exception {
		return us.getListByAll();

	}

	// 取得所有操作员列表，分页模式(旧方法)
	@RequestMapping(value = "/list/page/old", method = RequestMethod.GET)
	public List<UserModel> getListByAllWithPageOld(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		return us.getListByAllWithPage(rows, page);

	}

	// 取得所有操作员列表，分页模式
	@RequestMapping(value = "/list/page", method = RequestMethod.GET)
	public PageInfo<UserModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		PageInfo<UserModel> result = new PageInfo<UserModel>();
		result.setTotalCount(us.getCountByAll());
		result.setTotalPage(us.getPageCountByAll(rows));
		result.setPage(page);
		result.setRows(rows);
		result.setList(us.getListByAllWithPage(rows, page));
		return result;

	}

	// 取得会话对象中保存的操作员对象
	@RequestMapping(value = "/getfromsession", method = RequestMethod.GET)
	public UserInfo<UserModel> get(HttpSession session) throws Exception {
		UserInfo<UserModel> userInfo = new UserInfo<UserModel>();
		// 从会话对象中取得用户信息直接返回
		UserModel um = (UserModel) session.getAttribute("user");
		if (um == null) {
			userInfo.setResult("N");
			userInfo.setMessage("操作员没有登录");
		} else {
			userInfo.setResult("Y");
			userInfo.setMessage("操作员已经登录");
			userInfo.setUser(um);
		}
		System.out.println("取得sesion用户");

		return userInfo;

	}

	// 检查指定的操作员能否被删除
	@RequestMapping(value = "/checkcandelete", method = RequestMethod.GET)
	public ResultMessage checkCanDelete(@RequestParam String userid) throws Exception {
		ResultMessage result = new ResultMessage();
		if (us.checkCanDelete(userid)) {
			return new ResultMessage("200", "此操作员可以被删除");
		} else {
			return new ResultMessage("500", "此操作员不能被删除");
		}
	}

	// 操作员注销
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResultMessage logout(HttpSession session) throws Exception {
		ResultMessage result = new ResultMessage();
		session.invalidate(); // 销毁会话对象
		return new ResultMessage("200", "操作员注销成功");
	}

	//
	@RequestMapping(value = "/useridvalidate", method = RequestMethod.GET)
	public boolean checkUserIdValidate(@RequestParam String userid) throws Exception {
		if (us.get(userid) != null) {
			return false;
		} else {
			return true;
		}
	}

	// 验证用户ID是否允许登录
	@RequestMapping(value = "/usercanlogin", method = RequestMethod.GET)
	public boolean checkUserCanLogin(@RequestParam String userid) throws Exception {
		UserModel um = us.get(userid);
		if (um != null && um.getStatus() != null && um.getStatus().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

}
