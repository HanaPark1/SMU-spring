package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3,4 순서 라벨링
	private int rno;
	
	@Column(length=100)
	private String rpw;
	
	@Column(nullable = false, length=2000)
	private String rcontent;
	
	@ManyToOne // 연관관계지정 - 1개의 게시글에는 여러개의 댓글이 존재
	@JoinColumn(name="bno") // DB에 저장할 때 컬럼 이름 지정
	private Board board; // Board.java 연결 - db에는 객체 저장 x, bno 컬럼으로 저장
	
	@ManyToOne
	@JoinColumn(name="id")
	private Member member;
	
	@UpdateTimestamp
	private Timestamp rdate;

}
