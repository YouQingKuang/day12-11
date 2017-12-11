package com.taiji.manager.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {
	
	@RequestMapping("login")
	public String test(Model medol) {
		return "login";
	}
	
	@GetMapping("/")
	public String toIndex(HttpServletRequest request) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();
		System.out.println(username+" "+ password);
		return "list";
	}
	
}
