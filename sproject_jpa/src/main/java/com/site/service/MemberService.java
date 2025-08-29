package com.site.service;

import org.springframework.stereotype.Service;

import com.site.dto.Member;

@Service
public interface MemberService {

	Member findById(String id);

	Member findByIdAndPw(String id, String pw);

}
