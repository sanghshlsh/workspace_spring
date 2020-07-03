package kr.co.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

@Repository
public class BoardDAOimpl implements BoardDAO {

	
	@Inject
	private SqlSession session;
	
	private final String NS = "b.o.a";
	
	@Override
	public void insert(BoardVO vo) {
		Integer bno = session.selectOne(NS+".getBno");
		if (bno != null) {
			bno += 1;
		} else {
			bno = 1;
		}
		vo.setBno(bno);
		session.insert(NS+".insert",vo);
		
	}
	
	@Override
	public List<BoardVO> list() {
		
		return session.selectList(NS+".list");
	}
	
	@Override
	public BoardVO read(int bno) {
		return session.selectOne(NS+".read", bno);
	}
	
	@Override
	public void increaseViewcnt(int bno) {
		session.update(NS+".increaseViewcnt", bno);
	}
	
	@Override
	public BoardVO updateui(int bno) {
		return session.selectOne(NS+".read", bno);
	}
	
	@Override
	public void update(BoardVO vo) {
		session.update(NS+".update", vo);
	}
	
	@Override
	public void delete(int bno) {
		session.delete(NS+".delete", bno);
	}
	
	@Override
	public PageTO listPage(int curPage) {
		Integer amount = session.selectOne(NS+".getAmount", curPage);
		PageTO to = new PageTO(curPage);
		to.setAmount(amount);
		List<BoardVO> list = session.selectList(NS+".listPage", to);
		to.setList(list);
		return to;
	}
}
