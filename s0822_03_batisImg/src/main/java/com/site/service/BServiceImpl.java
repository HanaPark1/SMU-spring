package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.BoardMapper;
import com.site.dto.Board;

@Service
public class BServiceImpl implements BService {
	@Autowired BoardMapper boardMapper;

	//게시글 목록
	@Override
	public List<Board> findAll() {
		List<Board> list = boardMapper.findAll();
		return list;
	}

	@Override // 게시글 저장
	public void save(Board b) {
		boardMapper.save(b);
	}

	@Override // 게시물 상세조회
	public Board findByBno(int bno) {
		Board board =  boardMapper.findByBno(bno);
		return board;
	}

	@Override // 게시물 삭제
	public void delete(int bno) {
		boardMapper.delete(bno);
		
	}

}
