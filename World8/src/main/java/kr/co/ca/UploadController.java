package kr.co.ca;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.utils.Utils;

@Controller
public class UploadController {

	@RequestMapping(value = "/uploadform")
	public void uploadform() {
		
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartHttpServletRequest request) throws Exception {
		//parameter로 MultipartRequest 사용시 getparameter 불가능
		//MultipartHttpServletRequest 사용시 getParameter 가능
		
		MultipartFile file = request.getFile("file");
		String originalName = file.getOriginalFilename();
		String newName = Utils.makeNewName(originalName);
//		System.out.println("orgName : "+file.getOriginalFilename());
//		System.out.println("size : "+file.getSize());
//		System.out.println("contentType : "+file.getContentType());
			
		File target = new File("C:"+File.separator+"upload", newName );
		FileCopyUtils.copy(file.getBytes(), target);	//	파일 업로드 코드	//file에는 문자열을 직접 넣어도 된다.
	}
}
