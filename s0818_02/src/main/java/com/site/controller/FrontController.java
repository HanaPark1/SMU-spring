package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.service.MService;
import com.site.service.MServiceImpl;
import com.site.service.MServiceImpl2;

@Controller //  컨트롤러로 지정 (객체선언 자동으로 됨) - jsp, html 페이지를 오픈
public class FrontController {
	
	MServiceImpl mServiceImpl = new MServiceImpl();
	@Autowired MService mService;
	
	@GetMapping("/")
	public String index() {
		String name = mService.select();
		System.out.println("이름: "+name);
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@PostMapping("/doLogin")
	public String doLogin() {
		return "doLogin";
	}
	
//	@RequestMapping("/doLogin") get post 둘 다 가능
//	public String doLogin() {
//		return "doLogin";
//	}

}
