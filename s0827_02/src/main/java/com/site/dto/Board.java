package com.site.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Board {
	@Id
	private int bno;
	@Column(nullable=false, length=50)
	private String btitle;
	@Column(nullable=false, length=500)
	private String bcontent;
	@Column(nullable=false, length=50)
	private String id;
	@Column
	private int bgroup;
	@Column
	private int bstep;
	@Column
	private int bindent;
	@Column
	private int bhit;
	@Column(length=100)
	private String bfile;
	@CreationTimestamp
	private Timestamp bdate;
}
