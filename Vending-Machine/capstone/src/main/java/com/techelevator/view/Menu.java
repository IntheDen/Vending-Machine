package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private VendingMachine vendingMachine = new VendingMachine();

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.println("Current Vending Machine Balance " + displayCurrentBalance());
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public void feedMoney() {
		System.out.println("Please Insert $1, $2, $5, or $10 Bills");
		try {
			int moneyInsert = in.nextInt();
			in.nextLine();
			if (moneyInsert == 1 || moneyInsert == 2 || moneyInsert == 5 || moneyInsert == 10) {
				vendingMachine.feedMoney(moneyInsert);
				System.out.println("Thank You For inserting $" + moneyInsert + " dollar");
			} else {
				System.out.println("Please Insert Only $1, $2, $5, or $10 Bills");
			}
		} catch (Exception e) {
			System.out.println("Please Insert Only $1, $2, $5, or $10 Bills");
		}
	}

	public String displayCurrentBalance() {
		return vendingMachine.getBalanceString();
	}

}

