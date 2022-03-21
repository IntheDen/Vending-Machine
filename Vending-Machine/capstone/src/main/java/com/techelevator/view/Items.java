package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Items {

    private String slot;
    private String name;
    private String price;
    private String type;
    private String message;
    private int quantity;
    private boolean isInStock;



    public Items(String slot, String name, String price, String type) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Items(String slot, String name, String price, String type, String message, int quantity, boolean isInStock) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.isInStock = false;
    }

    public String getSlot() { return slot; }

    public String getName() { return name; }

    public String getPrice() { return price; }

    public String getType() { return type; }

    public String getMessage() { return message; }

    public int getQuantity() { return quantity; }

    public boolean isInStock() { return isInStock; }






}
