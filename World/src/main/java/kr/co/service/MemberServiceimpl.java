package kr.co.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceimpl implements MemberService {
	
	@Inject
	private MemberDAO memberdao;
	
	
}
