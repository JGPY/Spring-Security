package vip.iotworld.web.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vip.iotworld.dto.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {
	
	String folder = "D:\\Program Files\\Java\\STS-workspace\\iotworld-security-demo\\src\\main\\java\\vip\\iotworld\\web\\controller";

	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException {
		
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
				
		File localFile = new File(folder, new Date().getTime()+".txt");
		
		file.transferTo(localFile);
		
//		file.getInputStream()//获得流，用来传到远程服务器
		
		return new FileInfo(localFile.getAbsolutePath());
	}
	
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try (InputStream inputStream = new FileInputStream(new File(folder, id+".txt"));
				OutputStream outputStream = response.getOutputStream();){
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		};
			
			
			
		
		
	}	
}
