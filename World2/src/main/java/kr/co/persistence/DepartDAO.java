package kr.co.persistence;

import java.util.List;

import kr.co.domain.DepartDTO;

public interface DepartDAO {

	void insert(DepartDTO dto);

	List<DepartDTO> insert();


}
