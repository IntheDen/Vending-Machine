package com.techelevator;

import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	// MAIN MENU OPTIONS
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	// PURCHASE OPTIONS
	private static final String PURCHASE_MENU_OPTIONS_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTIONS_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION = "Finish Transaction";

	// MENU COLLECTION
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTIONS_FEED_MONEY, PURCHASE_MENU_OPTIONS_SELECT_PRODUCT, PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION};


	private Menu menu;
	private Inventory inventory;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		inventory = new Inventory();
	}

	public void run() {

		String[] activeMenu = MAIN_MENU_OPTIONS;

		boolean run = true;

		while (run) {
			String userChoice = (String) menu.getChoiceFromOptions(activeMenu);

			if (userChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.itemsFromFile();
				inventory.displayItem();
			} else if (userChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				activeMenu = PURCHASE_MENU_OPTIONS;
			} else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
				run = false;
			} else if (userChoice.equals(PURCHASE_MENU_OPTIONS_FEED_MONEY)) {
				 menu.feedMoney();
			} else if (userChoice.equals(PURCHASE_MENU_OPTIONS_SELECT_PRODUCT)) {
				inventory.getItemSelected();
			} else if (userChoice.equals(PURCHASE_MENU_OPTIONS_FINISH_TRANSACTION)) {
				activeMenu = MAIN_MENU_OPTIONS;
			}

		}
	}
// Click (1) Vending machine item
	// display Items in stock, quantity left,


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		cli.run();
	}

}
