package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.site.dto.Stu;

@Controller
public class StuController {
	
	@GetMapping("/stu/stu")
	public String stu() {
		return "/stu/stuInput";
	}
	
	@PostMapping("/stu/stu")
	public String stu(Stu stu, Model model) {
		if(stu.getKor()==null) {
			stu.setKor(0);
		}
		stu.setTotal(stu.getKor()+stu.getEng()+stu.getMath());
		stu.setAvg(stu.getTotal() / 3);
		model.addAttribute("stu", stu);
		
		return "/stu/stuResult";
	}

}
