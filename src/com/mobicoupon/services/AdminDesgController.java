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

import com.mobicoupon.dao.DesignationDao;
import com.mobicoupon.daoimpl.DesignationBean;

@Controller
public class AdminDesgController {

	@Autowired
	DesignationDao designationDao;

	@RequestMapping(value = "/admin/designation", method = RequestMethod.GET)
	public String showDesignation(Model model) {
		List<DesignationBean> designation = designationDao.viewDesignations();
		model.addAttribute("desg", designation);
		return "designation";
	}

	@RequestMapping(value = "/admin/addDesg", method = RequestMethod.POST)
	public String addDesignation(
			@ModelAttribute("desgAddForm") @Valid DesignationBean designationBean,
			BindingResult result, RedirectAttributes rdAttributes) {
			
			if(result.hasErrors()){
			List<FieldError> list = result.getFieldErrors();
			rdAttributes.addFlashAttribute("addErrors", list);
			return "redirect:/admin/designation";
			}
			
			designationDao.addDesignation(designationBean);
			return "redirect:/admin/designation";
	}

	@RequestMapping(value = "/admin/editDesg", method = RequestMethod.POST)
	public String editDesignation(
			@ModelAttribute("desgEditForm") @Valid DesignationBean designationBean,BindingResult result,RedirectAttributes rdAttributes) {
		if(result.hasErrors()){
			List<FieldError> list = result.getFieldErrors();
			rdAttributes.addFlashAttribute("editErrors", list);
			return "redirect:/admin/designation";
		}
		designationDao.editDesignation(designationBean);
		return "redirect:/admin/designation";
	}

	@RequestMapping(value = "/admin/removeDesg", method = RequestMethod.GET)
	public String removeDesg(@RequestParam("id") String id,RedirectAttributes rdAttributes) {
		if(id.trim() == ""){
			rdAttributes.addFlashAttribute("error", "id should not be empty");
		}
		designationDao.deleteDesignation(id);
		return "redirect:/admin/designation";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/desg/xml/view" , method = RequestMethod.GET , produces="application/xml")
	public String desgXmlView(){
		
		List<DesignationBean> designation = designationDao.viewDesignations();
		String xml = "<Designations>";
		for (DesignationBean designationBean : designation) {
			xml += designationBean; 
		}
		xml += "</Designations>";
		
		return xml;
	}
	
}
