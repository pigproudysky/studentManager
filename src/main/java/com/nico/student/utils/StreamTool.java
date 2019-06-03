//package com.nico.student.utils;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.UUID;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.nico.student.bean.Photo;
//
//public class StreamTool {
//	
//	public static Photo writeFile(MultipartFile file) {
//		Photo photo = new Photo();
//		String oriName = "";
//		try {
//			oriName = file.getOriginalFilename();
//			String extName = oriName.substring(oriName.lastIndexOf("."));
//			String uuid = UUID.randomUUID().toString();
//			String newName = uuid;
//			photo.setSuffix(extName);
//			photo.setData(uuid);
//			try {
//				uploadFileUtil(file.getBytes(),PathUtils.SYSTEM_PATH, newName+extName);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		}
//		return photo;
//		
//	}
//	
//	
//	private static void uploadFileUtil(byte[] file, String imgPath, String imgName) throws Exception {
//		
//		File targetFile = new File(imgPath);
//		if (!targetFile.exists()) {
//			targetFile.mkdirs();
//		}
//		FileOutputStream out = new FileOutputStream(imgPath + imgName);
//		out.write(file);
//		out.flush();
//		out.close();
//	}
//	
//	
//}
