package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.TestDTO;

@Repository
public class TestDAOimpl implements TestDAO{

	@Autowired
	private SqlSession session;
	
	private final String NS = "t.e.s";
	
	@Override
	public List<TestDTO> list() {

		List<TestDTO> list = session.selectList(NS+".list");
		for (TestDTO testDTO : list) {
		TestDTO dto = session.selectOne(NS+".listid",testDTO.getId());
		testDTO.setName(dto.getName());
		dto = session.selectOne(NS+".listdid",testDTO.getDid());
		testDTO.setDname(dto.getDname());
		}
		return list;
	}
	
	@Override
	public void insert(TestDTO dto) {
		
		Integer tnum = session.selectOne(NS+".maxnum");
		if (tnum == null) {
			tnum = 0;
		}
		tnum+=1;
		dto.setTnum(tnum);
		session.insert(NS+".insert", dto);
		
	}
}
