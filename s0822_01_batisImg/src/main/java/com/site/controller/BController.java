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
	@Autowired BService bService;
	
	@GetMapping("/board/bList")
	public String bList(
			@RequestParam(name="flag",defaultValue="0") String flag,
			Model model) {
		// controller -> service -> serviceImpl -> dao -> xml
		List<Board> list = bService.findAll();
		model.addAttribute("list",list);
		model.addAttribute("flag",flag);
		return "bList";
	}
	
	@GetMapping("/board/bView")
	public String bView(Board b, Model model) {
		// controller -> service -> serviceImpl -> dao -> xml
		int bno = b.getBno();
		Board board = bService.findByBno(bno);
		model.addAttribute("board",board);
		return "bView";
	}
	
	@GetMapping("/board/bWrite")
	public String bWrite() {
		return "bWrite";
	}
	
	@PostMapping("/board/bWrite")
	public String bWrite(Board board, Model model) {
		System.out.println("제목: "+board.getBtitle());
		System.out.println("내용: "+board.getBcontent());
		System.out.println("작성자: "+board.getId());
		System.out.println("파일: "+board.getBfile());
		
		bService.save(board);
		
		
		return "redirect:/board/bList?flag=1";
	}

}
