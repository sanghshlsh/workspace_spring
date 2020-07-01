package com.naver.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.TestDTO;
import kr.co.service.TestService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Inject
	private TestService tService;
	
	@RequestMapping(value = "/list")
	public void list(Model model) {
		
		List<TestDTO> list = tService.list();
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/insert")
	public void insert() {
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(TestDTO dto) {
		tService.insert(dto);
		
		return "redirect:/test/list";
	}
	
	@RequestMapping(value = "/read/{tnum}")
	public String read(@PathVariable int tnum,Model model) {
		TestDTO dto = tService.read(tnum);
		model.addAttribute("dto", dto);
		return "/test/read";
	}
	
}
