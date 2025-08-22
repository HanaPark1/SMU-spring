package com.site.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data // Getter, Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 전체생성자
@Builder // 부분생성자
@Setter
@Getter
public class BoardDto {
	private int bno;
	private String btitle;
	private String bwriter;
	private String bcontent;
	private int bgroup;
	private int bstep;
	private int bintent;
	private int bhit;
	private Date bdate;
	private String bfile;
	
	

}
