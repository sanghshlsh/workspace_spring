package kr.co.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<ReplyVO> list(int bno) {
		return session.selectList(NS+".list", bno);
	}
	@Override
	public void replyUpdate(ReplyVO vo) {
		session.update(NS+".replyupdate", vo);		
	}
}
