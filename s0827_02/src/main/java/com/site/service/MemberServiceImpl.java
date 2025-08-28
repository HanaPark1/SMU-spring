package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberRepository memberRepository;
	@Override
	public Member findById(String id) {
		Member member = memberRepository.findById(id).orElseGet(
				() -> {return new Member();}
				);
		return member;
	}
	@Override
	public Member findByIdAndPw(String id, String pw) {
		Member member = memberRepository.findByIdAndPw(id, pw).orElseGet(
				() -> {return new Member();}
				);
		return member;
	}
	
	@Override
	public Member findId(String id) {
		Member member = memberRepository.findId(id).get();
		return member;
	}
	@Override
	public void save(Member m) {
		memberRepository.save(m);
		
	}

}
