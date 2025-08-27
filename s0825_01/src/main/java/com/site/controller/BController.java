package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BController {
	
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("/bList")
	public String bList(Model model) {
		//게시글 여러개 list 게시글 한개 board
		//dto, controller -> service -> serviceImpl -> dao -> xml
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);
		
		return "bList";
	}
	
	@GetMapping("/bWrite")
	public String bWrite() {
		return "bWrite";
	}
	
	@PostMapping("/bWrite")
	public String bWrite(Board b, Model model) {
		System.out.println("제목: "+b.getBtitle());
		System.out.println("내용: "+b.getBcontent());
		System.out.println("아이디: "+b.getId());
		System.out.println("파일이미지: "+b.getBfile());
		// controller -> service -> serviceImpl -> dao -> xml
		// 리턴 x, 매개변수 board 전송
		bService.save(b);
		return "redirect:/bList?flag=1";
	}
	
	//게시글 상세보기
	@GetMapping("/bView")
	public String bView(Board b, Model model) {
		int bno = b.getBno();
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bView";
	}
	
	@GetMapping("/bDelete")
	public String bDelete(
			@RequestParam(name="bno", defaultValue="0") int bno
			) {
		System.out.println("bno: "+bno);
		bService.delete(bno);
		return "redirect:/bList?flag=2"; // 2: 삭제
	}
	
	//게시글 수정
	@GetMapping("/bUpdate/{bno}")
	public String bUpdate(@PathVariable("bno") int bno, Model model) {
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bUpdate";
	}
	
	//게시글 수정
	@PostMapping("/bUpdate")
	public String bUpdate(Board b, Model model) {
		bService.update(b);
		return "redirect:/bList?flag=2";
	}
	
	
	

}
