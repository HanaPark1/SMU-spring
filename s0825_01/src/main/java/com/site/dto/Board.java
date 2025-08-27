package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private String id;
	
	// 계층형 게시판 <답변달기
	private int bgroup; // 그룹핑
	private int bstep; // 출력순서
	private int bindent; // 들여쓰기
	
	
	private int bhit;
	private Timestamp bdate;
	private String bfile;

}
