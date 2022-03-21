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

    public String getBalanceString() {
        int currBalanceI = balance;
        double currBalanceD = (currBalanceI / 100.00);
        String currBalanceString = "$" + String.format("%.2f", currBalanceD);
        return currBalanceString;
    }
   //GETTERS
    public int getBalance() { return balance; }

    public int getRevenue() { return revenue; }

   //SETTERS
    public void setBalance(int balance) { this.balance = balance; }

    public void setRevenue(int revenue) { this.revenue = revenue; }

    /*

    private int totalMoney;
    private int totalSale;
    private int feedMoney;
    private int change;

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getTotalSale() {
        return totalSale;
    }

    public int getFeedMoney() {
        return feedMoney;
    }

    public int getChange() {
        return change;
    }
    //give change
    //update total (derived)
    //empty to bank account
    //return change (smallest coins)
*/
}

