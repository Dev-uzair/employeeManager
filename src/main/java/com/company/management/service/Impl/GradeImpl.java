package com.company.management.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.GradeDao;
import com.company.management.entity.Grade;
import com.company.management.service.GradeService;
@Service
public class GradeImpl implements GradeService {
@Autowired
	private GradeDao grdDao;
	@Override
	public List<Grade> findAll() {
		return grdDao.findAll();
	}

	@Override
	public Grade save(Grade grd) {
		grdDao.save(grd);
		return grd;
	}

	@Override
	public Grade getByID(int grdID) {
		Optional<Grade> sal = grdDao.findById(grdID);
		Grade slab = sal.get();
		return slab;
	}

	@Override
	public Boolean findByID(int grdID) {
		Optional<Grade> sal = grdDao.findById(grdID);
		if (sal == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String delete(int grdID) {
		grdDao.deleteById(grdID);
		return "deletes successfully " + grdID;
	}

}
