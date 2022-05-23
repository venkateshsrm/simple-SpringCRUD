package com.venkat.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.venkat.Config.AppConfig;
import com.venkat.DAO.UserDAOImpl;
import com.venkat.model.Users;

@Controller
public class SiteController {
	

	@RequestMapping("/")
	public ModelAndView Home() {
		ModelAndView modelandview = new ModelAndView("listUser");
		List<Users> user = new ArrayList<Users>();
		 AnnotationConfigApplicationContext context 
		= new  AnnotationConfigApplicationContext(AppConfig.class);
		UserDAOImpl userdao = context.getBean("DAOBean",UserDAOImpl.class);
		user = userdao.listUsers();
		modelandview.addObject("user",user);
		context.close();
		
	return modelandview;
	
	
	}
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("user")  @Valid Users user, BindingResult result) {
		ModelAndView model = new ModelAndView("addUser");
		model.addObject("user", user);
		if(result.hasErrors()) {
			return "addUser";
		}else {
			if(user.getName()!=null && user.getEmail()!=null && user.getDesignation()!=null){
				AnnotationConfigApplicationContext context 
				= new  AnnotationConfigApplicationContext(AppConfig.class);
				UserDAOImpl userdao = context.getBean("DAOBean",UserDAOImpl.class);
				userdao.addUser(user);
				System.out.println("row added success!");
				return "forward:/";
		
		}else { 
			System.out.println("loading form");
			return "addUser";
		}
		}
	}
	
	@RequestMapping("/edit")
	public ModelAndView updateForm(@ModelAttribute("updateuser") @Valid Users updateuser) {
		ModelAndView model = new ModelAndView("updateUser");
		model.addObject("updateuser", updateuser);
		return model;
		
	}
	@RequestMapping(value = "/update")
	public String updateUser(@ModelAttribute("updateuser") @Valid Users updateuser) {
		
		if(updateuser.getName()!=null && updateuser.getEmail()!=null && updateuser.getDesignation()!=null){
			AnnotationConfigApplicationContext context 
			= new  AnnotationConfigApplicationContext(AppConfig.class);
			UserDAOImpl userdao = context.getBean("DAOBean",UserDAOImpl.class);
			userdao.updateUser(updateuser);
			System.out.println("updated success!");
			return "forward:/";
	
	}else { 
		System.out.println("loading form");
		return "updateUser";
	}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id) {
		
			AnnotationConfigApplicationContext context 
			= new  AnnotationConfigApplicationContext(AppConfig.class);
			UserDAOImpl userdao = context.getBean("DAOBean",UserDAOImpl.class);
			userdao.deleteUser(id);
			System.out.println("deleted"+id);
			return "redirect:/";
		
	}
	
	
}
