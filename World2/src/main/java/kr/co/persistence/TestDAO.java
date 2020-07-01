package kr.co.persistence;

import java.util.List;

import kr.co.domain.TestDTO;

public interface TestDAO {

	List<TestDTO> list();

	void insert(TestDTO dto);

}
