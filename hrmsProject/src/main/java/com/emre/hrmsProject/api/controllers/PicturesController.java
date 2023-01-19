package com.emre.hrmsProject.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emre.hrmsProject.business.abstracts.PictureService;
import com.emre.hrmsProject.core.utilities.results.DataResult;
import com.emre.hrmsProject.core.utilities.results.Result;
import com.emre.hrmsProject.entities.concretes.Picture;

@RestController
@RequestMapping(value="/api/pictures")
@CrossOrigin
public class PicturesController {

	private PictureService pictureService;

	@Autowired
	public PicturesController(PictureService pictureService) {
		super();
		this.pictureService = pictureService;
	}
	
	@PostMapping(value="/upload")
	public Result upload(@RequestParam int userId,@RequestPart MultipartFile pictureFile) throws IOException {
		return this.pictureService.upload(userId, pictureFile);
	}
	
	@GetMapping(value="/getById")
	public DataResult<Picture> getById(@RequestParam int pictureId){
		return this.pictureService.getById(pictureId);
	}
	
	@GetMapping(value="/getAll")
	public DataResult<List<Picture>> getAll(){
		return this.pictureService.getAll();
	}
}
