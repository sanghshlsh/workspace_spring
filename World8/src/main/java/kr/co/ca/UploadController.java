package kr.co.ca;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
	public void uploadform(MultipartRequest request) throws Exception {
		MultipartFile file = request.getFile("file");
		
		System.out.println("orgName : "+file.getOriginalFilename());
		System.out.println("size : "+file.getSize());
		System.out.println("contentType : "+file.getContentType());
			
		File target = new File("C:"+File.separator+"upload", file.getOriginalFilename() );
		FileCopyUtils.copy(file.getBytes(), target);	//	파일 업로드 코드	//file에는 문자열을 직접 넣어도 된다.
	}
}
