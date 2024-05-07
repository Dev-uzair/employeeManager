package com.company.management.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="department")
public class Department {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer departmentId;
	
	@Column(name="department_name")
	private String department;
	
//	
//	@OneToMany
//	@JoinColumn(name="employee") 
//	private List<Employees> employee;
//	
//	@OneToMany
//	@JoinColumn(name="gradeId") 
//	private List<Grade> gradeId;
	
	public Department() {
		}


	
	
	
	
}
