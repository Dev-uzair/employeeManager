package com.company.management.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="leavestrans")
public class LeavesTrans {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer leaveTransId;
	
	@Column(name="employee_id")
	private Integer empID;
	
	@Column(name="no_leave")
	private int noOfLeave;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="leave_type")
	private String leaveType;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "leave_type")
//	private Leaves leaveType;

	
	public LeavesTrans() {
	
	}

	
	
}
