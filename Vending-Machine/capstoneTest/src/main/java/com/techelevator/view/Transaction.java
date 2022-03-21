package com.techelevator.view;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


import static java.lang.System.out;

public class Transaction {
    private boolean isTransaction;  //transaction is over, enough money fed, sold out,(cancel), item doesn't exist
    private int inputMoney;
    private int totalSale;
    private int change;
    private boolean balance = false;

    private PrintWriter out;
    private Scanner in;
    private Inventory inventory;

        public Transaction(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(System.in);
    }
        // start balance with 0 prompt user for money
        // if balance is < cost then prompt to deposit money whole dollar amounts.
        // display balance after deposit money
        // if selected item is sold, update balance,
        // update inventory + balance
        // display balance, item, type message
        // customer is returned to purchase menu
        // if sold out prompt an error + change nickles, dimes, quarters

//    public void getFeedMoney() {
//        System.out.print("Please use only $1, $2, $5 or $10 bills");
//    }

//        public void purchase() {
//        }
        public int getBillFromUserInput() {
            int inputMoney = 0;
            try {
                inputMoney = Integer.valueOf(in.nextLine());
                if (inputMoney != 1 && inputMoney != 2 && inputMoney != 5 && inputMoney != 10) {
                    inputMoney = 0;
                    System.out.print("Money rejected. Use $1, $2, $5 or $10 bills");
                }
            } catch (Exception e) {
                System.out.println("error" + e.getMessage());
            } finally {
                return inputMoney;
            }
        }



}


//    public void audit(){} // send information to audit file log.txt
        // local time/date - Feed money, item, give change

//    public void salesReport(){} // send information of the item and total amount $$ sold

