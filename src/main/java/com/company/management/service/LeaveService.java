package com.company.management.service;

import java.util.List;

import com.company.management.entity.Leaves;

public interface LeaveService {
	List<Leaves> findAll();
	Leaves save(Leaves lev);
	Leaves getByID(int levID);
	Boolean findByID(int levID);
	String delete(int levID);
}
