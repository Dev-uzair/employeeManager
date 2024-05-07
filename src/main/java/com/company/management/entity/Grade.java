package com.company.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer gradeId;
	@Column(name="gradename")
private String grade;
	@Column(name="base_salary")
private int baseSal;
	
}
