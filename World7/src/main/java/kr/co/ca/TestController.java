package kr.co.ca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.domain.MemberDTO;

@Controller
public class TestController {

	@RequestMapping(value = "/rt1")
	public void rt1() {}
	//TestController를 통해 view로 넘어가고
	
	
	@RequestMapping(value = "/rt2")
	public void rt2() {}
	
	@RequestMapping(value = "/rt3")
	public void rt3() {}
	
	@RequestMapping(value = "/rt4")
	public void rt4(Model model) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("m001", "kim", 33));
		list.add(new MemberDTO("m002", "lee", 44));
		list.add(new MemberDTO("m003", "park", 55));
		model.addAttribute("list", list);
		
	}
}
