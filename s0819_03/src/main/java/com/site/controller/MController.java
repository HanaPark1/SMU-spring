package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;

@Controller
public class MController {
	// 회원가입 페이지
	@GetMapping("/member/member")
	public String member() {
		return "member/memberInput";
	}
	
	// 객체전달방법
	//회원가입 저장
	@PostMapping("/member/member")
	public String member(
			Member member,
			Model model) {
		
		model.addAttribute("member",member);
//		model.addAttribute("id", member.getId());
//		model.addAttribute("pw", member.getPw());
//		model.addAttribute("name", member.getName());
//		model.addAttribute("phone", member.getPhone());
//		model.addAttribute("gender", member.getGender());
		
		return "member/memberResult";
	}
}
