package com.emre.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="schools")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="school_name")
	@NotBlank
	@NotNull
	private String schoolName;
	
	@Column(name="school_section")
	@NotBlank
	@NotNull
	private String schoolSection;
	
	@Column(name="date_of_registration")
	@NotBlank
	@NotNull
	private LocalDate dateOfRegistration;
	
	@Column(name="date_of_graduation")
	private LocalDate dateOfGraduation;
	
	@Column(name="is_graduate")
	private boolean isGraduate;
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
}
