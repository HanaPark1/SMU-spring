package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Board;
import com.site.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardRepository boardRepository;

	@Override
	public List<Board> findAll() {
		List<Board> list = boardRepository.findAll();
		return list;
	}

}
