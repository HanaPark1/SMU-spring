package com.site.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Stu {
	private int sno;
	private String name;
	private Integer kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
}
