package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.SalSlab;
@Repository
public interface SalSlabDao extends JpaRepository<SalSlab, Integer> {

}
