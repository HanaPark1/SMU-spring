package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.dto.Board;
import com.site.service.BoardService;

@Controller
public class CustomerController {
	@Autowired BoardService boardService;
	
	@GetMapping("customer/list")
	public String list(Model model) {
		
		List<Board> list = boardService.findAll();
		model.addAttribute("list", list);
		return "customer/list";
	}

}
