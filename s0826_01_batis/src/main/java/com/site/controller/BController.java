package com.site.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.dto.Board;
import com.site.service.BService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BController {
	@Autowired BService bService;
	@Autowired HttpSession session;
	
	@GetMapping("/bList")
	public String bList(
			@RequestParam(name="page", defaultValue = "1") int page,
			Model model) {
		System.out.println("page: " + page);
		Map<String, Object> map = bService.findAll(page);
		model.addAttribute("map",map);
		return "bList";
	}

}
