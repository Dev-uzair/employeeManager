package com.company.management.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.LeavesTransDao;
import com.company.management.entity.LeavesTrans;
import com.company.management.service.LeavesTransService;
@Service
public class LeavesTransImpl implements LeavesTransService {
	private LeavesTransDao leavesTransDao;

	@Autowired
	public LeavesTransImpl(LeavesTransDao leavesTransDao) {
		this.leavesTransDao = leavesTransDao;
	}

	@Override
	public List<LeavesTrans> findAll() {
	return	leavesTransDao.findAll();
		
	}

	@Override
	public LeavesTrans save(LeavesTrans levtrans) {

		leavesTransDao.save(levtrans);
		return levtrans;
	}

	@Override
	public LeavesTrans getByID(int levtID) {
		Optional<LeavesTrans> sal = leavesTransDao.findById(levtID);
		LeavesTrans slab = sal.get();
		return slab;
	}

	@Override
	public Boolean findByID(int levtID) {
		Optional<LeavesTrans> sal = leavesTransDao.findById(levtID);
		if (sal == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String delete(int levtID) {
	leavesTransDao.deleteById(levtID);
		return "deletes successfully " + levtID;
	}

}
