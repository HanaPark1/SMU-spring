package com.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.site.dto.Board;
import com.site.dto.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
