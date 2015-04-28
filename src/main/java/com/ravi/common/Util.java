package com.ravi.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.web.multipart.MultipartFile;

public class Util {

	public static String printDocument(File file) throws IOException,
			TransformerException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null, fileContent = "";
		while ((line = br.readLine()) != null) {
			fileContent += line + "--";
		}
		return fileContent;
	}

	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}