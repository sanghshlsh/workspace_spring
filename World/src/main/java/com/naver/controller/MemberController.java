package com.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.MemberService;

@Controller
@RequestMapping("member")//이를 추가함으로서 insertjsp접근방법은 member/insert가 되었다
public class MemberController {
	
	@Autowired//service인터페이스를 구현한 클래스에 @service어노테이션이 없다면 이곳에 inject/autowired어노테이션이 memberservice객체를 가져오지 못한다.
	private MemberService memberService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insert";
	}
}
