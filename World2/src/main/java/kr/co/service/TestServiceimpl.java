package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.TestDTO;
import kr.co.persistence.TestDAO;

@Service
@Transactional
public class TestServiceimpl implements TestService {

	@Inject
	private TestDAO testDAO;
	
	@Override
	public List<TestDTO> list() {
		return testDAO.list();
	}
	
	@Override
	public void insert(TestDTO dto) {
		testDAO.insert(dto);
		
	}
	@Override
	public TestDTO read(int tnum) {
		return testDAO.read(tnum);
	}
}
