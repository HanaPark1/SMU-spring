package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.Member;
import com.site.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login") // 로그인 확인
	public String login(RedirectAttributes redirect,
			HttpServletRequest request,
			Member m) {
		String redirectUrl;
		Member member = memberService.findByIdAndPw(m.getId(), m.getPw());
		
		if(member == null) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			redirect.addFlashAttribute("flag", "-1");
			redirectUrl = "redirect:/member/login";
		} else {
			System.out.println("로그인되었습니다");
			session.setAttribute("session_id", member.getId());
			session.setAttribute("session_name", member.getName());
			redirect.addFlashAttribute("flag", "1");
			redirectUrl = "redirect:/";
		}
		return redirectUrl;
	}
	
	@GetMapping("/member/logout")
	public String logout(RedirectAttributes redirect) {
		session.invalidate();
		redirect.addFlashAttribute("flag","-1");
		return "redirect:/";
	}

}
