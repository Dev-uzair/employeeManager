package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Leaves;
@Repository

public interface LeavesDao extends JpaRepository<Leaves, Integer> {
}