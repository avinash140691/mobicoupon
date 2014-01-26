package com.mobicoupon.services;

 
 

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobicoupon.dao.ProductDao;
import com.mobicoupon.dao.SubProductDao;
import com.mobicoupon.daoimpl.ProductBean;
import com.mobicoupon.daoimpl.SubProductBean;
import com.mobicoupon.daoimpl.SubProductBean4Edit;

@Controller
public class AdminSubProductController {
	
	@Autowired
	SubProductDao subProductDao;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value=("/admin/addSubProduct"),method = RequestMethod.POST)
	public String addSubProduct(@ModelAttribute("addForm") @Valid SubProductBean subProductBean , BindingResult result
			,RedirectAttributes rtAttributes){
		
		if(result.hasErrors()){
			rtAttributes.addFlashAttribute("addFormError", result.getFieldErrors());
			return "redirect:/admin/viewSubProduct";
		}
		
		int addSubProduct = subProductDao.addSubProduct(subProductBean);
		
		if(addSubProduct>0){
			return "redirect:/admin/viewSubProduct";
		}
		rtAttributes.addFlashAttribute("addError","NOT INSERTED");
		return "redirect:/admin/viewSubProducts";
	}
	
	@RequestMapping(value=("/admin/editSubProduct"),method = RequestMethod.POST)
	public String editSubProduct(@ModelAttribute("editForm") @Valid SubProductBean4Edit subProductBean ,BindingResult result
			,RedirectAttributes rtAttributes){
		
		if(result.hasErrors()){
			rtAttributes.addFlashAttribute("editFormErrors", result.getFieldErrors());
			return "redirect:/admin/viewSubProduct";
		}
		
		int editSubProduct = subProductDao.editSubProduct(subProductBean);
		
		if(editSubProduct>0){
			return "redirect:/admin/viewSubProduct";
		}
		rtAttributes.addFlashAttribute("editError", "Not Updated Successfully");
		return "redirect:/admin/viewSubProduct";
	}
	
	@RequestMapping(value=("/admin/deleteSubProduct"),method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("subProductId") String subProductId ,RedirectAttributes rtAttributes){
		
		if(subProductId==""){
			rtAttributes.addFlashAttribute("deleteErrorMsg", "Enter SubProductID");
			return "redirect:/admin/viewSubProduct";
		}
		
		int deleteSubProduct = subProductDao.deleteSubProduct(subProductId);
		
		if(deleteSubProduct>0){
			return "redirect:/admin/viewSubProduct";
		}
		rtAttributes.addFlashAttribute("deleteErrorMsg", "NOT FUND");
		return "redirect:/admin/viewSubProduct";
	}
	
	@RequestMapping(value=("/admin/viewSubProduct") ,method = RequestMethod.GET)
	public String viewSubProduct(Model model){
		
		List<SubProductBean> list = subProductDao.viewSubProduct();
		List<ProductBean> viewProduct = productDao.viewProduct();
		
		if(list.isEmpty()){
			model.addAttribute("viewSubProduct", "not fund" );
			model.addAttribute("viewProduct", viewProduct);
			return "viewSubProduct";
		}
		
		model.addAttribute("viewProduct", viewProduct);
		model.addAttribute("list", list);
		return "viewSubProduct"; 
		
	}
	
	@ResponseBody
	@RequestMapping(value=("/admin/viewSelectSubProducts") ,method = RequestMethod.POST)
	public String viewSelectSubProducts(@RequestParam("productId") String productId, Model model){
		
		List<SubProductBean> list = subProductDao.viewSubProduct(productId);
		
		if(list.isEmpty()){
			return "<option>None</option>";
		}
		
		String data ="";
		
		for (SubProductBean subProductBean : list) {
			
			data += "<option value=\""+ subProductBean.getSubProductId() + "\">" + subProductBean.getSubProductName() + "</option>";
		}
		return data;
	}
	
}
