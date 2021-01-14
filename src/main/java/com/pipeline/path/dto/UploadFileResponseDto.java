package com.pipeline.path.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UploadFileResponseDto {

	private String fileName;

	@JsonFormat(pattern = "dd/MM/yyyy 'as' hh:mm:ss 'TZ name:' z 'TZ offeset:' Z")
	private ZonedDateTime zonedTimeOfUpload;

	private String by;

	public UploadFileResponseDto(String fileName, ZonedDateTime zonedTimeOfUpload, String by) {
		super();
		this.fileName = fileName;
		this.zonedTimeOfUpload = zonedTimeOfUpload;
		this.by = by;
	}

	public String getFileName() {
		return fileName;
	}

	public ZonedDateTime getZonedTimeOfUpload() {
		return zonedTimeOfUpload;
	}

	public String getBy() {
		return by;
	}
}
