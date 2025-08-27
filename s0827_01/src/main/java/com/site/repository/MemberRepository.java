package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.site.dto.Member;

// <Member, String> : 리턴 객체, 객체 기본키타입
// select-find(), insert-save(), update-update(), delete-delete() 기본 메소드 정의
//@Repository 생략 가능
public interface MemberRepository extends JpaRepository<Member, String> {

	// 로그인 확인(id,pw) - select할때 데이터가 찾아지면 Member 객체 리턴
	// select 할때 데이터가 없으면 Optional
	// select * from member where id = #{id} and pw=#{pw}
	
	//// select * from member where id = #{id} or pw=#{pw}
	//Optional<Member> findByIdOrPw(String id, String pw);
	Optional<Member> findByIdAndPw(String id, String pw);


	

}
