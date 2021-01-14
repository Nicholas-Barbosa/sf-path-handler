package com.pipeline.path.controller;

import java.io.IOException;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.pipeline.path.dto.UploadFileFormDto;
import com.pipeline.path.dto.UploadFileResponseDto;
import com.pipeline.path.service.PathService;

@RestController
public class PathController {

	private final PathService pathService;

	public PathController(PathService pathService) {
		super();
		this.pathService = pathService;
	}

	@PostMapping(value = { "/{by}", "upload/{by}" })
	public ResponseEntity<UploadFileResponseDto> upPath(@RequestParam("file") MultipartFile mt,
			@PathVariable(name = "by") String by) throws IOException {

		String fileName = mt.getOriginalFilename();
		ZonedDateTime time = ZonedDateTime.now();

		if (pathService.upload(mt.getBytes(), mt.getOriginalFilename())) {
			UploadFileResponseDto response = new UploadFileResponseDto(fileName, time,by);

			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error, try again but later!");

	}
	
	@PostMapping(value = { "/upFiles{by}", "uploadUsingFilesClass/{by}" })
	public ResponseEntity<UploadFileResponseDto> upPathFiles(@RequestParam("file") MultipartFile mt,
			@PathVariable(name = "by") String by) throws IOException {

		String fileName = mt.getOriginalFilename();
		ZonedDateTime time = ZonedDateTime.now();

		if (pathService.upload(mt.getInputStream(), mt.getOriginalFilename())) {
			UploadFileResponseDto response = new UploadFileResponseDto(fileName, time,by);

			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error, try again but later!");

	}
}
