package com.emre.hrmsProject.entities.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="social_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SocialAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="account_url")
	private String accountUrl;
	
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
}
