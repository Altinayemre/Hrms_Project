package com.emre.hrmsProject.entities.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cover_letters")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CoverLetter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	//@JsonIgnoreProperties(value={"id","firstName","lastName","identityNumber","birthYear","email","password"})
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
