package com.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.dto.Member;

//<객체리턴타입,리턴객체>
public interface MemberRepository extends JpaRepository<Member,String> {

	Member findByIdAndPw(String id, String pw);

}
