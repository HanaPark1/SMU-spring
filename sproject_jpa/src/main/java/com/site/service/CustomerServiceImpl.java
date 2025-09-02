package com.site.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.site.dto.Board;
import com.site.dto.Member;
import com.site.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;




@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired CustomerRepository customerRepository;
	//영속성 컨텍스트 - 시퀀스 파일
	@PersistenceContext private EntityManager entityManager; 

	@Override
	public List<Board> findAll() {
		List<Board> list = customerRepository.findAll();
		return list;
	}

	@Override
	public Board findByBno(int bno) {
		// .get():에러처리안함 .orElseGet():빈객체처리 .roElseThrow():예외처리
		Board board = customerRepository.findById(bno).orElseThrow(
		 () -> { 
			return new IllegalArgumentException("해당되는 게시글이 존재하지 않습니다."); 
		 }
		);
		
		return board;
	}

	@Override
	public void deleteById(int bno) {
		customerRepository.deleteById(bno);
		
	}

	@Transactional // 1번째부터 마지막까지 정상적으로 완료되어야 최종 DB에 저장시켜줌
	@Override //글쓰기 저장
	public void save(Board b) {
		entityManager.persist(b); // 1차캐쉬 - 임시적으로 파일저장
		System.out.println("시퀀스 bno:"+b.getBno());
		// bgroup - 시퀀스번호를 입력
		b.setBgroup(b.getBno()); 
		b.setBstep(0);
		b.setBindent(0);
		b.setBhit(0);
		b.setBfile("");
		b.setBdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(b); //기본메소드
		
		customerRepository.save(b);
		
	}

}
