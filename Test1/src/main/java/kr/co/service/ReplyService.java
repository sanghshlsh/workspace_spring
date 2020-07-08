package kr.co.service;

import java.util.List;

import kr.co.domain.PageTO;
import kr.co.domain.ReplyVO;

public interface ReplyService {

	int insert(ReplyVO vo);

	PageTO<ReplyVO> list(PageTO<ReplyVO> to, int bno);

	int update(ReplyVO vo);

	void delete(ReplyVO vo);

}
