package com.shifts.calculator.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServicesImpl implements CalculatorServices {

	@Override
	public Integer add(String input) throws Exception {
		Integer returnValue = 0;
		input = input.replace(" ", "");// remove blank spaces
		for (String eachValue : splitString(input)) {
			Integer thisValue = Integer.valueOf(eachValue);
			if (isLessThan1K(thisValue) && isPositive(thisValue)) {
				returnValue += thisValue;
			}
		}
		return returnValue;
	}

	@Override
	public String[] splitString(String input) {
		if (input.contains("\n")) {
			if (input.contains("//")) {
				String[] findRegex = input.split("\n");
				String regex = findRegex[0].replace("//", "");
				return findRegex[1].split("\\" + regex);
			}
			return input.replace("\n", "").split(",");
		}
		return input.split(",");
	}

	public boolean isLessThan1K(Integer number) {
		return number < 1000;
	}

	public boolean isPositive(Integer number) throws Exception {
		if (number > 0) {
			return true;
		} else {
			throw new Exception("Negatives not allowed");
		}
	}
}
