package com.ec.calculatorserver.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ec.calculatorserver.data.CalculatorPojo;
import com.ec.calculatorserver.data.Operator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceTest {

	@Autowired
	CalculatorService calcService;

	@Test
	public void testCalculatorAddition() {
		CalculatorPojo obj = new CalculatorPojo("1", "2");
		String result = calcService.calculate(obj, Operator.ADDITION);
		assertThat(result).isEqualTo("3");
	}
	
	@Test
	public void testCalculatorSubtraction() {
		CalculatorPojo obj = new CalculatorPojo("5", "3");
		String result = calcService.calculate(obj, Operator.SUBTRACTION);
		assertThat(result).isEqualTo("2");
	}
	@Test
	public void testCalculatorSubtractionNegative() {
		CalculatorPojo obj = new CalculatorPojo("1", "2");
		String result = calcService.calculate(obj, Operator.SUBTRACTION);
		assertThat(result).isEqualTo("-1");
	}
	@Test
	public void testCalculatorMultiplication() {
		CalculatorPojo obj = new CalculatorPojo("3", "4");
		String result = calcService.calculate(obj, Operator.MULTIPLICATION);
		assertThat(result).isEqualTo("12");
	}
	@Test
	public void testCalculatorMultiplicationWithDecimalPrecision() {
		CalculatorPojo obj = new CalculatorPojo("3.9999", "4.465783");
		String result = calcService.calculate(obj, Operator.MULTIPLICATION);
		assertThat(result).isEqualTo("17.8626854217");
	}
	
	@Test
	public void testCalculatorDivision() {
		CalculatorPojo obj = new CalculatorPojo("6", "3");
		String result = calcService.calculate(obj, Operator.DIVISION);
		assertThat(result).isEqualTo("2");
	}
	
	@Test
	public void testCalculatorDivisionWithPrecision() {
		CalculatorPojo obj = new CalculatorPojo("5.78", "3.99");
		String result = calcService.calculate(obj, Operator.DIVISION);
		assertThat(result).isEqualTo("1.4486215539");
		
	}
	
	@Test
	public void testCalculatorPower() {
		CalculatorPojo obj = new CalculatorPojo("2", "3");
		String result = calcService.calculate(obj, Operator.POWER);
		assertThat(result).isEqualTo("8");
	}
	@Test
	public void testCalculatorSquareRoot() {
		CalculatorPojo obj = new CalculatorPojo("3");
		String result = calcService.calculate(obj, Operator.SQUAREROOT);
		assertThat(result).isEqualTo("1.7320508076");
	}
	@Test
	public void testIsDivisibleByZero() {
		assertThat(calcService.isDivisibleByZero("0")).isTrue();
	}
	@Test
	public void testIsDivisibleByZeroFalse() {
		assertThat(calcService.isDivisibleByZero("1")).isFalse();
	}
	@Test
	public void testGetErrorMessage() {
		assertThat(calcService.isDivisibleByZero("0")).isTrue();
		assertThat(calcService.getErrorMessage()).isEqualTo("Number divisible by Zero");
	}
	
	@Test
	public void testIsValidNumbers() {
		assertThat(calcService.isValidNumbers("1", "2")).isTrue();
	}
	
	@Test
	public void testIsValidNumbersNegative() {
		assertThat(calcService.isValidNumbers("1a", "2")).isFalse();
	}
	@Test
	public void testIsValidNumbersNegativeSecond() {
		assertThat(calcService.isValidNumbers("1", "2a")).isFalse();
	}
	
}
