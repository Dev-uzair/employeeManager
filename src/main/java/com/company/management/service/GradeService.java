package com.company.management.service;

import java.util.List;

import com.company.management.entity.Grade;

public interface GradeService {
	List<Grade> findAll();
	Grade save(Grade grd);
	Grade getByID(int grdID);
	Boolean findByID(int grdID);
	String delete(int grdID);
}
