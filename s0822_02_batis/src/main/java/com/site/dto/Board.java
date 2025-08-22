package com.site.dto;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int bno;
	private String id;
	private String btitle;
	private String bcontent;
	
	// 답글달기
	private int bgroup;
	private int bstep;
	private int bindent;
	
	private String bhit;
	private String bfile;
	private Timestamp bdate;

}
