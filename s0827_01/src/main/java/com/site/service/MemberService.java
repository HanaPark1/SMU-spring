package com.site.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.site.dto.Member;

@Service
public interface MemberService {

	//findBy 메소드
	// 아이디가 존재하는지 확인
	Member findById(String id);

	// 로그인 확인(id, pw)
	Member findByIdAndPw(String id, String pw);

	// save 메소드
	// 회원정보저장
	void save(Member m);

	// findAll 메소드
	// 회원 전체 리스트
	List<Member> findAll();
	
//	// 임의로 이름변경(로그인확인)
//	Member findLogin(String id, String pw);

}
