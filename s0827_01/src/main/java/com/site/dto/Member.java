package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Member 테이블 생성
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Member {
	@Id
	private String id;
	@Column(nullable = false, length=50) // pw varchar2(100) not null
	private String pw;
	@Column(nullable = false, length=100)
	private String name;
	@Column(length=30)
	private String phone;
	@ColumnDefault(" '남자' ") // gender varchar2(30) default '남자'
	private String gender;
	@Column(length=100)
	private String hobby;
	@CreationTimestamp
	private Timestamp mdate;

}
