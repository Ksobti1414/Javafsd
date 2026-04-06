package com.test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/service1")
public class Service1Controller {
@GetMapping("/openac")
public String acCreateService() {
	return "Sevice1 Controller";
}
}
