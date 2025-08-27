package com.site.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.site.dto.Board;

@Service
public interface BService {

	Map<String, Object> findAll(int page);

}
