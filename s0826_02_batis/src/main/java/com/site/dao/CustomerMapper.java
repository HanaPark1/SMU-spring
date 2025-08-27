package com.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.Customer;

@Mapper
public interface CustomerMapper {

	// 공지사항 모두 가져오기
	List<Customer> findAll(@Param int startrow, int endrow);

	// 게시글 총개수
	int findByCount();

}
