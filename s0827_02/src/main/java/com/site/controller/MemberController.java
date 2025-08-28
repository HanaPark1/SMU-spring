package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.Member;
import com.site.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String login(Model model, Member m, RedirectAttributes redirect) {
		String url;
		String id = m.getId();
		String pw = m.getPw();
		
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		
//		Member member = memberService.findById(id);
		Member member = memberService.findByIdAndPw(id, pw);
		if(member.getId() == null) {
			System.out.println("아이디 또는 패스워드가 없습니다.");
			redirect.addFlashAttribute("flag","-1"); // redirect시 변수전달가능
			url = "redirect:/member/login";
		} else {
			System.out.println("로그인");
			session.setAttribute("session_id", member.getId());
			session.setAttribute("session_name", member.getName());
			redirect.addFlashAttribute("flag","1"); // redirect시 변수전달가능
			url = "redirect:/";
		}
		System.out.println("member: "+member);
		
		// id,pw가 있는지 확인 - findByIdAndPw() // 생성
		return url;
	}
	
	@GetMapping("/member/logout")
	public String logout(RedirectAttributes redirect) {
		session.invalidate();
		redirect.addFlashAttribute("flag", "-1");
		return "redirect:/";
	}
	
	@GetMapping("/member/insert01")
	public String insert01() {
		return "member/insert01";
	}
	
	@GetMapping("/member/insert02")
	public String insert02() {
		return "member/insert02";
	}
	
	@ResponseBody // ajax 사용 시 import
	@PostMapping("/member/idBtn")
	public String idBtn(Member m) {
		String id = m.getId();
		Member member = memberService.findById(id);
		String flag = "";
		if(member.getId() == null) {
			flag = "1";
		} else {
			flag = "-1";
		}
		return flag;
	}
	
	@PostMapping("/member/insert02")
	public String insert02(
			@RequestParam("phone1") int phone1,
			@RequestParam("phone2") int phone2,
			@RequestParam("phone3") int phone3,
			Member m) {
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		m.setPhone(phone);
		memberService.save(m);
		return "member/insert02";
	}

}
