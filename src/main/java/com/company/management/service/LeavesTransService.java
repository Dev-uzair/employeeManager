package com.company.management.service;

import java.util.List;

import com.company.management.entity.LeavesTrans;

public interface LeavesTransService {
	List<LeavesTrans> findAll();
	LeavesTrans save(LeavesTrans levtrans);
	LeavesTrans getByID(int levtID);
	Boolean findByID(int levtID);
	String delete(int levtID);
}
