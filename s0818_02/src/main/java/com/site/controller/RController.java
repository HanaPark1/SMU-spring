package com.site.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // String 문자열을 리턴(Ajax 통신 시)
public class RController {
	
	@GetMapping("/rest")
	public String restpage() {
		return "안녕하세요.";
	}
}
