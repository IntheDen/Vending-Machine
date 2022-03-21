import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.String.join;


public class Sandbox {
    public static void main(String[] args) {
/*
        // A METHOD TO REPLACE ALL PIPES IN A STRING WITH WHITE SPACES
        String test = "Removing|the|last|word";
        String noPipes = test.replaceAll("\\|", " ");
        String firstWords = noPipes.substring(0, noPipes.lastIndexOf(" "));
        System.out.println(firstWords);*/



        //private static final File inputFile: "target/inputFile.txt"
        //private Map<String, Item> allItems = new HashMap();

        //CREATE ITEM OBJECTS

    //File allItemsFile = new File("target/inputFile.txt");
		try(Scanner fileScanner = new Scanner(new File("target/inputFile.txt."));) {
             while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //String nPipes = line.replaceAll("\\|", " ");
                //String onlyFirstWords = nPipes.substring(0, nPipes.lastIndexOf(" "));
                //System.out.println(onlyFirstWords);*/
                 //String itemLine = fileScanner.nextLine();
                 String[] itemProperties = line.split("\\|");
                 //String displayItems = Arrays.toString(itemProperties).substring(1, displayItems.length()-1);
                 StringBuilder stringBuilder = new StringBuilder();
                 for (int i = 0; i < itemProperties.length; i++) {
                     stringBuilder.append(itemProperties[i]).join;
                 }
                 String displayItem = stringBuilder.toString();
                 System.out.println(displayItem);
                 //[ A1  PotatoCrisp  3.05  Chips]
                //allItems.put(itemProperties(0), new Item((itemPtoperties(0),itemPtoperties(1), itemPtoperties(2), itemPtoperties(3)));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

      /*  String[] strArray = { "Convert", "Array", "With", "Java" };
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
        }
        String joinedString = stringBuilder.toString();
        assertEquals("ConvertArrayWithJava", joinedString);*/

        }



    }
