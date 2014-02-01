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

import com.mobicoupon.bean.UserBean;
import com.mobicoupon.bean.UserEditBean;
import com.mobicoupon.dao.UserDao;

@Controller
public class UserController {
	
	@Autowired
	public UserDao userDao;
	
	@RequestMapping(value="/admin/addUser" , method = RequestMethod.POST)
	 public String addUser(@ModelAttribute("addForm") @Valid UserBean userBean , BindingResult result
			 ,RedirectAttributes rtAttributes){
		
		if(result.hasErrors()){
			
			List<FieldError> fieldErrors = result.getFieldErrors(); 
			rtAttributes.addFlashAttribute("addFormErrors", fieldErrors);
			return "redirect:/admin/userView";
		}
		
		userDao.add(userBean);
		
		return "redirect:/admin/userView";
		
	}
	
	@RequestMapping(value="/admin/updateUser" , method = RequestMethod.POST)
	public String update(@ModelAttribute("updateForm") @Valid UserEditBean  userEditBean ,BindingResult result
			,RedirectAttributes model ){
		
		if(result.hasErrors()){
			
			List<FieldError> fieldErrors = result.getFieldErrors();
			String id = userEditBean.getId();
			List<UserEditBean> view = userDao.view(id); 
			model.addFlashAttribute("oneUserView", view);
			model.addFlashAttribute("updateFormErrors", fieldErrors);
			return "redirect:/admin/userView";
		}
		userDao.update(userEditBean);
		return "redirect:/admin/userView";
	}
	
	@RequestMapping(value="/admin/userView" , method = RequestMethod.GET)
	public String view(Model model){
		
		List<UserEditBean> view = userDao.view();
		
		if(view.isEmpty()){
			
			model.addAttribute("viewList", "No list Fund");
			return "user";
		}
		
		model.addAttribute("list",view);

		return "user";
			
	}
	
	@RequestMapping(value="/admin/oneUserView" , method = RequestMethod.GET)
	public String view(@RequestParam("id") String id , Model model){
		
		if(id == ""){
			
			model.addAttribute("oneUserViewError","Enter User Id");
			return "user";
		}
		
		List<UserEditBean> view = userDao.view(id); 
		model.addAttribute("oneUserView", view);
		
		return "user";
		
	}
	
	@RequestMapping(value="/admin/deleteUser" , method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") String id , RedirectAttributes model){
		
		if(id == ""){
			
			model.addFlashAttribute("deleteError","ENTER USER ID");
			return "redirect:/admin/userView";
		}
		
		userDao.delete(id);
		return "redirect:/admin/userView";
		
	}
	
}
