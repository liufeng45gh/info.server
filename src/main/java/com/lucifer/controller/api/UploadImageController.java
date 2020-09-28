package com.lucifer.controller.api;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lucifer.util.Result;


@Controller
public class UploadImageController {
	
	@Autowired
	private String storeBase;
	
	
	@Autowired	
	private String cdn_header;
	
	private  String imgSuffix=".jpg";
	
	private static  Log log = LogFactory.getLog(UploadImageController.class);
	
	@RequestMapping(value="/api/avatar/upload.json",method = RequestMethod.POST)
	@ResponseBody
	public Result avatarUpload(@RequestParam("Filedata") MultipartFile file) throws IOException{
				
		log.info(storeBase);
		
		String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(UUID.randomUUID().toString());
		String relativeDir = this.getRelativePath("avatar",md5);
		log.info("relativeDir: "+relativeDir);
		String absoluteDir = this.storeBase+relativeDir;
		log.info("absoluteDir: "+absoluteDir);
		File fileDir = new File(absoluteDir);
        if (!fileDir.exists()) {
        	fileDir.mkdirs();
        }
        String relativePath = relativeDir+md5+imgSuffix;
        
        String absolutePath = this.storeBase+relativePath;
        
		// 转型为MultipartHttpRequest：
		//MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		
		// 获得文件：   
       // MultipartFile file = multipartRequest.getFile("upload_image"); 
        
        // 获得文件名：   
        //String filename = file.getOriginalFilename(); 
        
        // 获得输入流：   
        //InputStream input = file.getInputStream(); 
        
        // 写入文件 // 或者：   
        File source = new File(absolutePath);   
        
        file.transferTo(source);
        Map resultMap = new HashMap();
        resultMap.put("Filedata", relativePath);
        return Result.ok(resultMap);
	}
	
	 public String getRelativePath(String uploadPath,String md5) {
	        StringBuffer pathBuffer = new StringBuffer();
	        pathBuffer.append("/"+ uploadPath +"/") ;
	        for (int i = 0; i < 4; i++) {
	            pathBuffer.append(new String(md5.substring(i, i+1)));
	            pathBuffer.append("/");
	        }

	        return pathBuffer.toString();
	    }

}
