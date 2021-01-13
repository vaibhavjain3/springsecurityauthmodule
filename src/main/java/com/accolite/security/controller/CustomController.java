package com.accolite.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CustomController {
	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView index = new ModelAndView("index");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = ((UserDetails) auth.getPrincipal()).getUsername();
		index.addObject("roles", auth.getAuthorities());
		index.addObject("username", username);
		return index;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView login = new ModelAndView("login");
		return login;
	}
}
