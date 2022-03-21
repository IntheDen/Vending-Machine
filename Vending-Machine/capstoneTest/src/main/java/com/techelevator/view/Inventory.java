package com.techelevator.view;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private static final String DEFAULT_FILE = "vendingmachine.csv";

    //PROPERTIES
    private String inputFile = DEFAULT_FILE;
    private String slot;
    private String name;
    private String price;
    private String type;
    private String message;
    private boolean isInStock;
    private int quantity;
    public static Map<String, Inventory> allItems = new LinkedHashMap<>();
    private VendingMachine vendingMachine;
    private Menu menu;



    //GETTER
    public String getSlot() { return slot; }

    public String getName() { return name; }

    public String getPrice() { return price; }

    public String getMessage() { return message; }

    public int getQuantity() { return quantity; }

    public boolean getIsInStock() { return isInStock; }

    public boolean isInStock() { return isInStock; }

    public Map<String, Inventory> getAllItems() { return allItems; }

    //SETTERS

    public void setInStock() {
        if (quantity > 0) {
            isInStock = true;
        } else isInStock = false;
    }

        public void setQuantity ( int quantity){
            this.quantity = quantity;
        }

        public void setAllItems (Map < String, Inventory > allItems){
            this.allItems = allItems;
        }

        public void setMessage(String s) {
        this.message = message;
        }


        //DEFAULT CONSTRUCTORS
    public Inventory() {};

        //Constructor
    public Inventory(String slot, String name, String price, String type, int quantity, boolean isInStock, String
        message){
            this.slot = slot;
            this.name = name;
            this.price = price;
            this.type = type;
            this.quantity = quantity;
            this.isInStock = true;
            this.message = message;
            this.menu = new Menu(System.in, System.out);
        }


        // CREATING A MAP FROM FILE, KEY = SLOT, VALUE = ITEM OBJECT

        public Map<String, Inventory> itemsFromFile () {
            File file = new File(DEFAULT_FILE);
            try (Scanner itemScanner = new Scanner(file)) {
                while (itemScanner.hasNextLine()) {
                    String line = itemScanner.nextLine();
                    String[] itemDetails = line.split("\\|");
                    allItems.put(itemDetails[0], new Inventory(itemDetails[0], itemDetails[1], itemDetails[2], itemDetails[3], quantity, isInStock, message));
                }
            } catch (FileNotFoundException e) {
                System.out.println("error" + e.getMessage());
            }
            return allItems;
        }

        //DISPLAYING ITEMS IN VENDING MACHINE CLI
        public void displayItem () {
            for (Map.Entry<String, Inventory> item : allItems.entrySet()) {
                System.out.println(item.getKey() + " " + item.getValue().getName() + " " + item.getValue().getPrice() + " " + item.getValue().getQuantity());
            }
        }

        //RESTOCKING ALL ITEMS
        public void restockAllItems () {
            for (Map.Entry<String, Inventory> item : allItems.entrySet()) {
                int currentQuantity = item.getValue().getQuantity();
                item.getValue().setQuantity(5 - currentQuantity);
                item.getValue().setInStock();
            }
    }

        //>>>>>>>>  THIS WORKS IN DEBUGGER, BUT INVOKES MENU NULL ERROR IN RUN>>>>>>>>>>
        //SELECTING AN ITEM ==>> ERROR SCANNER INVOKES MENU METHOD NULL EXCEPTION
           public Inventory getItemSelected () {
            String userValue = "";
            try (Scanner itemScanner = new Scanner(System.in)){
                System.out.print("Select the slot of the item you wish to purchase");
                userValue = itemScanner.nextLine();  //get user choice of slot
                while (!allItems.containsKey(userValue)) {
                    System.out.println("This is not a valid slot");
                    displayItem();
                    System.out.print("Please select the slot for the item you wish to purchase");
                    userValue = itemScanner.nextLine();
                }
                if (!allItems.get(userValue).getIsInStock()) {   // => Sold out
                    System.out.println(allItems.get(userValue).getName() + " is SOLD OUT");
                } else {
                    System.out.println("You selected " + allItems.get(userValue).getSlot() + " " + allItems.get(userValue).getName() + " " + allItems.get(userValue).getPrice());
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Input: " + nfe.getMessage());
                System.out.println();
            }
            return allItems.get(userValue);
        }

        // SETTING SOUND MESSAGES FOR ITEMS
        public LinkedHashMap<String, Inventory> soundMessage () {
            for (Map.Entry<String, Inventory> item : allItems.entrySet()) {
                if (item.getValue().type.equalsIgnoreCase("Drink")) {
                    item.getValue().setMessage("Glug Glug, Yum!");
                }
                if (item.getValue().type.equalsIgnoreCase("Chip")) {
                    item.getValue().setMessage("Crunch Crunch, Yum!");
                }
                if (item.getValue().type.equalsIgnoreCase("Candy")) {
                    item.getValue().setMessage("Munch Munch, Yum!");
                }
                if (item.getValue().type.equalsIgnoreCase("Gum")) {
                    item.getValue().setMessage("Chew Chew, Yum!");
                } else item.getValue().setMessage("");
            }
            return (LinkedHashMap<String, Inventory>) allItems;
        }

    }














