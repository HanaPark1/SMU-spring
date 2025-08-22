package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id pw:"+id+pw);
		
		// jsp 페이지로 데이터 전송방법
		
		model.addAttribute(id);
		model.addAttribute(pw);
		
		return "member/doLogin";
	}
	
	@PostMapping("/member")
	public String memeber(
			@RequestParam(name="id", defaultValue="aaa") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("gender") String gender,
			Model model) {
		return "/member/memberResult";
		
	}
	
	

}
