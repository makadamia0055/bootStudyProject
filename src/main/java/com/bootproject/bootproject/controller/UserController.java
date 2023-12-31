package com.bootproject.bootproject.controller;


import com.bootproject.bootproject.root.dto.RegisterUserDTO;
import com.bootproject.bootproject.root.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/user")
public class UserController {
	private UserService loginService;
	
	@Autowired
	public UserController(UserService loginService) {
		this.loginService = loginService;
	}
	
	
	@GetMapping(path = "/login")
	public String getLogin(Model model) {
	    return "user/loginPage.html";
	}
//	@PostMapping(path="/login")
//	public String postLogin(LoginUserDTO userDto) {
//		if(loginService.checkUser(userDto)) {
//			return "redirect:/";
//		}
//		return "redirect:/";
//	}
	@PostMapping(path="/login")
	public String postLogin(HttpServletResponse response) {
		return "index.html";
	}
	
	
	@GetMapping(path="/register")
	public String getRegister(Model model) {
	    return "user/registerPage.html";
	}
	@PostMapping(path="/register")
	public String postRegister(RegisterUserDTO userDto) {
		if(loginService.insertUser(userDto)) {
//			UserVO checkUser = loginService.getUser(userDto);
			System.out.println(" 유저 가입 완료");
			return "redirect:/";
		}
		return "redirect:/";
	}
	
}
