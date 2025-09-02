package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.Board;
import com.site.dto.Member;
import com.site.service.CustomerService;
import com.site.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("customer/list")
	public String list(Model model) {
		//List<Board> controller > service > serviceImpl > jpa
		List<Board> list = customerService.findAll();
		model.addAttribute("list",list);
		return "customer/list";
	}
	
	@GetMapping("customer/view") // 상세페이지 열기
	public String view(Board b, Model model) {
		System.out.println(b.getBno());
		Board board = customerService.findByBno(b.getBno());
		
		System.out.println("하단댓글 개수: "+board.getReply().size());
		model.addAttribute("board",board);
		model.addAttribute("replyCount",board.getReply().size());
		return "customer/view";
	}
	
	@GetMapping("customer/delete")
	public String delete(Board b, RedirectAttributes redirect, Model model) {
		//List<Board> controller > service > serviceImpl > jpa
		
		// 섹션이 null이 아닐 때 삭제 가능
		if(session.getAttribute("session_id") != null) {
			// session_id 삭제하려는 게시글 id와 같은지 비교
			customerService.deleteById(b.getBno());
			redirect.addFlashAttribute("flag","-1");
			return "redirect:/customer/list";
		} else {
			System.out.println("제대로 된 삭제 URL이 아님.");
			return "customer/view";
		}
	}
	
	@GetMapping("customer/write")
	public String write() {
		return "customer/write";
	}
	
	@PostMapping("customer/write")
	public String write(
			Board b,
			RedirectAttributes redirect
			) {
		String id = (String) session.getAttribute("session_id");
		Member member = memberService.findById(id);
		b.setMember(member);
		customerService.save(b);
		redirect.addFlashAttribute("flag","1");
		return "redirect:/customer/list";
	}
}
