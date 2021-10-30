
import java.util.Scanner;
import java.io.*;


public class DatabaseInput {

    /**
     * DatabaseInput will read the files from each inventory database
     * and store the data in to the assigned InventorySystem.
     * @param Inventory The InventorySystem contain the information of inventories.
     */

    public DatabaseInput(InventorySystem Inventory){
        InputDatabase(new File("src/main/java/Database/Meat Database"), Inventory);
        InputDatabase(new File("src/main/java/Database/Vegetables and Fruits Database"), Inventory);
        InputDatabase(new File("src/main/java/Database/Household Supplies Database"), Inventory);

    }

    /** A method help to store data from database.
     * @param FileName The file's path name.
     * @param Inventory The InventorySystem stores the data.
     */

    private void InputDatabase(File FileName, InventorySystem Inventory) {
        try {
            Scanner ReadDatabase;
            try {
                ReadDatabase = new Scanner(FileName);
                while (ReadDatabase.hasNext()) {
                    String ProductName = ReadDatabase.nextLine();
                    float Price = Float.parseFloat(ReadDatabase.nextLine());
                    ReadDatabase.nextLine();
                    int Stock = Integer.parseInt(ReadDatabase.nextLine());
                    Product NewProduct = new Product(ProductName, Price, Stock);
                    Inventory.setInventory(NewProduct);
                    if (ReadDatabase.hasNext()) {
                        ReadDatabase.nextLine();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
