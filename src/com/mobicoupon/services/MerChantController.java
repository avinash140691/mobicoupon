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

import com.mobicoupon.bean.DdmBean;
import com.mobicoupon.bean.MerchantAddBean;
import com.mobicoupon.bean.MerchantBean4Edit;
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
	public String addMerchnat(@ModelAttribute("addForm") @Valid MerchantAddBean merchantBean ,
			BindingResult result,RedirectAttributes rtAttributes){
		
		
		if(result.hasErrors()){
			
			List<FieldError> fieldErrors = result.getFieldErrors(); 
			rtAttributes.addFlashAttribute("addFormErrors", fieldErrors);
			return "redirect:/admin/add";
		}
		
		String corporateEmailId = merchantBean.getCorporateEmailId(); 
		String landLine = merchantBean.getLandLine();  
		String mobile = merchantBean.getMobile();
		String personalContactNum = merchantBean.getPersonalContactNum();
	  	boolean isError = false;
	  	
		int emailView = merchantDao.emailView(corporateEmailId);  
		if(emailView >= 1){
			isError = true;
			rtAttributes.addFlashAttribute("emailError", "Choose another email Id " + corporateEmailId  +" already exist");
		}
		
		int landLineView = merchantDao.landlLineView(landLine);  
		if(landLineView >= 1){
			isError = true;
			rtAttributes.addFlashAttribute("landLineError", "Choose another Phone num "+ landLine +" already exist");
		}
		
		int mobileView = merchantDao.mobileView(mobile);   
		if(mobileView >= 1){
			isError = true;
			rtAttributes.addFlashAttribute("mobileError", "Choose another Phone num "+mobile +" already exist");
		}
		
		int personalContactView = merchantDao.personalContactView(personalContactNum); 
		if(personalContactView >= 1){
			isError = true;
			rtAttributes.addFlashAttribute("pContactError", "Choose another Phone num "+ personalContactNum  +" already exist");
		}
		
		if(isError)
			return "redirect:/admin/add";
		
		int addMerchant = merchantDao.addMerchant(merchantBean);
		
		if(addMerchant < 0){
			
			rtAttributes.addFlashAttribute("addError", "Not Stored in DataBase");
			return "redirect:/admin/partOfView";
		}
		
		
		return "redirect:/admin/partOfView";
		
	}
	
	@RequestMapping(value = "/admin/updateMerchant" , method = RequestMethod.POST)
	public String updateMerchnat(@ModelAttribute("updateForm") @Valid MerchantBean4Edit merchantBean , BindingResult result, Model model
			, RedirectAttributes rtAttributes){
		
		String merchantId = merchantBean.getMerchantId();
		
		if(result.hasErrors()){
			
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			List<DdmBean> viewMerchant = merchantDao.viewMerchant(merchantId);  
			List<DepartmentBean> departments = departmentDao.getDepartments();  
			List<DesignationBean> viewDesignations = designationDao.viewDesignations();
			
			model.addAttribute("viewMerchant",viewMerchant);
			model.addAttribute("departments",departments);
			model.addAttribute("viewDesignations", viewDesignations);
			model.addAttribute("updateFormErrors", fieldErrors);
			
			return "merchantEdit";
		}
		  
		String merchantId2 = merchantBean.getMerchantId();  
		String landLine = merchantBean.getLandLine();  
		String mobile = merchantBean.getMobile();      
		String corporateEmailId = merchantBean.getCorporateEmailId();  
		String personalContactNum = merchantBean.getPersonalContactNum();  
		boolean isError =false;
		
		int emailView = merchantDao.emailUpdateView(merchantId2, corporateEmailId);  
		if(emailView >= 1){
			isError = true;
			model.addAttribute("emailError", "Choose another email Id " + corporateEmailId  +" already exist");
		}
		
		int landLineView = merchantDao.landLineUpdateView(merchantId2, landLine);  
		if(landLineView >= 1){
			isError = true;
			model.addAttribute("landLineError", "Choose another Phone num "+ landLine +" already exist");
		}
		
		int mobileView = merchantDao.mobileUpdateView(merchantId2, mobile);   
		if(mobileView >= 1){
			isError = true;
			model.addAttribute("mobileError", "Choose another Phone num "+mobile +" already exist");
		}
		
		int personalContactView = merchantDao.personalContactUpdateView(merchantId2, personalContactNum); 
		if(personalContactView >= 1){
			isError = true;
			model.addAttribute("pContactError", "Choose another Phone num "+ personalContactNum  +" already exist");
		}
		
		if(isError){
			
			List<DdmBean> viewMerchant = merchantDao.viewMerchant(merchantId);  
			List<DepartmentBean> departments = departmentDao.getDepartments();  
			List<DesignationBean> viewDesignations = designationDao.viewDesignations();
			
			model.addAttribute("viewMerchant",viewMerchant);
			model.addAttribute("departments",departments);
			model.addAttribute("viewDesignations", viewDesignations);
			
			return "merchantEdit";
		}
		
		int editMerchant = merchantDao.editMerchant(merchantBean); 
		
		if(editMerchant > 0){
			
			rtAttributes.addAttribute("merchantId",merchantId);
			return "redirect:/admin/viewMerchant";
		}
		
		
		
		List<DdmBean> viewMerchant = merchantDao.viewMerchant(merchantId);  
		List<DepartmentBean> departments = departmentDao.getDepartments();  
		List<DesignationBean> viewDesignations = designationDao.viewDesignations();
		
		model.addAttribute("viewMerchant",viewMerchant);
		model.addAttribute("departments",departments);
		model.addAttribute("viewDesignations", viewDesignations);
		return "merchantEdit";
	}
	
	
	@RequestMapping(value = "/admin/viewMerchant" , method = RequestMethod.GET)
	public String viewMerChant(@RequestParam("merchantId") String merchantId,Model model,RedirectAttributes rtAttribute){
		
		if(merchantId == ""){
			
			rtAttribute.addFlashAttribute("error", "Enter MerchantId");
			return "redirect:/admin/partOfView";
		}
		
		List<DdmBean> viewMerchant = merchantDao.viewMerchant(merchantId); 
		
		if(viewMerchant.isEmpty()){
			
			model.addAttribute("list", viewMerchant);
			
			return "viewMerchant";
		}
		
		model.addAttribute("viewMerchant",viewMerchant);
		
		return "viewMerchant";
	}
	
	@RequestMapping(value = "/admin/deleteMerchant" , method = RequestMethod.GET)
	public String deleteMerchant(@RequestParam("merchantId") String merchantId , Model model){
		
		if(merchantId == ""){
 			
			model.addAttribute("deleteErrors", "Enter MerchantID");
			return "redirect:/admin/partOfView";
		}
		
		int deleteMerchant = merchantDao.deleteMerchant(merchantId);
		
		if(deleteMerchant < 0){
			
			model.addAttribute("deleteErrors", "NOT FUND");
			return "redirect:/admin/partOfView";
		}
		
		return "redirect:/admin/partOfView";
		
	}
	
	@RequestMapping(value="/admin/partOfView" , method = RequestMethod.GET)
	public String partOfView(Model model){
		
		List<MerchantBean4Edit> partOfView = merchantDao.PartOfView();
		
		if(partOfView.isEmpty()){
			
			model.addAttribute("partViewError", "No List Fund");
			return "partOfView";
		}
		model.addAttribute("partOfView", partOfView);
		return "partOfView";
	}

	
	@RequestMapping(value="/admin/editMerchant" , method = RequestMethod.GET)
	public String editMerchant(@RequestParam("merchantId") String merchantId ,Model model,RedirectAttributes rtAttributes){
		
		List<DdmBean> viewMerchant = merchantDao.viewMerchant(merchantId);  
		List<DepartmentBean> departments = departmentDao.getDepartments();  
		List<DesignationBean> viewDesignations = designationDao.viewDesignations();  
		
		if(viewMerchant.size() == 0){
			rtAttributes.addFlashAttribute("editError", "NO list Fund");
			return "redirect:/admin/addMerchant";
		}
		
		model.addAttribute("viewMerchant",viewMerchant);
		model.addAttribute("departments",departments);
		model.addAttribute("viewDesignations", viewDesignations);
		
		return "merchantEdit";
	}
	
	@RequestMapping(value="/admin/add" , method = RequestMethod.GET)
	public String add(Model model){
		
		List<DepartmentBean> departments = departmentDao.getDepartments();
		List<DesignationBean> viewDesignations = designationDao.viewDesignations();
		  
		
		if(departments.isEmpty()){
			
			return "redirect:/admin/department";
			
		}
		
		if (viewDesignations.isEmpty()) {
			
			return "redirect:/admin/designation";
		}
		
		model.addAttribute("desgList", viewDesignations);
		model.addAttribute("deptList", departments);
		
		return "merchantAdd";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/merchant/xml/view" , method = RequestMethod.GET,produces = "application/xml")
	public String viewOfXmlView(Model model){
		
		List<MerchantBean4Edit> partOfView = merchantDao.viewMerchant();
		
		String xml = "<merchants>";
		
		for (MerchantBean4Edit merchantBean4Edit : partOfView) {  
			xml += merchantBean4Edit;
		}
		
		xml += "</merchants>";
		
		return xml; 
		
	}
}
