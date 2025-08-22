package com.site.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.site.dto.Board;

@Service
public interface BService {

	List<Board> findAll();
	
	void save(Board b);

	Board findByBno(int bno);

	void delete(int bno);

}
