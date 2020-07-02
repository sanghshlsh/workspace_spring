package kr.co.ca;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxTestController {

	@RequestMapping(value = "at1", method = RequestMethod.GET)
	public void  at1() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "at1", method = RequestMethod.POST)
	public String at1(String msg) {
		
		return msg+"!!!";
	}
	
	@RequestMapping(value = "/at2", method = RequestMethod.GET)
	public void at2() {
		
	}//get 방식 표기를 안하고@RequestMapping("/at2") 이상태로 넣으면 post까지 지원함
	//그래서 변경
	
	@ResponseBody
	@RequestMapping(value = "at2", method = RequestMethod.POST)
	public String[] at2(String[] arr) {
		
		for (String x : arr) {
			System.out.println(x);
		}
		return arr;		

	}
}
