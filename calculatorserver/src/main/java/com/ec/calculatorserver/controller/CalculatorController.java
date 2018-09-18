package com.ec.calculatorserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ec.calculatorserver.data.CalculatorPojo;
import com.ec.calculatorserver.data.Operator;
import com.ec.calculatorserver.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
//temporarily allowing CORS for localhost and port 4200 of angular to access this controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CalculatorController {

	@Autowired
	CalculatorService calcService;

	@RequestMapping(value = "/calculate/addition", method = RequestMethod.GET)
	public String getSumOfNumbers(@RequestParam(value = "firstnumber") String firstNumber,
			@RequestParam(value = "secondnumber") String secondNumber) {
		String errorMessage = "";
		if (calcService.isValidNumbers(firstNumber, secondNumber)) {
			CalculatorPojo pojoObject = getPojo(firstNumber, secondNumber);
			return calcService.calculate(pojoObject, Operator.ADDITION);
		} else {
			errorMessage = calcService.getErrorMessage();
		}
		return errorMessage;

	}

	@RequestMapping(value = "/calculate/subtraction", method = RequestMethod.GET)
	public String getSubtractionOfNumbers(@RequestParam(value = "firstnumber") String firstNumber,
			@RequestParam(value = "secondnumber") String secondNumber) {
		if (calcService.isValidNumbers(firstNumber, secondNumber)) {
			CalculatorPojo pojoObject = getPojo(firstNumber, secondNumber);
			return calcService.calculate(pojoObject, Operator.SUBTRACTION);
		}
		return calcService.getErrorMessage();

	}

	@RequestMapping(value = "/calculate/multiplication", method = RequestMethod.GET)
	public String getMultiplicationOfNumbers(@RequestParam(value = "firstnumber") String firstNumber,
			@RequestParam(value = "secondnumber") String secondNumber) {
		if (calcService.isValidNumbers(firstNumber, secondNumber)) {
			CalculatorPojo pojoObject = getPojo(firstNumber, secondNumber);
			return calcService.calculate(pojoObject, Operator.MULTIPLICATION);
		}

		return calcService.getErrorMessage();

	}

	@RequestMapping(value = "/calculate/division", method = RequestMethod.GET)
	public String getDivisionOfNumbers(@RequestParam(value = "firstnumber") String firstNumber,
			@RequestParam(value = "secondnumber") String secondNumber) {
		if (calcService.isValidNumbers(firstNumber, secondNumber) && !calcService.isDivisibleByZero(secondNumber)) {
			CalculatorPojo pojoObject = getPojo(firstNumber, secondNumber);
			return calcService.calculate(pojoObject, Operator.DIVISION);
		}
		return calcService.getErrorMessage();
	}

	@RequestMapping(value = "/calculate/pow", method = RequestMethod.GET)
	public String getPow(@RequestParam(value = "base") String base, @RequestParam(value = "ext") String ext) {
		if (calcService.isValidNumbers(base, ext)) {
			CalculatorPojo pojoObject = getPojo(base, ext);
			return calcService.calculate(pojoObject, Operator.POWER);
		}
		return calcService.getErrorMessage();
	}

	@RequestMapping("calculate/sqrt/{num}")
	public String getSqrt(@PathVariable(value = "num") String firstOperand) {
		if (calcService.isValidNumbers(firstOperand, "1")) {
			CalculatorPojo pojoObject = new CalculatorPojo(firstOperand);
			return calcService.calculate(pojoObject, Operator.SQUAREROOT);
		}
		return calcService.getErrorMessage();

	}

	private CalculatorPojo getPojo(String firstOperand, String secondOperand) {
		return new CalculatorPojo(firstOperand, secondOperand);

	}

}
