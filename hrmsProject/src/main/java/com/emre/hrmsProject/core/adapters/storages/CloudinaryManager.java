package com.emre.hrmsProject.core.adapters.storages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.ErrorDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;



@Service
public class CloudinaryManager implements CloudinaryService {

	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary=cloudinary;

	}


	
	@Override
	public DataResult<?> uploadPictureFile(MultipartFile pictureFile) throws IOException,RuntimeException{
		
        File file = convertToFile(pictureFile);

        try {
        	@SuppressWarnings("unchecked")
        	Map<String,Object> uploader = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        	return new SuccessDataResult<>(uploader);
        }
        catch(Exception e) {
        	return new ErrorDataResult<>(e.getMessage()); 
        }
        
		
	}
	

	public File convertToFile(MultipartFile pictureFile) throws IOException,RuntimeException {
		File file = new File(pictureFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(pictureFile.getBytes());
		stream.close();
		return file;

	}
}
