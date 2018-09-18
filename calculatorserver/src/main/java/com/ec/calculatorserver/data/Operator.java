package com.ec.calculatorserver.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum storing all operators and define the operations to be performed based on
 * operator.
 */
public enum Operator {

	ADDITION("+", 2) {
		public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
			return firstOperand.add(secondOperand).setScale(15, RoundingMode.HALF_UP);
		}
	},

	SUBTRACTION("-", 2) {
		public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
			return firstOperand.subtract(secondOperand).setScale(15, RoundingMode.HALF_UP);
		}
	},

	MULTIPLICATION("*", 2) {
		public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
			return secondOperand.multiply(firstOperand).setScale(15, RoundingMode.HALF_UP);
		}
	},

	DIVISION("/", 2) {
		public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {

			return firstOperand.divide(secondOperand, 15, RoundingMode.HALF_UP);
		}
	},

	SQUAREROOT("sqrt", 1) {
		public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
			return sqrt(firstOperand);
		}
	},

	POWER("pow", 2) {
		public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
			return firstOperand.pow(secondOperand.intValue()).setScale(15, RoundingMode.HALF_UP);
		}
	};

	private String symbol;
	private int operandsNumber;

	Operator(String symbol, int operandsNumber) {
		this.symbol = symbol;
		this.operandsNumber = operandsNumber;
	}

	public abstract BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand);

	public String getSymbol() {
		return symbol;
	}

	public int getOperandsNumber() {
		return operandsNumber;
	}


	public static BigDecimal sqrt(BigDecimal value) {
		BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
		return x.setScale(15, RoundingMode.HALF_UP);
	}

}