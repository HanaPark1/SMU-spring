package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Reply;
import com.site.repository.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired ReplyRepository replyRepository;

	// 하단 댓글 저장
	@Override
	public Reply save(Reply r) {
		Reply reply = replyRepository.save(r);
		return reply;
	}

}
