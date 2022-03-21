import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Intentory {

    // Need to restock items

    public Map<String, Items> itemsFromFile() {
        File file = new File(DEFAULT_FILE);
        try (Scanner itemScanner = new Scanner(file)) {
            while (itemScanner.hasNextLine()) {
                String line = itemScanner.nextLine();
                String[] itemDetails = line.split("\\|");
                allItems.put(itemDetails[0], new Items(itemDetails[0], itemDetails[1], itemDetails[2], itemDetails[3], items.getQuantity(), items.getIsInStock()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("error" + e.getMessage());
        } return allItems;
    }

    public void displayItem() {
        for (Map.Entry<String, Items> item : allItems.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue().getName() + " " + item.getValue().getPrice() + " " + items.getQuantity());
        }

        public void restockItems() {
            for (Map.Entry<String, Items> item : allItems.entrySet()) {
                item.getValue().getQuantity() = 5;
            }
        }
}
