package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Member;
import com.site.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberRepository memberRepository;

	@Override
	public Member findById(String id) {
		// get - 에러발생. 처리 안함, orElseGet - 에러 시 빈객체를 리턴 return new Member(); , orElseThrow - 예외처리시 예외코드를 리턴 return new IllegalArgumentException()
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
	public void save(Member m) {
		memberRepository.save(m);
		
	}

	@Override
	public List<Member> findAll() {
		List<Member> list = memberRepository.findAll();
		return list;
	}

//	@Override // 임의로 이름변경
//	public Member findLogin(String id, String pw) {
//		Member member = memberRepository.findLogin(id, pw);
//		return member;
//	}

}
