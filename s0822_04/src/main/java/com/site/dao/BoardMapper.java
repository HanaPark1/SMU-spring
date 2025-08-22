package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Board;

@Mapper
public interface BoardMapper {
	// 게시글 목록
		List<Board> findAll();

		void save(Board b);

		Board findByBno(int bno);

		void delete(int bno);

}
