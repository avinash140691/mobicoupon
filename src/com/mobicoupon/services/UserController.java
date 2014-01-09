package com.mobicoupon.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homePage(){
		return "userpanel";
		
	}
}
