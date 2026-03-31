package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.model.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@GetMapping("/userform")
public String userLoginForm() {
	return "loginpage";
}
	@GetMapping("/submit")
	public String userSubmitForm(HttpServletRequest request,User user,Model model) {
		String usr=request.getParameter("user");
		String pas=request.getParameter("pwd");
		user.setUsername(usr);
		user.setPassword(pas);
		model.addAttribute("data",user);
		if(usr.equals(user.getUsername())&&pas.equals(user.getPassword())) {
			return "success";
		}
		else {
			return "loginpage";
		}
	}
}
