package kr.co.ca;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class UploadController {

	@RequestMapping(value = "/uploadform")
	public void uploadform() {
		
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartRequest request) {
		MultipartFile file = request.getFile("file");
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
	}
}
