package com.company.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	@Column(name = "name")
	private String name;
	@Column(name = "fname")
	private String fName;
	@Column(name = "address")
	private String address;
	@Column(name = "mobile")
	private String mobile;
	
	private int deptId;
	
	private int gradeId;
	
	private int slabId;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "department_id")
//	private Department department;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	
//	private SalSlab slab;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "grade_id")
//	private Grade grade;

	@Column(name = "gender")
	private String gender;
	@Column(name = "birthdate")
	private String birthdate;
	@Column(name = "join_date")
	private String joinDate;

	
	public Employees() {
		// TODO Auto-generated constructor stub
	}
}