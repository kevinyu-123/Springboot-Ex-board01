package aloha.domain;

import java.util.Date;

import lombok.Data;

/*
 * DTO ( Data transfer object)
 */
@Data
public class Board {
	
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;

}
