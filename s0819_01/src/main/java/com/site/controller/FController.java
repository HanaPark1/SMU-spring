package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {
	//RequestMapping // get, post 둘
	//PostMapping // post
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
