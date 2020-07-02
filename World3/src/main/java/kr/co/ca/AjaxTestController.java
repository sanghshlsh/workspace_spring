package kr.co.ca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.domain.MemberDTO;

@Controller
public class AjaxTestController {

	@RequestMapping(value = "at1", method = RequestMethod.GET)
	public void at1() {

	}

	@ResponseBody
	@RequestMapping(value = "at1", method = RequestMethod.POST)
	public String at1(String msg) {

		return msg + "!!!";
	}

	@RequestMapping(value = "/at2", method = RequestMethod.GET)
	public void at2() {

	}// get 방식 표기를 안하고@RequestMapping("/at2") 이상태로 넣으면 post까지 지원함
		// 그래서 변경

	@ResponseBody
	@RequestMapping(value = "at2", method = RequestMethod.POST)
	public String[] at2(String[] arr) {

		for (String x : arr) {
			System.out.println(x);
		}
		return arr;

	}

	@RequestMapping(value = "at3")
	public void at3() {

	}

	@RequestMapping(value = "at3", method = RequestMethod.POST)
	@ResponseBody
	public MemberDTO at3(MemberDTO dto) {
		return dto;
	}

	@RequestMapping(value = "at4")
	public void at4() {
	}

	@ResponseBody
	@RequestMapping(value = "at4", method = RequestMethod.POST)
	public void at4(@RequestParam Map<String, Object> map ) throws Exception {
		String jsonStr = map.get("listStr").toString();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(jsonStr, new TypeReference<ArrayList<Map<String, Object>>>() {
		});
		
	}
}
