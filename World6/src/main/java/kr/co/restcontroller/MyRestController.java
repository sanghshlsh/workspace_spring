package kr.co.restcontroller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.domain.ReplyVO;
import kr.co.service.ReplyService;


@RestController
public class MyRestController {
	
	@Inject
	private ReplyService rService;
	
	@RequestMapping(value="/replies", method = RequestMethod.POST)
	public String insert(@RequestBody ReplyVO vo) {
		int i = rService.insert(vo);
		if (i == 1) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@RequestMapping(value="/replies/all/{bno}", method = RequestMethod.GET)
	public List<ReplyVO> list(@PathVariable("bno") int bno){
		List<ReplyVO> list = rService.list(bno);
		return list;
	}
	
	@RequestMapping(value = "/replyupdate", method = RequestMethod.PUT)
	public void replyUpdate(@RequestBody ReplyVO vo) {
		rService.replyUpdate(vo);
		
	}
}
