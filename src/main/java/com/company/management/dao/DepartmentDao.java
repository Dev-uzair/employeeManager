package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Department;
@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
