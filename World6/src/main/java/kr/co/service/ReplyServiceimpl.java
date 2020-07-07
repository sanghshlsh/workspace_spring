package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.domain.ReplyVO;
import kr.co.persistence.ReplyDAO;

@Service
public class ReplyServiceimpl implements ReplyService {
	
	@Inject
	private ReplyDAO rDao;
	
	@Override
	public int insert(ReplyVO vo) {
		return rDao.insert(vo);
	}
	
	@Override
	public List<ReplyVO> list(int bno) {
		return rDao.list(bno);
	}
	@Override
	public int update(ReplyVO vo) {
		return rDao.update(vo);
	}
	@Override
	public void delete(ReplyVO vo) {
		rDao.delete(vo);
		
	}
}
