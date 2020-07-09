package kr.co.ca;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.utils.Utils;

@Controller
public class IframeUploadController {
//Iframe을 이용하면 업로드시 ajax통신과 같은 효과(페이지를 넘어가지않고 통신만하는)를 낼 수 있다.
	private String uploadPath = "C:"+File.separator+"upload";
	@RequestMapping(value = "/iuploadform", method = RequestMethod.GET)
	public void iuploadform() {
		
	}
	
	@RequestMapping(value = "/iuploadform", method = RequestMethod.POST)
	public String iuploadform(MultipartHttpServletRequest request, Model model) throws Exception {
		
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		
		String newName = Utils.saveFile(originalName, file, uploadPath);
		model.addAttribute("newName", newName);
		
		return "result";
	}
}
