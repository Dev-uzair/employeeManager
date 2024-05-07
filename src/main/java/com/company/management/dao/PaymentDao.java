package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Payment;
@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {

}
