package com.pipeline.path.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PathServiceImpl implements PathService {

	private static final Logger log = LoggerFactory.getLogger(PathServiceImpl.class);

	@Override
	public boolean upload(byte[] bytes, String fileName) {
		log.info("Uploading file...");
		try (var bufferOutputStream = new BufferedOutputStream(new FileOutputStream(
				"C:\\Users\\Nicholas Henrique\\Documents\\filesUploadedWithSpring\\" + fileName))) {
			bufferOutputStream.write(bytes);

			log.info("File uploaded!");
			return true;
		} catch (Exception e) {
			log.error("Exception in output stream operation, ", e);
		}

		return false;
	}

	@Override
	public boolean upload(InputStream stream, String fileName) throws IOException {
		log.info("Uploading file using Files class...");
		Files.copy(stream, Paths.get("C:\\Users\\Nicholas Henrique\\Documents\\filesUploadedWithSpring\\" + fileName),
				StandardCopyOption.REPLACE_EXISTING);
		log.info("File uploaded using Files class!");
		return true;
	}

}
