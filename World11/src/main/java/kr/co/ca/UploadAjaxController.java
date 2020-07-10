package kr.co.ca;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.utils.Utils;

@Controller
public class UploadAjaxController {
	private String uploadPath = "C:"+File.separator+"upload";
	
	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {
	
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadajax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String uploadajax(MultipartHttpServletRequest request) throws Exception {
	
		
		MultipartFile file =  request.getFile("file");
		String originalName = file.getOriginalFilename();
		
		String saveFileName = Utils.saveFile(originalName, file, uploadPath);

		return saveFileName;
	}
	
	//byte[]로 하면 좋지만 헤더정보도 바꿔줘야하기에 리현타입으로 byte[]를 넘겨주면 안된다
	@ResponseBody
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayfile(String filename){
		ResponseEntity<byte[]> entity = null;
		
		InputStream	in = null;
	
		try {
			int idx = filename.lastIndexOf(".");
			String format = filename.substring(idx+1);
			MediaType mType = Utils.getMediaType(format);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath+filename);
			if(mType != null) {
			headers.setContentType(mType);	
			}
			else { 
				idx = filename.indexOf("_");
				String originalName = filename.substring(idx+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//다온로드를 하게해주는 마임타입 -> MediaType.APPLICATION_OCTET_STREAM
				headers.add("Content-Disposition", "attachment;filename=\""+new String(originalName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
				//attachment;뒤 빈공간이있으면 안도니다.
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.OK);
			//img태그의 src에 데이터를 넣어주는 코드
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			//실패시 통신상태 badrequest날려주기
		} finally {
				try {
					if(in != null)	in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public void deletefile(String filename){
		File f1 = new File(uploadPath+filename);
		if(Utils.isImg(filename)) {
			int idx = filename.indexOf("s_");
			String orgName = filename.substring(0,idx);
			orgName += filename.substring(idx+2);
			File f2 = new File(uploadPath+orgName);
			f2.delete();
		}
		f1.delete();
	}
}
