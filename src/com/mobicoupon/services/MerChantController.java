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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobicoupon.bean.MerchantBean;
import com.mobicoupon.dao.DepartmentDao;
import com.mobicoupon.dao.DesignationDao;
import com.mobicoupon.dao.MerchantDao;
import com.mobicoupon.daoimpl.DepartmentBean;
import com.mobicoupon.daoimpl.DesignationBean;

@Controller
public class MerChantController {
	
	@Autowired
	public MerchantDao merchantDao;
	
	@Autowired
	public DepartmentDao departmentDao;
	
	@Autowired
	public DesignationDao designationDao;
	
	
	@RequestMapping(value="/admin/addMerchant", method=RequestMethod.POST)
	public String addMerchnat(@ModelAttribute("addForm") @Valid MerchantBean merchantBean ,
			BindingResult result,RedirectAttributes rtAttributes){
		
		if(result.hasErrors()){
			List<FieldError> fieldErrors = result.getFieldErrors(); 
			rtAttributes.addFlashAttribute("addFormErrors", fieldErrors);
			return "redirect:/add/viewMerchant";
		}
		
		int addMerchant = merchantDao.addMerchant(merchantBean);
		
		if(addMerchant < 0){
			
			rtAttributes.addFlashAttribute("addError", "Not Stored in DataBase");
			return "redirect:/admin/viewMerchnat";
		}
		
		
		return "redirect:/admin/viewMerchnat";
		
	}
	
	@RequestMapping(value = "/admin/editMerchnat" , method = RequestMethod.POST)
	public String editMerchnat(@ModelAttribute("editForm") @Valid MerchantBean merchantBean , BindingResult result
			, RedirectAttributes rtAttributes){
		
		if(result.hasErrors()){
			
			List<FieldError> fieldErrors = result.getFieldErrors(); 
			rtAttributes.addFlashAttribute("editFormErros", fieldErrors);
			return "redirect:/admin/viewMerchnat";
		}
		
		int editMerchant = merchantDao.editMerchant(merchantBean); 
		
		if(editMerchant > 0){
			
			return "redirect:/admin/viewMerchnat";
		}
		
		rtAttributes.addFlashAttribute("editErrors", "NOT UPDATED");
		return "redirect:/admin/viewMerchnat";
	}
	
	@RequestMapping(value = "/admin/viewMerchant" , method = RequestMethod.POST)
	public String viewMerChant(Model model){
		
		List<MerchantBean> viewMerchant = merchantDao.viewMerchant();
		List<DesignationBean> viewDesignations = designationDao.viewDesignations();
		List<DepartmentBean> departments = departmentDao.getDepartments();
		
		if(viewMerchant.isEmpty()){
			
			model.addAttribute("viewError","No list fund");
			model.addAttribute("viewDesignation", viewDesignations);
			model.addAttribute("viewDepartments", departments);
			
			return "viewMerchant";
		}
		
		model.addAttribute("viewMerchant",viewMerchant);
		model.addAttribute("viewDesignation", viewDesignations);
		model.addAttribute("viewDepartments", departments);
		
		return "viewMerchant";
	}
	
	@RequestMapping(value = "/admin/deleteMerchnat" , method = RequestMethod.GET)
	public String deleteMerchant(@RequestParam("merchantID") String merchantId , Model model){
		
		if(merchantId == ""){
			
			model.addAttribute("deleteErrors", "Enter MerchantID");
			return "viewMechnat";
		}
		
		int deleteMerchant = merchantDao.deleteMerchant(merchantId);
		
		if(deleteMerchant < 0){
			
			model.addAttribute("deleteErrors", "NOT FUND");
			return "viewMerchant";
		}
		
		return "viewMerchant";
		
	}
	
}
