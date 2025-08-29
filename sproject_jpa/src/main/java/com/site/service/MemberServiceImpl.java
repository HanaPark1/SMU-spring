package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberRepository memberRepository;

//	@Override
//	public Member findById(String id) {
//		Member member = memberRepository.findById(id);
//		return member;
//	}

	@Override
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id, pw);
		return member;
	}

	@Override
	public Member findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
