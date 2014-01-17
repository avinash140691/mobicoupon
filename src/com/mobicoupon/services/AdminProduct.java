package com.mobicoupon.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminProduct {
	
	@RequestMapping(value="/admin/product" , method= RequestMethod.GET)
	public String productAdd(){
		return "addproduct";
	}
}
