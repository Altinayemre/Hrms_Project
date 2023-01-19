package com.emre.hrmsProject.entities.dtos;

import java.util.List;

import com.emre.hrmsProject.entities.concretes.CoverLetter;
import com.emre.hrmsProject.entities.concretes.JobExperience;
import com.emre.hrmsProject.entities.concretes.KnownProgrammingLanguage;
import com.emre.hrmsProject.entities.concretes.Language;
import com.emre.hrmsProject.entities.concretes.Picture;
import com.emre.hrmsProject.entities.concretes.School;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CvDto {

	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int birthYear;
	private List<Picture> pictures;
	private List<School> schools;
	private List<JobExperience> jobExperience;
	private List<Language> languages;
	private List<KnownProgrammingLanguage> knownProgrammingLanguages;
	private List<CoverLetter> coverLetters;
}
