package JavaBasicFinalByTariqur;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
	final static byte monthsInYear = 12;
	final static byte percent = 100;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double principle = inputNumber("Principle: ", 1000 , 200000);
		float annualInterestRate = (float) inputNumber("Annual Interest Rate: ", 1 , 12);
		byte period = (byte) inputNumber("Period (Years): ", 1 , 30);
		
		double mortgage = mortgageCalculator(principle, annualInterestRate, period);
		System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

		System.out.println();
		System.out.println("Payment Schedule");
		System.out.println("----------------");
		for (short month = 1; month <= period * monthsInYear; month++) {
			double balance = balanceCalculator(principle, annualInterestRate, period, month);
			System.out.println(NumberFormat.getCurrencyInstance().format(balance));
		}
	}
	
	public static double inputNumber (String label, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while(true) {
			System.out.print(label);
			value = scanner.nextDouble();
			if (value >= min && value <= max)
				break;
			System.out.println("Enter a number between " + (int) min + " to " + (int) max);
		}
		return value;
	}
	
	public static double mortgageCalculator(double principle, float annualInterestRate, byte period) {		
		float monthlyInterest = annualInterestRate / percent / monthsInYear;
		float installmentNumber = period * monthsInYear;
		
		double mortgage = principle * (monthlyInterest * Math.pow(1 + monthlyInterest, installmentNumber)) / (Math.pow(1 + monthlyInterest, installmentNumber) - 1);

		return mortgage;
	}
	
	public static double balanceCalculator(double principle, float annualInterestRate, byte period, short numberOfInstallmentsMade) {		
		float monthlyInterest = annualInterestRate / percent / monthsInYear;
		float installmentNumber = period * monthsInYear;
		
		double balance = principle * (Math.pow(1 + monthlyInterest, installmentNumber) - Math.pow(1 + monthlyInterest, numberOfInstallmentsMade)) / (Math.pow(1 + monthlyInterest, installmentNumber) - 1);
		
		return balance;
	}

}
