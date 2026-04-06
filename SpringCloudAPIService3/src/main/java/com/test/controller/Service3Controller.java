package com.test.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/service3")
public class Service3Controller {
	@GetMapping("/card")
	public String upiPayments() {
		return "Service3 Controller for card payments";
	}
}
