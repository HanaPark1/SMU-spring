package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Board;
import com.site.service.BService;

@Controller
public class BController {
	@Autowired BService bService;
	
	@GetMapping("/bList")
	public String bList() {
		return "bList";
	}
	
	@GetMapping("/bWrite")
	public String bWrite() {
		return "bWrite";
	}
	
	@PostMapping("/bWrite")
	public String bWrite(Board b) {
		List<Board> list = bService.findAll();
		
		return "bWrite";
	}


}
