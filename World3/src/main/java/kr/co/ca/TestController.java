package kr.co.ca;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping(value = "/rt1")
	public void rt1() {}
	//TestController를 통해 view로 넘어가고
	
}
