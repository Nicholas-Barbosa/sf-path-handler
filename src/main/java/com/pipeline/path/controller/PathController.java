package com.pipeline.path.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pipeline.path.service.PathService;

@RestController
public class PathController {

	private final PathService pathService;

	public PathController(PathService pathService) {
		super();
		this.pathService = pathService;
	}

	@PostMapping(value = { "/", "upload" })
	public ResponseEntity<String> upPath(@RequestParam("file") MultipartFile mt) throws IOException {

		
		pathService.uploadByBytes(mt.getBytes(),mt.getOriginalFilename());
		
		return new ResponseEntity<String>("File uploaded!! "+mt.getSize(), HttpStatus.CREATED);
	}
}
