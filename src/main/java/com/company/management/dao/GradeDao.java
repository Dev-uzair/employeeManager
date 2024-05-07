package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Grade;
@Repository
public interface GradeDao  extends JpaRepository<Grade, Integer>{

}
