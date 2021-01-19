package com.accolite.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CustomController {
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}
}
