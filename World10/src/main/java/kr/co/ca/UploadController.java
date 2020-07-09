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
public class UploadController {
private String uploadPath = "C:"+File.separator+"upload";
	@RequestMapping(value = "/uploadform")
	public void uploadform() {
		
	}
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartHttpServletRequest request, Model model) throws Exception {
		//parameter로 MultipartRequest 사용시 getparameter 불가능
		//MultipartHttpServletRequest 사용시 getParameter 가능
		
		MultipartFile file = request.getFile("file");
		
		String originalName = file.getOriginalFilename();
		
		
		//System.out.println("orgName : "+file.getOriginalFilename());
		//System.out.println("size : "+file.getSize());
		//System.out.println("contentType : "+file.getContentType());
		
		//String newName 부터 3줄은 여러곳에서 재사용하는 경우가 있기에 static method로 같이 생성해주는 경우가 많다.
//		String newName = Utils.makeNewName(originalName);	
//		File target = new File("C:"+File.separator+"upload", newName );
//		FileCopyUtils.copy(file.getBytes(), target);	//	파일 업로드 코드	//file에는 문자열을 직접 넣어도 된다.
		
		String fileName = Utils.saveFile(originalName, file, uploadPath);
		model.addAttribute("fileName", fileName);
	}
}
