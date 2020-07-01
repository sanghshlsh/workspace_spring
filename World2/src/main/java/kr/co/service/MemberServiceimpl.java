package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.MemberDTO;
import kr.co.persistence.MemberDAO;

@Service
public class MemberServiceimpl implements MemberService {

	@Inject
	private MemberDAO memberdao;

	@Override
	public void insert(MemberDTO dto) {
		memberdao.insert(dto);

	}

	@Override
	public List<MemberDTO> list() {
		
		return memberdao.list();
	}
	
	@Override
	public MemberDTO read(String id) {

		return memberdao.read(id);
	}
	
	@Override
	public MemberDTO updateui(String id) {
		
		return memberdao.updateui(id);
	}
	
	@Override
	public void update(MemberDTO dto) {
		memberdao.update(dto);
		
	}
	
	@Override
	public void delete(String id) {
		memberdao.delete(id);
		
	}
	
}
