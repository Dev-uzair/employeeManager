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
@Table(name="leaves")
public class Leaves {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer leaveId;
	@Column(name="leave_type")
private String leaveType;
	@Column(name="status")
private String status;
	@Column(name="leave_num")
private int levNum;
	@Column(name="leave_amt")
private int levAmt;
	public Leaves() {
		// TODO Auto-generated constructor stub
	}
}