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

import com.mobicoupon.dao.ProductDao;
import com.mobicoupon.dao.SubSubProductDao;
import com.mobicoupon.daoimpl.ProductBean;
import com.mobicoupon.daoimpl.SubSubProductBean;
import com.mobicoupon.daoimpl.SubSubSubProductBean4Add;

@Controller
public class AdminSubSubProductController {
	
	@Autowired
	public SubSubProductDao subSubProductDao;
	
	@Autowired
	public ProductDao productDao ;
	
	@RequestMapping(value=("/admin/addSubSubProduct") , method = RequestMethod.POST)
	public String addSubSubProduct(@ModelAttribute("addForm") @Valid SubSubSubProductBean4Add subSubProductBean , BindingResult result
			,RedirectAttributes rtAttributes){
		
		if(result.hasErrors()){
			List<FieldError> fieldErrors = result.getFieldErrors();
			rtAttributes.addFlashAttribute("addFormErrors", fieldErrors);
			return "redirect:/admin/viewSubSubProduct";
		}
		
		int addSubSubProduct = subSubProductDao.addSubSubProduct(subSubProductBean);
		
		if(addSubSubProduct < 0){
			rtAttributes.addFlashAttribute("addErrors","Not Stored In Data Base");
			return "redirect:/admin/viewSubSubProduct";
		}
		
		return "redirect:/admin/viewSubSubProduct";
		
	}
	
	@RequestMapping(value=("/admin/editSubSubProduct"), method = RequestMethod.POST)
	public String editSubSubProduct(@ModelAttribute("editForm") @Valid SubSubProductBean subSubProductBean ,BindingResult result
			,RedirectAttributes rtAttributes){
		
		
		if(result.hasErrors()){
			
			List<FieldError> fieldErrors = result.getFieldErrors(); 
			rtAttributes.addFlashAttribute("editFormErrors",fieldErrors);
			return "redirect:/admin/viewSubSubProduct";
		}
		
		int editSubSubProduct = subSubProductDao.editSubSubProduct(subSubProductBean);  
		
		if(editSubSubProduct > 0){
			return "redirect:/admin/viewSubSubProduct";
		}
		
		rtAttributes.addFlashAttribute("editErrors", "Not Updated");
		return "redirect:/admin/viewSubSubProduct";
	}

	@RequestMapping(value=("/admin/viewSubSubProduct") , method = RequestMethod.GET)
	public String viewSubSubProduct(Model model){
		
		List<SubSubProductBean> viewSubSubProduct = subSubProductDao.viewSubSubProduct();
		List<ProductBean> viewProducts = productDao.viewProduct();
		
		if(viewSubSubProduct.isEmpty()){
			model.addAttribute("viewErorrs","NOT FUND");
			model.addAttribute("viewProducts" ,viewProducts );
			return "viewSubSubProduct";
		}
		model.addAttribute("viewProducts" ,viewProducts );
		model.addAttribute("viewList", viewSubSubProduct);
		return "viewSubSubProduct";
	}

	@RequestMapping(value=("/admin/deleteSubSubProduct") , method = RequestMethod.GET)
	public String deleteSubSubProduct(@RequestParam("subSubProductId") String subSubProductId ,
			RedirectAttributes model){
		
		if(subSubProductId == ""){
			model.addFlashAttribute("deleteErrors", "Enter subSubProductId");
			return "redirect:/admin/viewSubSubProduct";
		}
		
		subSubProductDao.deleteSubSubProduct(subSubProductId);  
		
		return "redirect:/admin/viewSubSubProduct";
	}
	
	@ResponseBody
	@RequestMapping(value=("/admin/subSubProduct/xml/view") , method = RequestMethod.GET , produces = "application/xml")
	public String xmlViewSubSubProduct(Model model){
		
		List<SubSubProductBean> viewSubSubProduct = subSubProductDao.viewSubSubProduct();
		String xml = "<SubSubProducts>" ;
		
		for (SubSubProductBean subSubProductBean : viewSubSubProduct) {
				xml += subSubProductBean;
		}
		xml += "</SubSubProducts>";						
		
		return xml;
	}

}
