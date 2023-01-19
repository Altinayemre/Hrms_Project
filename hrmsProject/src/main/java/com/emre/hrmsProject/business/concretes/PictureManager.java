package com.emre.hrmsProject.business.concretes;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emre.hrmsProject.business.abstracts.PictureService;
import com.emre.hrmsProject.core.adapters.storages.CloudinaryService;
import com.emre.hrmsProject.core.business.UserService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.core.utilities.results.SuccessDataResult;
import com.emre.hrmsProject.core.utilities.results.SuccessResult;
import com.emre.hrmsProject.dataAccess.abstracts.PictureDao;
import com.emre.hrmsProject.entities.concretes.Picture;


@Service
public class PictureManager implements PictureService{
 
	private CloudinaryService cloudinaryService;
	private UserService userService;
	private PictureDao pictureDao;
	
	@Autowired
	public PictureManager(CloudinaryService cloudinaryService, UserService userService, PictureDao pictureDao) {
		
		this.cloudinaryService = cloudinaryService;
		this.userService = userService;
		this.pictureDao = pictureDao;
	}
	

	@Override
	public Result add(Picture picture) {
		this.pictureDao.save(picture);
		return new SuccessResult("Resim eklendi");
	}


	@Override
	public Result update(Picture picture) {
		this.pictureDao.save(picture);
		return new SuccessResult("Resim güncellendi");
	}


	@Override
	public Result delete(int id) {
		this.pictureDao.deleteById(id);
		return new SuccessResult("Resim silindi");
	}


	@Override
	public DataResult<Picture> getById(int id) {
		
		return new SuccessDataResult<Picture>(this.pictureDao.getById(id),"Resim getirildi");
	}


	@Override
	public DataResult<List<Picture>> getAll() {
		
		return new SuccessDataResult<List<Picture>>(this.pictureDao.findAll(),"Resimler listelendi");
	}
	
	@Override
	public Result upload(int userId, MultipartFile pictureFile) throws IOException {
		
		Map<?,?> pictureMap=(Map<?,?>) cloudinaryService.uploadPictureFile(pictureFile).getData();
		
		Picture picture = new Picture();
		picture.setUser(userService.getById(userId).getData());
		picture.setPictureUrl(pictureMap.get("url").toString());
		picture.setCreationDate(LocalDate.now());
		
		return add(picture);
	}
}
