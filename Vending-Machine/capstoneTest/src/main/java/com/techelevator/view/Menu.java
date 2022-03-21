package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import com.techelevator.view.Inventory;

public class Menu {

	private VendingMachine vendingMachine = new VendingMachine();
	private Inventory inventory;

	private PrintWriter out;
	private Scanner in;
	private CoinBox vendingMachineCoinBox;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		inventory = new Inventory();
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
			int moneyInserted = in.nextInt();
			in.nextLine();
			if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10) {
				vendingMachine.feedMoney(moneyInserted);
				System.out.println("Thank You For inserting $" + moneyInserted + " dollar");
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



        public Inventory getItemSelected() {
	inventory.getAllItems();
	String userValue = "";
	Inventory selectedItem;
	System.out.print("Select the slot of the item you wish to purchase >>> ");
	try {
		userValue = in.nextLine();  //get user choice of slot
		while (!inventory.getAllItems().containsKey(userValue)) {
			System.out.println("This is not a valid slot");
			inventory.displayItem();
			System.out.print("Please select the slot for the item you wish to purchase >>> ");
			userValue = in.nextLine();
		}
		if (!inventory.getAllItems().get(userValue).getIsInStock()) {   // => Sold out
			System.out.println(inventory.getAllItems().get(userValue).getName() + " is SOLD OUT");
		} else {
			selectedItem = inventory.getAllItems().get(userValue);
			System.out.println("You selected " + selectedItem.getSlot() + " " + selectedItem.getName() + " " + selectedItem.getPrice()); //Selection is valid, report back the selected item
		}
	} catch (Exception e) {
		System.out.println("Please select an item.");
		System.out.println();
	}
	return inventory.getAllItems().get(userValue);
}

	public void makePurchase() {
		int itemPrice = Integer.parseInt(getItemSelected().getPrice()) * 100;
		int newBalance = vendingMachineCoinBox.getBalance() * 100;        //MONEY REMAINING (FROM BEFORE) + MONEY INSERTED
		int itemQuantity = getItemSelected().getQuantity();     //QUANTITY OF THE ITEM
		String itemName = getItemSelected().getName();          //ITEM NAME
		int totalRevenue = vendingMachineCoinBox.getRevenue();            //WHAT'S COLLECTED IN THE COIN BOX

		if (itemPrice > newBalance) {
			System.out.println(itemName + " is  $" + itemPrice + ". Please add: " + (itemPrice - newBalance));
		} else {
			int updateBalance = newBalance - itemPrice;                   //UPDATING BALANCE
			vendingMachineCoinBox.setBalance(updateBalance);              //SETTING BALANCE (MONEY REMAINING TOWARDS ANOTHER PURCHASE)
			totalRevenue += itemPrice;                                    //ADDING ITEM PRICE TO COIN BOX REVENUE
			vendingMachineCoinBox.setRevenue(totalRevenue);               // SETTING COIN BOX REVENUE TO totalRevenue
			System.out.println("Dispensing " + itemName + ",  $" + itemPrice + ". Money Remaining: $" + updateBalance);
			System.out.println(getItemSelected().getMessage());
			int currItemQuantity = itemQuantity - 1;                      //UPDATING ITEM QUANTITY
			getItemSelected().setQuantity(currItemQuantity);    //SETTING ITEM QUANTITY TO THE UPDATE
			//NEED TO ADD A LINE IN THE LOG
		}
		//SEND CUSTOMER BACK TO PURCHASE MENU
	}

	//CALCULATE AND RETURN CHANGE
	public void finishTransaction() {  //NOT SURE WHAT THE ISSUE IS HERE
		int quarters;
		int dimes;
		int nickels;
		int totalChange1 = (vendingMachineCoinBox.getBalance());
		quarters = totalChange1 / 25;
		int totalChange2 = totalChange1 % 25;
		dimes = totalChange2 / 10;
		int totalChange3 = totalChange2 % 10;
		nickels = totalChange3 / 5;
		System.out.println("Your change is: " + totalChange1 + ": " +  quarters + "Quarters, " + dimes + " Dimes, " + nickels + " Nickels.");
		System.out.println("Thank you for shopping!");
		vendingMachineCoinBox.setBalance(0);

	}
}

