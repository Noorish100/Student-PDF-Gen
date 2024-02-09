package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Assignment : Develop a microservice that accepts input comprising student details, school details,
//marks, and term, and produces a PDF document as output. This PDF document should offer customizable
//templates allowing for distinct look and feel variations.


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studId;
	private String studentName;
	private String studentAge;
	private String schoolName;
	private String term;
	private String marks;
	private String schoolAddress;
	private String studentAddress;
	private String temp;
	
	
	

}
