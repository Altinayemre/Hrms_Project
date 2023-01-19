package com.emre.hrmsProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.emre.hrmsProject.core.adapters.storages.CloudinaryManager;
import com.emre.hrmsProject.core.adapters.storages.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	@Bean
	public Cloudinary cloudinaryAccount() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dk5crlrwi",
				"api_key", "534647745157976",
				"api_secret", "3-G5LObYaUvtOgO9bvY6LvbTuw0",
				"secure",true));
	}

	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(cloudinaryAccount());
	}
}
