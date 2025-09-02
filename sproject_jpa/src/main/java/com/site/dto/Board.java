package com.site.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // jpa 사용
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 전체생성자
@Builder // 부분생성자
@Data // getter, setter
@DynamicInsert //null 값인 데이터 필드를 제외하고 insert
@SequenceGenerator(
		name="board_seq_generator",
		sequenceName="board_seq",
		initialValue = 101,
		allocationSize = 1
		)
@ToString(exclude = "reply") // 무한루프 방지 - lombok
public class Board {
	
	
	@Id // 기본키 - oracle : sequence 사용
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "board_seq_generator") // DB제공되는 넘버링전략 시퀀스 파일을 자동으로 만들어 줌
	private int bno;
	@Column(nullable = false, length=100)
	private String btitle;
	@Lob // oracle CLOB 타입: 대용량 TEXT타입 -> varchar2(4000) 제한
	private String bcontent;
	
	
	// Jpa 장점: 객체사용 -> DB는 객체를 사용할 수 없음
	@ManyToOne(fetch = FetchType.EAGER) // EAGER 선택 시 생략 가능 한 명의 멤버가 여러 개의 게시글을 작성 가능
	@JoinColumn(name="id") // id를 board테이블에서 Foreign Key 등록을 시켜줌
	private Member member; // Member id -> Foreign Key 등록
	
	//Board => 주체가 되지 않음, 
	@OneToMany(mappedBy = "board", // mappedBy: 연관관계의 주인이 아님, FK 생성하지 않음.
	// FetchType.EAGER : 즉시전략, FetchType.LAZY : 지연전략
			fetch = FetchType.EAGER, 
			cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"Board"})
	@OrderBy("rno desc")
	private List<Reply> reply; // 하단댓글 여러개 <리스트>
	// JoinColumn(name="id") : id 없으면 안 됨 | mappedBy = "board" : board 없어도 ㄱㅊ
	
	
	@ColumnDefault("0")
	private int bgroup;
	@ColumnDefault("0")
	private int bstep;
	@ColumnDefault("0")
	private int bindent;
	
	@ColumnDefault("0")
	private int bhit;
	@Column(length=100)
	private String bfile;
	@CreationTimestamp
	private Timestamp bdate;
	
	
	
	

}
