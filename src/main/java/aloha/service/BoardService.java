package aloha.service;

import java.util.List;

import aloha.domain.Board;

public interface BoardService {

	// 게시글 목록 조회
	public List<Board> list() throws Exception;
	
	// 게시글 쓰기
	public void register(Board board) throws Exception;
	
	// 게시글 읽기
	public Board read(Integer boardNo) throws Exception;
	
	// 게시글 수정
	public void modify(Board board) throws Exception;
	
	// 게시글 삭제
	public void remove(Integer boardNo) throws Exception;
	
	// 게시글 검색
	public List<Board> search(String keyword) throws Exception;
	
	
}
