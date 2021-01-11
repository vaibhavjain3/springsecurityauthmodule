package com.accolite.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home() {
		return "index";
	}
}
