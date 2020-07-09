package kr.co.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	public static String toKor(String msg) {
		if (msg != null) {
			try {
				return new String(msg.getBytes("8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		
		}
		return null;
			
	}
	
	public static String makeNewName(String originalName) {
		UUID uid = UUID.randomUUID();
		String newName = uid.toString()+"_"+originalName;
		
		return newName;
	}
	
	public static String saveFile(String originalName, MultipartFile file,String uploadPath) throws Exception {
		String newName = Utils.makeNewName(originalName);	
		String datePath = Utils.makeDir(uploadPath);
		File target = new File(uploadPath+datePath, newName );
		FileCopyUtils.copy(file.getBytes(), target);//target의 자리에는 file객체 대신 문자열을 직접 입력해도 상관없다.
		
		return datePath+File.separator+newName;
	}
	
	public static int[] getDateInfo() {
		Calendar cal = Calendar.getInstance();//calendar 객체 생성방법
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);

		int[] arr = {year,month,date};
		
		return arr;
	}
	
	public static String[] makeDirName() {
		int[] arr = Utils.getDateInfo();
		
		String yearPath = File.separator + arr[0];
		String monthPath = yearPath+File.separator + String.format("%02d", arr[1]);
		String datePath = monthPath + File.separator +String.format("%02d", arr[2]);
		
		String[] paths = {yearPath, monthPath, datePath};
		
		return paths;
	}
	
	public static String makeDir(String uploadPath) {
		String[] paths = Utils.makeDirName();
		File f = new File(uploadPath+paths[2]);
		
		if (f.exists()) {
			return paths[2];
		} 
		
		for (String path : paths) {
			File dirPath = new File(uploadPath+path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
		return paths[2];
	}
}
