package com.javaSampleCode.designPatterns.creational;

interface Currency {
	String getSymbol();
}

// Concrete Rupee Class code
class Rupee implements Currency {
	@Override
	public String getSymbol() {
		return "Rs";
	}
}

// Concrete SGD class Code
class SGDDollar implements Currency {
	@Override
	public String getSymbol() {
		return "SGD";
	}
}

// Concrete US Dollar code
class USDollar implements Currency {
	@Override
	public String getSymbol() {
		return "USD";
	}
}

class CurrencyFactory {
	public static Currency createCurrency(String country) {
		if (country.equalsIgnoreCase("India")) {
			return new Rupee();
		} else if (country.equalsIgnoreCase("Singapore")) {
			return new SGDDollar();
		} else if (country.equalsIgnoreCase("US")) {
			return new USDollar();
		}
		throw new IllegalArgumentException("No such currency");
	}
}

public class FactoryDesignPatternSampleCode {
	public static void main(String args[]) {
		Currency rupee = CurrencyFactory.createCurrency("India");
		System.out.println(rupee.getSymbol());
	}
}
