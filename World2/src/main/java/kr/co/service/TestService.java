package kr.co.service;

import java.util.List;

import kr.co.domain.TestDTO;

public interface TestService {

	List<TestDTO> list();

	void insert(TestDTO dto);

	TestDTO read(int tnum);

}
