package com.emre.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import com.emre.hrmsProject.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pictures")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Picture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="picture_url")
	private String pictureUrl;
	
	@Column(name="creation_date")
	private LocalDate creationDate;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
}
