package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Member;
import com.site.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/member/login")
	public String login(Model model, Member m) {
		String id = m.getId();
		String pw = m.getPw();
		
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		
//		Member member = memberService.findById(id);
		Member member = memberService.findByIdAndPw(id, pw);
//		Member member = memberService.findId(id);
		System.out.println("member: "+member);
		return "member/login";
	}

}
