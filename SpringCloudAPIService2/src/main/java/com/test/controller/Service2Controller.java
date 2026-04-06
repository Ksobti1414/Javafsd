package com.test.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/service2")
public class Service2Controller {
	@GetMapping("/upi")
	public String upiPayments() {
		return "Service2 Controller payment service";
	}
}
