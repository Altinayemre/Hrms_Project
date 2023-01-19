package com.emre.hrmsProject.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Picture;

public interface PictureService extends BaseEntityService<Picture>{
	Result upload(int userId,MultipartFile pictureFile) throws IOException;
}
