package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {
	//dto, controller -> service -> serviceImpl -> dao -> xml
	
	@Autowired BService bService;
	
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
		System.out.println("작성자: "+b.getId());
		System.out.println("파일: "+b.getBfile());
		bService.save(b);
		return "redirect:/bList?flag=1";
	}
	
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
		bService.delete(bno);
		return "redirect:/bList?flag=2"; // 2: 삭제
	}

}
