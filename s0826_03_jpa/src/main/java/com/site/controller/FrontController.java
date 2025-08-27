package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController Json 데이터를 리턴
public class FrontController {
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
