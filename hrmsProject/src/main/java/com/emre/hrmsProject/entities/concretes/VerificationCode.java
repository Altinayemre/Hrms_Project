package com.emre.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="verification_codes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VerificationCode {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="verified_date")
	private LocalDate verifiedDate;
}
