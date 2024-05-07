package com.company.management.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.EmployeesDao;
import com.company.management.dao.GradeDao;
import com.company.management.dao.SalSlabDao;
import com.company.management.entity.Employees;
import com.company.management.entity.Grade;
import com.company.management.entity.Payment;
import com.company.management.entity.SalSlab;
import com.company.management.service.PaymentService;

@Service
public class PaymentImpl implements PaymentService{

    @Autowired
    private EmployeesDao employeeRepository;

    @Autowired
    private GradeDao gradeRepository;

    @Autowired
    private SalSlabDao salarySlabRepository;

    public Payment calculateAndShowPayment(int employeeId) {
        // Fetch employee information including gradeId and slabId
        Employees employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee == null) {
        	
            return null;
        }

        // Fetch grade information
        Grade grade = gradeRepository.findById(employee.getGradeId()).orElse(null);

        if (grade == null) {
            
            return null;
        }

        // Fetch slab information
        SalSlab salarySlab = salarySlabRepository.findById(employee.getSlabId()).orElse(null);

        if (salarySlab == null) {
            
            return null;
        }

        // Calculate basic salary
        double basicSalary = grade.getBaseSal();

        // Calculate allowances (percentage)
//        double hra = basicSalary * (salarySlab.getHRA() / 100);
//        double da = basicSalary * (salarySlab.getDA() / 100);
//        double ta = basicSalary * (salarySlab.getTA() / 100);
//        double pf = basicSalary * (salarySlab.getPF() / 100);
     // Calculate allowances (integer values)
        double hra =  (salarySlab.getHRA());
        double da = (salarySlab.getDA());
        double ta = (salarySlab.getTA());
        double pf = (salarySlab.getPF());
        
        // Sum up to get the total salary
        double totalSalary = basicSalary + hra + da + ta-pf;

        // Create a PaymentDetails object to hold the calculated values
        Payment paymentDetails = new Payment();
        paymentDetails.setEmpID(employeeId);
        paymentDetails.setEmployeeName(employee.getName());
        paymentDetails.setGrade(grade.getGrade());
        paymentDetails.setBaseSalary(basicSalary);
        paymentDetails.setHRA(hra);
        paymentDetails.setDA(da);
        paymentDetails.setTA(ta);
        paymentDetails.setPF(pf);
        paymentDetails.setTotalSalary(totalSalary);

        return paymentDetails;
    }
}
