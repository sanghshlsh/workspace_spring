package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;

@Repository
public class ReplyDAOimpl implements ReplyDAO {
	@Autowired
	private SqlSession session;
	
	private final String NS = "r.e.p";
	
	@Override
	public int insert(ReplyVO vo) {
		Integer rno = session.selectOne(NS+".getRno");
		vo.setRno(rno);				
		return session.insert(NS+".insert", vo);
	}
	
	@Override
	public int update(ReplyVO vo) {
		return session.update(NS+".update", vo);		
	}
	@Override
	public void delete(ReplyVO vo) {
		session.delete(NS+".delete", vo);		
	}
	
	@Override
	public PageTO<ReplyVO> list(PageTO<ReplyVO> to, int bno) {
		RowBounds rowBounds = new RowBounds(to.getStartNum()-1, to.getPerPage());

		Integer amount = session.selectOne(NS+".getAmount", bno);
		if (amount != null) {
			to.setAmount(amount);
		} else {
			to.setAmount(0);	
		}
		List<ReplyVO> list =  session.selectList(NS+".list", bno, rowBounds);
		to.setList(list);
		return to;
	}
}
