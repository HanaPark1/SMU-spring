package com.site.service;

import org.springframework.stereotype.Service;

import com.site.dto.Reply;

@Service
public interface ReplyService {

	// 하단 댓글 저장
	Reply save(Reply r);

	void deleteById(int rno);

	Reply findById(int rno);

}
