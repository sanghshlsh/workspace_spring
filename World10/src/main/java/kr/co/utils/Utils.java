package kr.co.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.MediaType;
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
		String newName = uid.toString() + "_" + originalName;
		return newName;
	}

	public static String saveFile(String originalName, MultipartFile file, String uploadPath) throws Exception {
		String newName = Utils.makeNewName(originalName);
		String datePath = Utils.makeDir(uploadPath);
		File target = new File(uploadPath + datePath, newName);
		FileCopyUtils.copy(file.getBytes(), target);// target의 자리에는 file객체 대신 문자열을 직접 입력해도 상관없다.
		
		boolean isImgFile = isImg(originalName);
		if (isImgFile) {
			System.out.println("썸네일을 만든다.");
		} else {
			System.out.println("썸네일을 만들지 않는다.");
		}
		
		return datePath + File.separator + newName;
	}

	public static int[] getDateInfo() {
		Calendar cal = Calendar.getInstance();// calendar 객체 생성방법
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int[] arr = { year, month, date };
		return arr;
	}

	public static String[] makeDirName() {
		int[] arr = Utils.getDateInfo();
		String yearPath = File.separator + arr[0];
		String monthPath = yearPath + File.separator + String.format("%02d", arr[1]);
		String datePath = monthPath + File.separator + String.format("%02d", arr[2]);
		String[] paths = { yearPath, monthPath, datePath };
		return paths;
	}

	public static String makeDir(String uploadPath) {
		String[] paths = Utils.makeDirName();
		File f = new File(uploadPath + paths[2]);
		if (f.exists()) {
			return paths[2];
		}
		for (String path : paths) {
			File dirPath = new File(uploadPath + path);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		return paths[2];
	}
	
	//확장자가 png gif jpg jpeg인 파일의 썸네일 아이콘생성
	//mediatype은 org.springframework.http 의 mediatype
	public static boolean isImg(String filename) {
		
		int idx = filename.lastIndexOf(".");
		String format = filename.substring(idx+1);
		Map<String, MediaType> map = new HashMap<String, MediaType>();
		map.put("JPG", MediaType.IMAGE_JPEG);
		map.put("JPEG", MediaType.IMAGE_JPEG);
		map.put("PNG", MediaType.IMAGE_PNG);
		map.put("GIF", MediaType.IMAGE_GIF);
		
		MediaType mType = map.get(format.toUpperCase());
		
		if (mType != null) {
			return true;
		}
		return false;
				
		
	}
}
