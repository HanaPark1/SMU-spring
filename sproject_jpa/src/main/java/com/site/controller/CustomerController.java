package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.site.dto.Board;
import com.site.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	@GetMapping("customer/list")
	public String list(Model model) {
		//List<Board> controller > service > serviceImpl > jpa
		List<Board> list = customerService.findAll();
		model.addAttribute("list",list);
		return "customer/list";
	}
 
}
