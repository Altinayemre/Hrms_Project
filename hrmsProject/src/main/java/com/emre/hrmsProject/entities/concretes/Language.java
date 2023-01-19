package com.emre.hrmsProject.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="languages")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="language_name")
	@NotBlank
	@NotNull
	private String languageName;
	
	@Column(name="language_level")
	@NotBlank
	@NotNull
	private int languageLevel;
	

	@ManyToOne()
	@JoinColumn(name="candidate_id")
	@NotBlank
	@NotNull
	private Candidate candidate;
}
