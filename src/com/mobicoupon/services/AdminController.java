package com.mobicoupon.services;

 import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobicoupon.dao.DepartmentDao;
import com.mobicoupon.dao.DesignationDao;
import com.mobicoupon.daoimpl.DepartmentBean;

@Controller
public class AdminController {

	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private DesignationDao designationDao;

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
	public String addDept(@ModelAttribute("deptForm") @Valid DepartmentBean addBean,BindingResult result,RedirectAttributes rAttrs) {
		if(result.hasErrors()){
			List<FieldError> list = result.getFieldErrors();
			rAttrs.addFlashAttribute("errors", list);
			return "redirect:/admin/department";
		}
		departmentDao.addDept(addBean);
		return "redirect:/admin/department";
	}

	@RequestMapping(value = "/admin/editDept", method = RequestMethod.POST)
	public String editDept(@ModelAttribute("editDept") @Valid DepartmentBean editBean,BindingResult result,RedirectAttributes model) {
		if(result.hasErrors()){
			List<FieldError> list = result.getFieldErrors();
	       model.addFlashAttribute("editErrors", list);
	       return "redirect:/admin/department";
		}
		departmentDao.editDept(editBean);
		return "redirect:/admin/department";
	}

	@RequestMapping(value = "/admin/removeDept", method = RequestMethod.GET)
	public String removeDept(@RequestParam("id") String id,RedirectAttributes model) {
		if(id.trim() == "" ){
			model.addFlashAttribute("error","id should not be empty");
			return "redirect:/admin/department";
		}
		departmentDao.removeDept(id);
		return "redirect:/admin/department";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/dept/xml/view" , method = RequestMethod.GET, produces = "application/xml")
	public String ViewDept(){
		
		List<DepartmentBean> departments = departmentDao.getDepartments();  
		
		String xml = "<Department>";
		
		for (DepartmentBean departmentBean : departments) {
			xml += departmentBean;
		}
		
		xml += "</Department>";
		
		return xml;
	}
}
