package com.emre.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.emre.hrmsProject.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="candidates")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
//@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schools","jobExperiences","languages","socialAccounts","knownProgrammingLanguages","coverLetters"})
public class Candidate extends User{
	

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<SocialAccount> socialAccounts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate"))
	private List<KnownProgrammingLanguage> knownProgrammingLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CoverLetter> coverLetters;
}
