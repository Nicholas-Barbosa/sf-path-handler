package com.pipeline.path.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PathServiceImpl implements PathService {

	private static final Logger log = LoggerFactory.getLogger(PathServiceImpl.class);

	@Override
	public boolean uploadByBytes(byte[] bytes, String fileName) {
		log.info("Uploading file...");
		try (var bufferOutputStream = new BufferedOutputStream(new FileOutputStream(
				"C:\\Users\\Nicholas Henrique\\Documents\\filesUploadedWithSpring\\" + fileName))) {
			bufferOutputStream.write(bytes);
			bufferOutputStream.flush();

			log.info("File uploaded!");
			return true;
		} catch (Exception e) {
			log.error("Exception in output stream operation, ", e);
		}

		return false;
	}

}
