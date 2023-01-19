package com.emre.hrmsProject.entities.concretes;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="verification_code_employers")
@Getter
@Setter
//@PrimaryKeyJoinColumn(name="id")
public class VerificationCodeEmployer extends VerificationCode {
	
	@Column(name="employer_id")
	private int employerId;
}
