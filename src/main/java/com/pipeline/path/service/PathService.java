package com.pipeline.path.service;

import java.io.IOException;

public interface PathService {

	boolean uploadByBytes(byte[] bytes,String fileName) throws IOException;
}
