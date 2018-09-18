package com.ec.calculatorserver.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.ec.calculatorserver.data.CalculatorPojo;
import com.ec.calculatorserver.data.Operator;

@Service
public class CalculatorService {

	private static String ERROR_MESSAGE = "";

	/**
	 * Method responsible for calculation like addition,subtraction, Division,
	 * Multiplication, Power, SquareRoot,
	 * 
	 * @param data POJO object of {@link CalculatorPojo}}
	 * @param opr  operator ENUM {@link Operator}}
	 * @return result of calculation as string
	 */
	public String calculate(CalculatorPojo data, Operator opr) {
		BigDecimal resultBD;
		if (opr.getOperandsNumber() > 1) {

			resultBD = opr.calculate(new BigDecimal(data.getFirstOperand()), new BigDecimal(data.getSecondOperand()));
		} else {
			resultBD = opr.calculate(new BigDecimal(data.getFirstOperand()), new BigDecimal(1));
		}
		//returning upto 10 decimal places
		DecimalFormat fmt = new DecimalFormat("0.##########");
		return fmt.format(resultBD);

	}

	/**
	 * Validation input parameters if they are digits
	 * 
	 * @param firstNumber  first input operand
	 * @param secondNumber second input operand
	 * @return true if both are digits otherwise false
	 */
	public boolean isValidNumbers(String firstNumber, String SecondNumber) {
		boolean isValid = false;
		if (validateNumber(firstNumber)) {
			if (validateNumber(SecondNumber)) {
				isValid = true;

			} else {
				ERROR_MESSAGE = "Invalid Input, Second Input is not Number";
			}

		} else {
			ERROR_MESSAGE = "Invalid Input, First Input is not Number";
		}

		return isValid;

	}

	private boolean validateNumber(String number) {
		boolean isValid = false;
		try {
			Double.parseDouble(number);
			isValid = true;
		} catch (Exception e) {
			isValid = false;
			ERROR_MESSAGE = "Invalid Input, Input is not Number";
		}

		return isValid;
	}

	/**
	 * Method to return error occurred during validation
	 * 
	 * @return error message
	 */
	public String getErrorMessage() {
		return ERROR_MESSAGE;
	}

	/**
	 * Validating if numbers received are divisible by ZERO
	 * 
	 * @param secondNumber
	 * @return
	 */
	public boolean isDivisibleByZero(String secondNumber) {
		BigDecimal secondValue = new BigDecimal(secondNumber);
		// comparing if value is greater than ZERO
		if (secondValue.compareTo(BigDecimal.ZERO) == 1) {
			return false;
		}
		ERROR_MESSAGE = "Number divisible by Zero";
		return true;
	}

}
