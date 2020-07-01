package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.DepartDTO;
import kr.co.persistence.DepartDAO;

@Service
@Transactional
public class DepartServiceimpl implements DepartService {
	
	@Inject
	private DepartDAO departDao;
	
	@Override
	public void insert(DepartDTO dto) {
		departDao.insert(dto);

	}
	
	@Override
	public List<DepartDTO> list() {
	
		return departDao.insert();
	}
}
