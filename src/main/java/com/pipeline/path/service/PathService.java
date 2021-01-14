package com.pipeline.path.service;

import java.io.IOException;
import java.io.InputStream;

public interface PathService {

	boolean upload(byte[] bytes,String fileName) throws IOException;
	
	boolean upload(InputStream stream,String fileName) throws IOException;
}
