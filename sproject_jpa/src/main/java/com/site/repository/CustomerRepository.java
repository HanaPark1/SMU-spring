package com.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.dto.Board;
import com.site.dto.Member;

public interface CustomerRepository extends JpaRepository<Board, Integer> {

}
