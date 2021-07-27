package com.shifts.calculator.services;

import org.springframework.stereotype.Service;

public interface CalculatorServices {
	
	public Integer add(String input) throws Exception;
	public String[] splitString(String input);
	
}
