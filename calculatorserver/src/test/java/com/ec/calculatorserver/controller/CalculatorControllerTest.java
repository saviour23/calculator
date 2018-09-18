package com.ec.calculatorserver.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorControllerTest {

	@Autowired
	CalculatorController controller;

	@Test
	public void testGetSumOfNumbers() {
		String result = controller.getSumOfNumbers("10", "20");
		assertThat(result).isEqualTo("30");

	}

	@Test
	public void testGetSubtractionOfNumbers() {
		String result = controller.getSubtractionOfNumbers("10", "20");
		assertThat(result).isEqualTo("-10");

	}

	@Test
	public void testGetMultiplicationOfNumbers() {
		String result = controller.getMultiplicationOfNumbers("10", "20");
		assertThat(result).isEqualTo("200");

	}

	@Test
	public void testGetDivisionOfNumbers() {
		String result = controller.getDivisionOfNumbers("6", "2");
		assertThat(result).isEqualTo("3");

	}

	@Test
	public void testGetPowOfNumbers() {
		String result = controller.getPow("2", "3");
		assertThat(result).isEqualTo("8");

	}

	@Test
	public void testGetSqrtOfNumbers() {
		String result = controller.getSqrt("4");
		assertThat(result).isEqualTo("2");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testGetSumOfNumbersNegative() {
		String result = controller.getSumOfNumbers("10a", "20");
		assertThat(result).isEqualTo("Invalid Input, First Input is not Number");

	}
	@Test
	public void testGetSumOfNumbersNegativeSecond() {
		String result = controller.getSumOfNumbers("10", "20a");
		assertThat(result).isEqualTo("Invalid Input, Second Input is not Number");

	}

	@Test
	public void testGetSubtractionOfNumbersNegative() {
		String result = controller.getSubtractionOfNumbers("10q", "20");
		assertThat(result).isEqualTo("Invalid Input, First Input is not Number");

	}
	@Test
	public void testGetSubtractionOfNumbersNegativeSecond() {
		String result = controller.getSubtractionOfNumbers("10", "20a");
		assertThat(result).isEqualTo("Invalid Input, Second Input is not Number");

	}
	@Test
	public void testGetMultiplicationOfNumbersNegative() {
		String result = controller.getMultiplicationOfNumbers("10y", "20");
		assertThat(result).isEqualTo("Invalid Input, First Input is not Number");

	}
	@Test
	public void testGetMultiplicationOfNumbersNegativeSecond() {
		String result = controller.getMultiplicationOfNumbers("10", "20p");
		assertThat(result).isEqualTo("Invalid Input, Second Input is not Number");

	}

	@Test
	public void testGetDivisionOfNumbersNegativeSecond() {
		String result = controller.getDivisionOfNumbers("6", "2y");
		assertThat(result).isEqualTo("Invalid Input, Second Input is not Number");

	}
	@Test
	public void testGetDivisionOfNumbersNegative() {
		String result = controller.getDivisionOfNumbers("6p", "2");
		assertThat(result).isEqualTo("Invalid Input, First Input is not Number");

	}

	@Test
	public void testGetPowOfNumbersNegative() {
		String result = controller.getPow("2y", "3");
		assertThat(result).isEqualTo("Invalid Input, First Input is not Number");

	}
	@Test
	public void testGetPowOfNumbersNegativeSecond() {
		String result = controller.getPow("2", "3a");
		assertThat(result).isEqualTo("Invalid Input, Second Input is not Number");

	}

	@Test
	public void testGetSqrtOfNumbersNegative() {
		String result = controller.getSqrt("4a");
		assertThat(result).isEqualTo("Invalid Input, First Input is not Number");

	}

	
	

}
