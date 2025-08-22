package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {
	List<Board> findAll();

	// 게시글 한개
	Board findByBno(int bno);

	// 게시글 저장
	void save(Board board);

}
