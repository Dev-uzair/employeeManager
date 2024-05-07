package com.company.management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer payID;
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name = "slab_id")
//	private SalSlab slabId;
	@Column(name="employee_name")
private String employeeName;
	@Column(name="grade")
private String grade;
	@Column(name="base_salary")
private double baseSalary;
	@Column(name="hra")
private double HRA;
	@Column(name="da")
private double DA;
	@Column(name="ta")
private double TA;
	@Column(name="pf")
private double PF;
	@Column(name="total_salary")
private double totalSalary;
	@Column(name="month")
private String month;
	@Column(name="deduction")
private int deduction;
	@Column(name="emp_ID")
private int empID;
	@Column(name="dept_ID")
private int deptID;
	@Column(name="grd_ID")
private int grdId;
	public Payment() {
	
	}
}
		
	

