package com.emre.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="workplace_name")
	@NotBlank
	@NotNull
	private String workplaceName;
	
	@Column(name="position_name")
	@NotBlank
	@NotNull
	private String positionName;
	
	@Column(name="starting_date")
	@NotBlank
	@NotNull
	private LocalDate startingDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="is_continue")
	private boolean isContinue;
	
	@ManyToOne
	@NotNull
	@NotBlank
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
