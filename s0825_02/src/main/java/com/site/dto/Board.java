package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String id;
	
	// 계층형 게시판 (답변달기)
	private int bgroup;
	private int bstep;
	private int bindent;
	
	private int bhit;
	private String bfile;
	private Timestamp bdate;

}
