package com.ec.calculatorserver.data;

public final class CalculatorPojo {

	private String firstOperand;
	private String secondOperand;

	public CalculatorPojo(String firstOperand, String secondOperand) {
		this(firstOperand);
		this.secondOperand = secondOperand;

	}

	public CalculatorPojo(String firstOperand) {
		this.firstOperand = firstOperand;
	}

	public String getFirstOperand() {
		return firstOperand;
	}

	public String getSecondOperand() {
		return secondOperand;
	}

}
