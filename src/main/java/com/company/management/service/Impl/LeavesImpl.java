package com.company.management.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.LeavesDao;
import com.company.management.entity.Leaves;
@Service
public class LeavesImpl implements com.company.management.service.LeaveService {
@Autowired
private LeavesDao levDao;
	@Override
	public List<Leaves> findAll() {
		return levDao.findAll();
	}

	@Override
	public Leaves save(Leaves lev) {
		levDao.save(lev);
		return lev;
	}

	@Override
	public Leaves getByID(int levID) {
		Optional<Leaves> sal = levDao.findById(levID);
		Leaves slab = sal.get();
		return slab;
	}

	@Override
	public Boolean findByID(int levID) {
		Optional<Leaves> sal = levDao.findById(levID);
		if (sal == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String delete(int levID) {
		levDao.deleteById(levID);
		return "deletes successfully " + levID;
	}

}
