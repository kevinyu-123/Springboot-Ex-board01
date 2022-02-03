package aloha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aloha.domain.Board;
import aloha.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//게시글 목록 조회
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public void list(Model model) throws Exception{
		
		List<Board> list = service.list();
		for (Board board : list) {
			System.out.println(board);
		}
		model.addAttribute("list", service.list());
		//service 의 리스트를 호출.
		// boardservice impl 의 list가 실행됨.
	
	}
	
	//게시글 쓰기 화면
	@RequestMapping(value="register", method=RequestMethod.GET)
	public void registerForm(Model model, Board board) throws Exception{
		
	}
	
	
	//게시글 쓰기 처리 화면
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(Model model, Board board) throws Exception{
	
		System.out.println("@register - board: ");
		System.out.println(board);
		
		service.register(board);
		
		model.addAttribute("msg","등록이 완료되었습니다");
		return "/board/success";
	}
	
	// 게시글 읽기 화면
	@RequestMapping(value="read", method=RequestMethod.GET)
	public void read(Model model, Integer boardNo) throws Exception {
		model.addAttribute( service.read(boardNo) );
	}
	
	// 게시글 수정 화면
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public void modifyForm(Model model, Integer boardNo ) throws Exception {
		model.addAttribute( service.read(boardNo) );
	}
	
	
	// 게시글 수정 처리
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Model model, Board board ) throws Exception {
		service.modify(board);
		
		model.addAttribute("msg","수정이 완료되었습니다");
		return "/board/success";
	}
	
	
	// 게시글 삭제 처리
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String remove(Model model, Integer boardNo) throws Exception {
		service.remove(boardNo);
		model.addAttribute("msg", "삭제를 완료하였습니다.");
		
		return "board/success";
	}
	
	// 게시글 목록에서 삭제 처리
	@RequestMapping(value = "removeList", method = RequestMethod.POST)
	public String removeList(Model model, Integer boardNo) throws Exception {
		service.remove(boardNo);
		model.addAttribute("list", service.list());
		
		return "board/list";
	}
	
	// 게시글 목록 검색
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, String keyword) throws Exception {
		
		model.addAttribute("list", service.search(keyword));
		
		return "board/list";
	}
	
		
		
}























