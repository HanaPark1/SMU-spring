package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {

	// 게시글 목록
	List<Board> findAll();

	//게시글 저장
	void save(Board b);

	Board findByBno(int bno);

	// 게시글 삭제
	void delete(int bno);

	void update(Board b);

}
