package com.techelevator.view;

import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VendingMachine {


    private CoinBox vendingMachineCoinBox;
    private Logger logger;
    private Inventory inventory;
    private Menu menu;

   //CONSTRUCTOR
    public VendingMachine() {
        vendingMachineCoinBox = new CoinBox();
        //inventory = new Inventory();
        logger = new Logger();
        menu = new Menu(System.in, System.out);
    }

    //FEEDING MONEY
    public void feedMoney(int billInserted) {
        vendingMachineCoinBox.addMoney(billInserted);
        String billInsertedAsString = "$" + billInserted + ".00";
        logger.logEvent("Feed Money", billInsertedAsString, getBalanceString());

    }

    //BALANCE
    public String getBalanceString() {
        String returnString = vendingMachineCoinBox.getBalanceString();
        return returnString;
    }



    //>>>>>>>>>>>>>NOT TESTED YET UNTIL SELECT ITEM METHOD ERROR IS FIXED>>>>>>>>>>>>>
    //MAKING A PURCHASE
    public void makePurchase() {
        int itemPrice = Integer.parseInt(inventory.getItemSelected().getPrice()) * 100;
        int newBalance = vendingMachineCoinBox.getBalance() * 100;        //MONEY REMAINING (FROM BEFORE) + MONEY INSERTED
        int itemQuantity = inventory.getItemSelected().getQuantity();     //QUANTITY OF THE ITEM
        String itemName = inventory.getItemSelected().getName();          //ITEM NAME
        int totalRevenue = vendingMachineCoinBox.getRevenue();            //WHAT'S COLLECTED IN THE COIN BOX

        if (itemPrice > newBalance) {
            System.out.println(itemName + " is  $" + itemPrice + ". Please add: " + (itemPrice - newBalance));
        } else {
            int updateBalance = newBalance - itemPrice;                   //UPDATING BALANCE
            vendingMachineCoinBox.setBalance(updateBalance);              //SETTING BALANCE (MONEY REMAINING TOWARDS ANOTHER PURCHASE)
            totalRevenue += itemPrice;                                    //ADDING ITEM PRICE TO COIN BOX REVENUE
            vendingMachineCoinBox.setRevenue(totalRevenue);               // SETTING COIN BOX REVENUE TO totalRevenue
            System.out.println("Dispensing " + itemName + ",  $" + itemPrice + ". Money Remaining: $" + updateBalance);
            System.out.println(inventory    .getItemSelected().getMessage());
            int currItemQuantity = itemQuantity - 1;                      //UPDATING ITEM QUANTITY
            inventory.getItemSelected().setQuantity(currItemQuantity);    //SETTING ITEM QUANTITY TO THE UPDATE
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








