package com.site.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;

}
