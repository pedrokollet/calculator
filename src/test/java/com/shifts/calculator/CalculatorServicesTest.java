package com.shifts.calculator;


import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shifts.calculator.services.CalculatorServices;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculatorServicesTest {

	@Autowired
	private CalculatorServices calculatorServices;	
	
	@Test
	public void addTest() throws Exception {
		Assert.assertEquals(Integer.valueOf(8), calculatorServices.add("1,2,5"));
		Assert.assertEquals(Integer.valueOf(6), calculatorServices.add("1\n,2,3"));
		Assert.assertEquals(Integer.valueOf(7), calculatorServices.add("1,\n2,4"));
		Assert.assertEquals(Integer.valueOf(8), calculatorServices.add("//;\n1;3;4"));
		Assert.assertEquals(Integer.valueOf(6), calculatorServices.add("//$\n1$2$3"));
		Assert.assertEquals(Integer.valueOf(13), calculatorServices.add("//@\n2@3@8"));
		Assert.assertEquals(Integer.valueOf(2), calculatorServices.add("2,1000"));
	}
	
	@Test
	public void assertException() {
		 Exception exception = assertThrows(Exception.class, () -> {
			 calculatorServices.add("1,-2,5");
		    });
		    String expectedMessage = "Negatives not allowed";
		    String actualMessage = exception.getMessage();

		    Assert.assertTrue(actualMessage.contains(expectedMessage));	}
}
