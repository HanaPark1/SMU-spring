package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dao.CustomerMapper;
import com.site.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired CustomerMapper customerMapper;
	
	@Override // 공지사항 모두 가져오기
	public List<Customer> findAll(int page) {
		int rowPerpage = 10; // 1 페이지 10개 게시글 적용
		int countAll = customerMapper.findByCount(); // 게시글 총개수
		int maxpage = (int)Math.ceil((double) countAll / rowPerpage); // 2.43 -> 3 페이지 필요
		int startpage = (int) ((page-1) / 10) * 10+1;
		int endpage = (startpage-1)+10;
		
		//게시글 개수 startrow, endrow
		int startrow = (page-1) * rowPerpage+1; // 1, 11, 21
		int endrow = (startrow - 1) + 10; // 10, 20, 30
		
		List<Customer> list = customerMapper.findAll();
		return list;
	}

}
