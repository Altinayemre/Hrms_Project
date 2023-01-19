package com.emre.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_adverts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//private int employerId;
	//private int jobTitleId;
	//private int cityId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="minimum_salary")
	private double minSalary;
	
	@Column(name="maximum_salary")
	private double maxSalary;
	
	@Column(name="open_position")
	private int openPosition;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="working_type")
	private String workingType;
	
	@Column(name="working_time")
	private String workingTime;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobAdvert")
	private JobAdvertConfirm jobAdvertConfirm;
}
