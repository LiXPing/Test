package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Province;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IProvinceService;
import cn.tedu.store.service.ex.InsertDataException;

@Controller
@RequestMapping("/address")
public class AddressController 
	extends BaseController {
	
	@Autowired
	private IAddressService addressService;
	@Autowired
	private IProvinceService provinceService;
	
	@RequestMapping("/list.do")
	public String showList(ModelMap modelMap) {
		// 获取所有的省的列表
		List<Province> provinces
			= provinceService.getProvinceList();
		// 封装所有的省的列表，以转发
		modelMap.addAttribute("provinces", provinces);
		// 执行转发
		return "address_list";
	}
	
	@RequestMapping(value="/handle_add.do",
		method=RequestMethod.POST)
	public String handleAdd(Address address,
			HttpSession session, ModelMap modelMap) {
		// 忽略：检查数据的有效性
		// 从Session中获取uid
		Integer uid = getUidFromSession(session);
		// 从Session中获取username
		String username 
			= session.getAttribute("username")
				.toString();
		// 将uid封装到address中
		address.setUid(uid);
		
		try {
			// 调用业务层对象的add(Address address)方法执行增加
			addressService.add(username, address);
			// 增加成功，则重定向
			// 当前位置：/address/handle_add.do
			// 目标位置：/address/list.do
			return "redirect:list.do";
		} catch(InsertDataException e) {
			// 封装错误信息
			modelMap.addAttribute(
				"message", e.getMessage());
			// 转发到提示错误的页面
			return "error";
		}
	}

}








