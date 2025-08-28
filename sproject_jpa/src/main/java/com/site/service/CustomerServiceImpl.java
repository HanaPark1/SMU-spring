package com.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.Board;
import com.site.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired CustomerRepository customerRepository;

	@Override
	public List<Board> findAll() {
		List<Board> list = customerRepository.findAll();
		return list;
	}

}
