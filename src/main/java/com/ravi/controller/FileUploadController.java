package com.ravi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ravi.common.Util;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				String fileContents = Util.printDocument(Util.convert(file));
				System.out.println(fileContents);
				/*
				 * byte[] bytes = file.getBytes(); File newFile = new
				 * File(file.getName() + "-uploaded"); BufferedOutputStream
				 * stream = new BufferedOutputStream( new
				 * FileOutputStream(newFile)); stream.write(bytes);
				 * stream.close();
				 */
				return "{\"success\" : \"You successfully uploaded ! \"}";
			} catch (Exception e) {
				return "You failed to upload => " + e.getMessage();
			}
		} else {
			return "You failed to upload because the file was empty.";
		}
	}

	@RequestMapping(value = "/uploadwithjson", method = RequestMethod.POST)
	public @ResponseBody String handleFileUploadWithJsonPayload(
			@RequestParam("file") MultipartFile file,
			@RequestParam("data") String payload) {
		if (!file.isEmpty()) {
			try {
				String fileContents = Util.printDocument(Util.convert(file));
				System.out.println(fileContents);
				/*
				 * byte[] bytes = file.getBytes(); File newFile = new
				 * File(file.getName() + "-uploaded"); BufferedOutputStream
				 * stream = new BufferedOutputStream( new
				 * FileOutputStream(newFile)); stream.write(bytes);
				 * stream.close();
				 */
				System.out.println("----------------" + payload + "----------");
				return "{\"success\" : \"You successfully uploaded ! \"}";
			} catch (Exception e) {
				return "You failed to upload => " + e.getMessage();
			}
		} else {
			return "You failed to upload because the file was empty.";
		}
	}
}
