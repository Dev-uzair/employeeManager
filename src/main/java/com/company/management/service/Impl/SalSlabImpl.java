package com.company.management.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.SalSlabDao;
import com.company.management.entity.SalSlab;
import com.company.management.service.SalSlabService;

@Service
public class SalSlabImpl implements SalSlabService {
	@Autowired
	private SalSlabDao slabDao;

//read
	@Override
	public List<SalSlab> findAll() {
		return slabDao.findAll();
	}

//create
	@Override
	public SalSlab save(SalSlab sal) {
		slabDao.save(sal);
		return sal;
	}

//find
	@Override
	public Boolean findByID(int slabID) {
		Optional<SalSlab> sal = slabDao.findById(slabID);
		if (sal == null) {
			return false;
		} else {
			return true;
		}
	}

//delete
	@Override
	public String delete(int slabID) {
		slabDao.deleteById(slabID);
		return "deletes successfully " + slabID;
	}

	// get by id
	@Override
	public SalSlab getByID(int slabID) {
		Optional<SalSlab> sal = slabDao.findById(slabID);
		SalSlab slab = sal.get();
		return slab;
	}

}
