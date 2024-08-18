package com.ds.paymentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/v1")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;
	//@Autowired
	//Producer producer;
	
	@PostMapping("add/payment")
	public ResponseEntity<Payment> updateUserDetails(@RequestBody Payment payment) throws JsonProcessingException {
		paymentRepository.save(payment);
		//producer.sendEvent("NOTIFICATION", payment.getPaymentid());
		return ResponseEntity.ok(payment);
	}

	@GetMapping("payment/{id}")
	public ResponseEntity<Optional<Payment>> getPaymentById(@PathVariable String id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		return ResponseEntity.ok(payment);
	}

	@GetMapping("payments")
	public ResponseEntity<Object> getAllPayments() throws JsonProcessingException {
		List<Payment> payments = paymentRepository.findAll();
		return ResponseEntity.ok(payments);
	}

}
