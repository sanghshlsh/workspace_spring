package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.persistence.BoardDAO;

@Service
@Transactional
public class TranTestServiceimpl implements TranTestService{

	@Autowired
	private BoardDAO bDao;
	
	@Override
	public void insertNupdate1(BoardVO vo) {
		bDao.insert(vo);
		
		bDao.update(vo);
		//사실 update를 하려면 vo에 bno가 있어야 하지만 가져온 vo에는 bno가 없어서 실패 transaction이 구현안된 상태여서 insert성공 update실패 하고 끝난다.
		
	}

}
