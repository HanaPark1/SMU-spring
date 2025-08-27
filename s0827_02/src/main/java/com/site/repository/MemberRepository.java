package com.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.site.dto.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	Optional<Member> findByIdAndPw(String id, String pw);

	@Query(value = "select * from member where id=?",nativeQuery = true)
	Optional<Member> findId(String id);

}
