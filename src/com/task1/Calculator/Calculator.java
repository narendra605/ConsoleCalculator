package com.task1.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

class CalculatorOperations {

	public double add(double a, double b) {
		return a + b;
	}

	public double subtract(double a, double b) {
		return a - b;
	}

	public double multiply(double a, double b) {
		return a * b;
	}

	public double divide(double a, double b) {
		if (b == 0) {
			System.out.println("Error: Cannot divide by zero");
		}
		return a / b;
	}

}

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //creating instance of the CalculatorOperations
        CalculatorOperations operations = new CalculatorOperations();
        boolean continueCalc = true;

        System.out.println("=== Welcome to Console Calculator ===");

        while (continueCalc) {
            System.out.println("\nEnter an operation (+, -, *, /) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                continueCalc = false;
                System.out.println("Calculator exiting. Goodbye!");
                break;
            }

            try {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean validOperation = true;

                // Using if-else instead of switch
                if (operation.equals("+")) {
                    result = operations.add(num1, num2);
                } else if (operation.equals("-")) {
                    result = operations.subtract(num1, num2);
                } else if (operation.equals("*")) {
                    result = operations.multiply(num1, num2);
                } else if (operation.equals("/")) {
                    result = operations.divide(num1, num2);
                } else {
                    validOperation = false;
                    System.out.println("Invalid operation! Please enter +, -, *, / or 'exit'");
                }

                if (validOperation) {
                    System.out.println("Result: " + result);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numeric values only.");
             // clear invalid input
                scanner.next(); 
            }
        }

        scanner.close();
    }
}