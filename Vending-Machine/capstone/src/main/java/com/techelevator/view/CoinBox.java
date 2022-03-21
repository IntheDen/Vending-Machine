package com.techelevator.view;

public class CoinBox {

    public int balance;   // MONEY INSERTED PER PURCHASE CYCLE
    private int revenue;  //MONEY LEFT AFTER TRANSACTION (MONEY INSERTED - CHANGE)

    public CoinBox() {
        balance = 0;
    }

    public void addMoney(int amountToDeposit) {
        balance = balance + (amountToDeposit * 100);
    }

    //FORMATTING STRING BALANCE
    public String getBalanceString() {
        int balanceInt = balance;
        double balanceDouble = (balanceInt / 100.00);
        String balanceString = "$" + String.format("%.2f", balanceDouble);
        return balanceString;
    }
    //GETTERS
    public int getBalance() { return balance; }

    public int getRevenue() { return revenue; }

    //SETTERS
    public void setBalance(int balance) { this.balance = balance; }

    public void setRevenue(int revenue) { this.revenue = revenue; }

}

