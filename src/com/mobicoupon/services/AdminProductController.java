package com.mobicoupon.services;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobicoupon.dao.ProductDao;
import com.mobicoupon.daoimpl.ProductBean;

@Controller
public class AdminProductController {
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/admin/addProduct" , method = RequestMethod.GET)
	public String addProduct(@RequestParam("productName") String productName ,RedirectAttributes rtAttributes ){
		
		if(productName == ""){
			String error1 = "ENTER PRODUCT NAME";
			rtAttributes.addFlashAttribute("addErrorMsg", error1);
			return "redirect:/admin/viewProduct";
		}
		
		
		int addProduct = productDao.addProduct(productName);
		if(addProduct < 0){
			String error1 = "Not inserted into DataBase";
			rtAttributes.addFlashAttribute("addErrorMsg", error1);
		}
		
		return "redirect:/admin/viewProduct";
	}
	
	@RequestMapping(value="/admin/editProduct" , method = RequestMethod.GET)
	public String editProduct(@RequestParam("productId") String productId,
			@RequestParam("productName") String productName ,RedirectAttributes rtAttributes ){
		
		if(productId.trim().equals("") || productName.trim().equals("") ){
			
			String error = "enter proper productId and productName";
			rtAttributes.addFlashAttribute("editErrorMsg", error);
			return "redirect:/admin/viewProduct";
		}
		
		int count = productDao.editProduct(productName, productId);
		if(count < 0){
			
			String error = "not updated succesfully";
			rtAttributes.addFlashAttribute("editErrorMsg", error);
			return "redirect:/admin/viewProduct";
		}
		return "redirect:/admin/viewProduct";
	}
	
	@RequestMapping(value="/admin/deleteProduct" , method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("productId") String productId,RedirectAttributes rtAttribute){
		
		if(productId.trim().equals("")){
			
			String  mesg = "Eneter ProductId Properly";
			
			rtAttribute.addFlashAttribute("message", mesg);
			return "redirect:/admin/viewProduct";
		}
		
		int count = productDao.deleteProduct(productId);
		if(count > 0){
			
			return "redirect:/admin/viewProduct";
		}
		
		String mesg = "Not Deleted ";
		rtAttribute.addFlashAttribute("mesg", mesg);
		return "redirect:admin/viewProduct";
	}
	
	@RequestMapping(value="/admin/viewProduct", method = RequestMethod.GET)
	public String viewProduct(Model model){
		List<ProductBean> list = productDao.viewProduct();
		model.addAttribute("list", list);
		return "viewProduct";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/Product/xml/view", method = RequestMethod.GET , produces = "application/xml")
	public String viewXMLProduct(Model model){
		
		List<ProductBean> list = productDao.viewProduct();
		String xml = "<Products>";
		
		for (ProductBean productBean : list) {
			xml += productBean;
		}
		xml += "</Products>";
		
		return xml;
	}
}
