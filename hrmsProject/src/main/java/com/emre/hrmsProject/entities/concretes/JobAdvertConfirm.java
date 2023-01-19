package com.emre.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;


@Entity
@Table(name="job_adverts_confirms")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobAdvertConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirm_date")
	private LocalDate confirmDate;
	
	@ManyToOne()
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@OneToOne()
	@JoinColumn(name="job_advert_id")
	private JobAdvert jobAdvert;
	
	public JobAdvertConfirm(JobAdvert jobAdvert,Employee employee,boolean isConfirmed) {
		this.setJobAdvert(jobAdvert);
		this.setEmployee(employee);
		this.setConfirmed(isConfirmed);
	}
}
