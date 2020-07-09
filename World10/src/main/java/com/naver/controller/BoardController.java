package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
	@Inject
	private BoardService bService;
	
	
	@RequestMapping(value = "/insert")
	public void insert() {}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BoardVO vo) {
	
		bService.insert(vo);
	
		return "redirect:/board/list";
	}
	
//	@RequestMapping(value = "/list")
//	public void list(Model model) {
//		List<BoardVO> list =  bService.list();
//		model.addAttribute("list", list);
//	}
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(Model model, @PathVariable("bno") int bno) {
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo", vo);
		
		return "/board/read";
	}
	
	@RequestMapping(value = "/update/{bno}")
	public String update(Model model,@PathVariable("bno") int bno) {
		BoardVO vo = bService.updateUI(bno);
		model.addAttribute("vo", vo);
		
		return "board/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) {
		bService.update(vo);
		
		return "redirect:/board/read/"+vo.getBno();
	}
	
	@RequestMapping(value = "/delete/{bno}")
	public String delete(@PathVariable("bno") int bno) {
		bService.delete(bno);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/listPage/{curPage}")
	public String listPage(@PathVariable("curPage") int curPage, Model model) {
		PageTO<BoardVO> to = bService.listPage(curPage);
		model.addAttribute("to", to);
		return "/board/listpage";
	}
	
	@RequestMapping(value = "/list")
	public String list(String curPage, Model model) {
		
		
		int page = -1;
		
		if (curPage == null) {
			page = 1;
		} else {
			page =  Integer.valueOf(curPage);
		}
		PageTO<BoardVO> to = new PageTO<BoardVO>(page);
		to = bService.list(to);
		
		model.addAttribute("to", to);
		model.addAttribute("list", to.getList());
		
		return "/board/list";
	}
	
	@RequestMapping(value = "/searchlist")
	public String searchlist(Model model, String searchType, String keyword) {
		
		List<BoardVO> list = bService.searchlist(searchType, keyword);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", list);
		return "board/searchlist";
	}
	
}
