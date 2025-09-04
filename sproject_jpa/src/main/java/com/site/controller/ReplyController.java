package com.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.site.dto.Board;
import com.site.dto.Member;
import com.site.dto.Reply;
import com.site.service.CustomerService;
import com.site.service.MemberService;
import com.site.service.ReplyService;

import jakarta.servlet.http.HttpSession;

//@Controller
@RestController
public class ReplyController {
	@Autowired MemberService memberService;
	@Autowired CustomerService customerService;
	@Autowired HttpSession session;
	@Autowired ReplyService replyService;
	
// Rest api (Ajax 사용하면 RestApi)
//	@GetMapping // select
//	@PostMapping // insert
//	@PutMapping // update
//	@DeleteMapping // delete
	
	@GetMapping("/reply/list")
	public String list() {
		return "성공: list를 전달할 예정";
	}
	
	@PostMapping("/reply/write")
	public Reply write(Reply r, 
			@RequestParam("id") String id,
			@RequestParam("bno") int bno
			) {
		System.out.println("rpw:" + r.getRpw());
		System.out.println("rcontent:" + r.getRcontent());
		System.out.println("id:" + id);
		System.out.println("bno:" + bno);
		Member member = memberService.findById(id);
		System.out.println("member:" + member);
		r.setMember(member);
		Board board = customerService.findByBno(bno);
		r.setBoard(board);
		
		// DB 저장 후 가져오기
		Reply reply = replyService.save(r);
		return reply; // 객체 리턴, 자동으로 Json 파싱: 무한루프 발생
	}
	
	@DeleteMapping("/reply/delete")
	public String delete(Reply r) {
		System.out.println("r : "+r.getRno());
		// DB삭제
		replyService.deleteById(r.getRno());
		
		return "success";
	}
	
	@PutMapping("/reply/confirm")
	public String confirm(Reply r) {
		Reply reply = replyService.findById(r.getRno());
		System.out.println("rno : "+r.getRno());
		System.out.println("rcontent : "+r.getRcontent());
	
		reply.setRcontent(r.getRcontent());
		
		// DB 수정
		reply = replyService.save(reply);
		
		return "success";
	}

}
