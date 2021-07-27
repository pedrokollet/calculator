package com.shifts.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shifts.calculator.services.CalculatorServices;

@RestController
public class CalculatorController {
	
	@Autowired
	CalculatorServices calculatorServices;
	
	@RequestMapping("/add")
	public String addFunction(@RequestParam String values) throws Exception {
		 if(values.isBlank()) {
			 return "0";
		 }
		 try {
		 return calculatorServices.add(values).toString();
		 } catch (Exception e) {
			 return e.getMessage();
		 }
	 }
}
