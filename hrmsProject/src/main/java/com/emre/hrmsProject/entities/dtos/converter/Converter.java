package com.emre.hrmsProject.entities.dtos.converter;

import org.springframework.stereotype.Component;

import com.emre.hrmsProject.entities.concretes.Candidate;
import com.emre.hrmsProject.entities.dtos.CvDto;

@Component
public class Converter {

		public CvDto convertToCv(Candidate candidate) {

			return new CvDto(
					candidate.getId(),
					candidate.getFirstName(),
					candidate.getLastName(),
					candidate.getEmail(),
					candidate.getBirthYear(),
					candidate.getPictures(),
					candidate.getSchools(),
					candidate.getJobExperiences(),
					candidate.getLanguages(),
					candidate.getKnownProgrammingLanguages(),
					candidate.getCoverLetters());
		}
}
