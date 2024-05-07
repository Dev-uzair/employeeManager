package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.LeavesTrans;
@Repository
public interface LeavesTransDao extends JpaRepository<LeavesTrans, Integer> {

}
