package com.company.management.service;

import java.util.List;

import com.company.management.entity.SalSlab;

public interface SalSlabService  {

	List<SalSlab> findAll();
	SalSlab save(SalSlab Sal);
	SalSlab getByID(int slabID);
	Boolean findByID(int slabID);
	String delete(int slabID);
	
}
