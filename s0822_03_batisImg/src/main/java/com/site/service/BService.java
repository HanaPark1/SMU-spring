package com.site.service;

import java.util.List;

import com.site.dto.Board;

public interface BService {

	// 게시글 목록
	List<Board> findAll();

	void save(Board b);

	Board findByBno(int bno);

	void delete(int bno);

}
