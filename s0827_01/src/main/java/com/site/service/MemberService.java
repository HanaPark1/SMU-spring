package com.site.service;

import org.springframework.stereotype.Service;

import com.site.dto.Member;

@Service
public interface MemberService {

	// 아이디가 존재하는지 확인
	Member findById(String id);

	// 로그인 확인(id, pw)
	Member findByIdAndPw(String id, String pw);
	
//	// 임의로 이름변경(로그인확인)
//	Member findLogin(String id, String pw);

}
