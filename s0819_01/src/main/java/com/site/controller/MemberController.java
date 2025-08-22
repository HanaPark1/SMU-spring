package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

//@RestController // 데이터 (String, data... etc)로 전달
@Controller
public class MemberController {
	
	public String login() {
		return "member/login";
	}

}
