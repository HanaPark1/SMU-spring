package com.site.controller;

import java.net.http.HttpResponse;

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

import jakarta.servlet.http.HttpServletResponse;
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
	public String login(
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw
			HttpServletResponse response,
			RedirectAttributes redirect,
			Member m, Model model) {
		
		String url;
		String id = m.getId();
		String pw = m.getPw();
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		//jpa 로 전달 : controller -> service -> serviceImpl -> dao(Jpa)
//		Member member = memberService.findById(id); // 생성하지 않아도 찾아오기 가능
//		System.out.println("member: "+member);
		
		Member member = memberService.findByIdAndPw(id, pw);
//		Member member = memberService.findLogin(id, pw); 임의로 이름변경
		
		if(member.getId() == null) {
			System.out.println("아이디 또는 패스워드가 없습니다.");
			redirect.addFlashAttribute("flag","1"); // redirect시 변수전달가능
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
		return "redirect:/";
	}
	
	@GetMapping("/member/insert") // 회원가입 페이지 열기
	public String insert() {
		return "member/insert01";
	}
	
	@GetMapping("/member/insert02") //회원가입02 페이지열기
	public String insert02() {
		return "member/insert02";
	}
	//ajax -> json데이터 전송
	@ResponseBody
	@PostMapping("/member/idBtn") // 중복id확인
	public Member idBtn(Member m) {
		System.out.println("controller id : "+m.getId());
		// findById(m.getId) -> service,serviceImpl,repository
		Member member = memberService.findById(m.getId());
		
		String flag = "";
		if(member.getId() != null) {
			flag = "-1"; //아이디 사용불가
		}else {
			flag = "1";  // 아이디 사용가능
		}
		
		// json 방법 -> 직접 Json 형태로 가공해서 방법
		// 객체를 전송하면 자동으로 Json 형태로 변환되어 전송
		
		return member;
	}

}
