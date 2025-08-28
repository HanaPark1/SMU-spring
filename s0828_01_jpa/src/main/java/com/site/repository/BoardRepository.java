package com.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.dto.Board;

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
