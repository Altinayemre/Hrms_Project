package com.emre.hrmsProject.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobAdvertDetailDto {
	private int id;
	private String companyName;
	private String jobTitle;
	private int openPosition;
	private LocalDate releaseDate;
	private LocalDate deadline;
}
