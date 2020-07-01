package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.DepartDTO;

@Repository
public class DepartDAOimpl implements DepartDAO {

	@Inject
	private SqlSession session;
	
	private final String NS = "d.e.p";
	
	@Override
	public void insert(DepartDTO dto) {
		session.insert(NS+".insert", dto);
	}
	
	@Override
	public List<DepartDTO> insert() {
		return session.selectList(NS+".list");
	}
}
