package com.websystique.springmvc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class DownloadController {
 @Autowired
 ServletContext context;
 
 @Autowired
 UserService userService;
 
 
 private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
 
 private static final String INTERNAL_FILE="/Users/alis/Documents/Проект/SpringMVCHibernateWithSpringSecurityExample/src/main/webapp/static/userforms";
 private static final String EXTERNAL_FILE_PATH="/Users/alis/Documents/testExcel1.xlsx";
 
 @RequestMapping(value="/download/{type}-{ownerID}", method = RequestMethod.GET)
 public void downloadFile(@PathVariable int ownerID, ModelMap model, HttpServletResponse response, @PathVariable("type") String type) throws IOException {
	 User user = userService.findBySSO(getPrincipal());
	 model.addAttribute("user", user);
	 model.addAttribute("ownerID", ownerID);
     File file = null;
      
     if(type.equalsIgnoreCase("internal")){
    	 	
    	 	file = new File(INTERNAL_FILE+user.getPath1());
         //ClassLoader classloader = Thread.currentThread().getContextClassLoader();
         //file = new File(classloader.getResource(INTERNAL_FILE).getFile());
     }else{
         file = new File(EXTERNAL_FILE_PATH);
     }
      
     if(!file.exists()){
         String errorMessage = "Sorry. The file you are looking for does not exist";
         System.out.println(errorMessage);
         OutputStream outputStream = response.getOutputStream();
         outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
         outputStream.close();
         return;
     }
      
     String mimeType= URLConnection.guessContentTypeFromName(file.getName());
     if(mimeType==null){
         System.out.println("mimetype is not detectable, will take default");
         mimeType = "application/octet-stream";
     }
      
     System.out.println("mimetype : "+mimeType);
      
     response.setContentType(mimeType);
      
     /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
         while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
     response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

      
     /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
     //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
      
     response.setContentLength((int)file.length());

     InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

     //Copy bytes from source to destination(outputstream in this example), closes both streams.
     FileCopyUtils.copy(inputStream, response.getOutputStream());
 }
}