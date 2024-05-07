package com.company.management.Mvc;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.company.management.entity.Payment;
//import com.company.management.service.PaymentService;

//@Controller
//@RequestMapping("/pays")
//public class PaymentMvc {
//	private PaymentService paySev;
//
//	@Autowired
//	public PaymentMvc(PaymentService paySev) {
//		this.paySev = paySev;
//	}
//
//	@GetMapping("/list")
//	public String list(Model themodel) {
//		List<Payment> levt = paySev.findAll();
//		themodel.addAttribute("payment", levt);
//		return "/payment/list-payment";
//	}
//
//	@GetMapping("/addPay")
//	public String showForm(Model theModel) {
//		Payment theEmp = new Payment();
//		theModel.addAttribute("payment", theEmp);
//		return "payment/payment-form";
//
//	}
//
//	@PostMapping("/save")
//	public String saveStud(@ModelAttribute("payment") Payment theEmp) {
//		paySev.save(theEmp);
//		return "redirect:/pays/list";
//	}
//
//	@GetMapping("/showUpdFrm")
//	public String showUpdFrm(@RequestParam("payID") int theID, Model theModel) {
//		Payment theStud = paySev.getByID(theID);
//		theModel.addAttribute("payment", theStud);
//		return "payment/payment-form";
//	}
//
//	@GetMapping("/delete")
//	public String delete(@RequestParam("payID") int theID) {
//		paySev.delete(theID);
//		return "redirect:/pays/list";
//	}
//
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.management.entity.Payment;
import com.company.management.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentMvc{

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/showPayment/{employeeId}")
    public String showPaymentDetails(@PathVariable int employeeId, Model model) {
        Payment paymentDetails = paymentService.calculateAndShowPayment(employeeId);

        if (paymentDetails != null) {
            model.addAttribute("paymentDetails", paymentDetails);
            System.out.println(paymentDetails); 
            return "payment/paymentDetails"; // Thymeleaf template name
        } else {
            // Handle the case when payment details are not available
            return "error"; // Thymeleaf template for error handling
        }
    }

        @GetMapping("/form")
        public String showPaymentForm() {
            return "payment/payment-form";
        }

        @PostMapping("/process")
        public String processPaymentForm(@RequestParam("employeeId") String employeeId, Model model) {
            try {
                int parsedEmployeeId = Integer.parseInt(employeeId);
                return "redirect:/payment/showPayment/" + parsedEmployeeId;  // Change the redirect URL
            } catch (NumberFormatException e) {
                model.addAttribute("error", "Invalid Employee ID.");
                return "error";
            }
        }
        }

