package kr.co.service;

import java.util.List;

import kr.co.domain.DepartDTO;

public interface DepartService {

	void insert(DepartDTO dto);

	List<DepartDTO> list();

}
