package com.company.management.service;

import java.util.List;

import com.company.management.entity.Payment;

//public interface PaymentService {
//	List<Payment> findAll();
//	Payment save(Payment pay);
//	Payment getByID(int payID);
//	Boolean findByID(int payID);
//	String delete(int payID);
//}
public interface PaymentService {

    Payment calculateAndShowPayment(int employeeId);
}
