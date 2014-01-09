package com.mobicoupon.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mobicoupon.dao.DepartmentBean;
import com.mobicoupon.dao.DepartmentDao;


@Controller
public class AdminController {

	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String homePage() {
		return "adminpanel";
	}

	@RequestMapping(value = "/admin/department", method = RequestMethod.GET)
	public String department(Model model) {
		List<DepartmentBean> depts = departmentDao.getDepartments();
		model.addAttribute("depts", depts);
		return "department";
	}

	@RequestMapping(value = "/admin/addDept", method = RequestMethod.POST)
	public String addDept(@ModelAttribute DepartmentBean addBean) {
		departmentDao.addDept(addBean);
		return "redirect:/admin/department";
	}
	
	@RequestMapping(value ="/admin/editDept" , method = RequestMethod.POST)
	public String editDept(@ModelAttribute DepartmentBean editBean){
		departmentDao.editDept(editBean);
		return "redirect:/admin/department";
	}
	
	@RequestMapping(value ="/admin/removeDept" , method = RequestMethod.GET)
	public String removeDept(@RequestParam("id") String id){
		departmentDao.removeDept(id);
		return "redirect:/admin/department";
	}
	
}
