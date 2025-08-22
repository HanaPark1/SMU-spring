package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Member;
import com.site.service.MService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MController {
	@Autowired MService mService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login") 
	public String login(@RequestParam(name="flag",required=false) String flag, Model model) {
		model.addAttribute("flag", flag);
		System.out.println("flag: "+flag);
		return "member/login";
	}
	@GetMapping("/member/mList")
	public String mList(Model model) {
		//service 연결, list-여러개, 객체-1개, 숫자
		List<Member> list = mService.findAll();
		model.addAttribute("list", list);
		return "member/mList";
	}
	
	@GetMapping("/member/mView")
	public String mView(
			@RequestParam(name="id", defaultValue="aaa") String id,
			Model model) {
		Member member = mService.findAndId(id);
		model.addAttribute("member", member);
		return "member/mView";
	}
	
	
	@PostMapping("/member/login") 
	public String login(
			Member member,
			Model model) {
		// id, pw 아이디, 패스워드 일치하는지 확인
		String id = member.getId();
		String pw = member.getPw();
		Member mem = mService.findByIdAndPw(id,pw);
		
		if(mem==null) {
			model.addAttribute("flah","-1");
			return "redirect/member/login/flag=-1";
		} else {
			System.out.println("로그인 성공");
			return "redirect:/?flag=1";
		}
	}
//	@GetMapping("/member/logout")
//	public String logout(Model model) {
////		session.in
//		
//	}
}
