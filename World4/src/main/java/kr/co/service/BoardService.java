package kr.co.service;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;

public interface BoardService {
	void insert(BoardVO vo);

	List<BoardVO> list();

	BoardVO read(int bno);

	BoardVO updateUI(int bno);

	void update(BoardVO vo);

	void delete(int bno);

	PageTO listPage(int curPage);
}
