package com.emre.hrmsProject.entities.concretes;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="verification_code_candidates")
@Getter
@Setter
//@PrimaryKeyJoinColumn(name="id")
public class VerificationCodeCandidate extends VerificationCode{
	
	
	@Column(name="candidate_id")
	private int candidateId;
	
}
