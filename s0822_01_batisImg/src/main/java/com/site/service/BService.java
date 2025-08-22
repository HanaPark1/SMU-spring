package com.site.service;

import java.util.List;

import com.site.dto.Board;

public interface BService {

	// 게시글 목록
	List<Board> findAll();

	// 게시글 한개
	Board findByBno(int bno);

	// 게시글 저장
	void save(Board board);

}
