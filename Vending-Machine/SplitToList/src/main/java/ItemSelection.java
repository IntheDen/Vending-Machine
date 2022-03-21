import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

public class ItemSelection {


    public static void main(String[] args) {

        // Map<String, SelectedItems> toPurchase = new HashMap<>(); //This will be a private property in Transaction / CoinBox
        public void selectItem() {
            String userValue = "";
            try {
                inventory.displayItem();
                String userInput = in.nextLine();  //get user choice of slot
                while(!inventory.getAllItems().containsKey(userValue)) {     //Check that there is a key in the allItems Map that matches user Choice. If not prompt again
                    System.out.print("Please enter the slot number of the item you wish to purchase");
                    inventory.displayItem();
                    userValue = userInput.nextLine();
                }
                if(inventory.getAllItems().get(userValue).getIsInStock() == false) {   // => Sold out
                    System.out.println(inventory.getAllItems().get(userValue).getName() + " is SOLD OUT");
                    //RETURN TO PURCHASE MENU
                } else {
                    System.out.println("You selected " + inventory.getAllItems().get(userValue)); //Selection is valid, report back the selected item
                    //RETURN TO PURCHASE MENU
                }
                //send them back to purchase menu
            }catch(NumberFormatException nfe){
                System.out.println("Invalid Input: " + nfe.getMessage());
                System.out.println();
                userValue = "";
            }

            //RESTOCKING
            public void restockAllItems() {
                for(Map.Entry item : allItems.entrySet()) {
                  int currentQuantity = item.getQuantity();
                    item.getQuantity() += (5 - currentQuantity);
                    item.getIsInStock() = true;
                }
        }

        //PURCHASE
        public void makePurchase() {
                int totalCost = 0;
            for(Map.Entry item : allItems.entrySet()) {
                totalCost += item.getPrice();
            }
            if (totalCost > cashToPurchase) {
                System.out.println("");
            }
        }
        }
    }

