package com.springsecurity.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BasicController 
{
 
	@GetMapping("/home")
	public String getmsg()
	{
		return("Home Page");
	}
	
	
	@GetMapping("/admin/home")
	public String getmsg2()
	{
		return("Admin Home Page");
	}
	
	
	@GetMapping("/user/home")
	public String getmsg1()
	{
		return("User Home Page");
	}

	
	
}
