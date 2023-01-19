package com.emre.hrmsProject.core.adapters.storages;


import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.emre.hrmsProject.core.utilities.results.DataResult;


public interface CloudinaryService {
	
	
	DataResult<?> uploadPictureFile(MultipartFile pictureFile) throws IOException;
	
}
