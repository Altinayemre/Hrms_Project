package com.emre.hrmsProject.entities.concretes;


import javax.persistence.*;

import com.emre.hrmsProject.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
//@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

}	
