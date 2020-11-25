
import java.util.ArrayList;
import java.util.*;
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Nerizza Flores
 * @version 0.1 (15/11/20)
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    private StockManager manager = new StockManager();
    private Product product;
    private ArrayList<Product> stock;
    public static final String ADD = "add";
    public static final String REMOVE ="remove";
    public static final String DELIVER = "deliver";
    public static final String SELL = "sell";
    public static final String PRINT_ALL = "printall";
    public static final String SEARCH = "search";
    public static final String LOW_STOCK = "lowstock";
    public static final String RESTOCK = "restock";
    public static final String QUIT = "quit";

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        StockManager manager = new StockManager();
    }

    /**
     * Run the program of the StockApp
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }

    /**
     * @return The program menu choices.
     */
    public void getMenuChoice()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = input.getString().toLowerCase();

            if(choice.equals(QUIT)){
                finished = true;
            }   
            else 
                executeMenuChoices(choice);
        }
    }

    /**
     * Execute the menu of the program. 
     * @param choice is the choice we input.
     */
    private void executeMenuChoices(String choice){
        if(choice.equals(ADD)){             
            executeAdd();
        }
        else if (choice.equals(REMOVE)){
            executeRemove();
        }
        else if(choice.equals(DELIVER)){
            executeDeliver();
        }
        else if(choice.equals(SELL)){
            executeSell();
        }
        else if(choice.equals(PRINT_ALL)){
            manager.printAllProduct();
        }
        else if(choice.equals(SEARCH)){
            executeSearch();
        }
        else if(choice.equals(LOW_STOCK)){
            manager.findLowStock();
        }
        else if(choice.equals(RESTOCK)){
            manager.refillStock();
        }
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Deliver:    Deliver a quantity of product");
        System.out.println("    Sell:       Sell a quantity of product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Search:     For product by name");
        System.out.println("    Low Stock:  List all low stock products");
        System.out.println("    Re-Stock:   All the low stock items");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Nerizza Flores");
        System.out.println("******************************");
    }

    /**
     * Execute the add method. Add a new product with ID and name of the product. 
     */
    private void executeAdd(){ 
        System.out.println("Please input the id of the product"); 
        String value = input.getString(); 
        int id = Integer.parseInt(value);

        if(manager.findProduct(id) != null) 
        {
            System.out.println("Duplicate id entered"); 
            System.out.println("Try Again"); 
        } 
        else 
        {
            System.out.println("Please input the name of the product");     
            String name = input.getString(); 
            Product product = new Product(id, name); 
            manager.addProduct(product); 
            System.out.println("Product " + product.getID() + ", " + product.getName()  + " has been added");
        }
    }

    /**
     * Execute the remove method. Remove a product based on the ID.
     */
    private void executeRemove(){
        System.out.println("Please input the id of the product you want to remove");
        String value = input.getString();
        int id = Integer.parseInt(value);
        manager.removeProduct(id);
    }

    /**
     * Execute the delivery method. 
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     */
    private void executeDeliver(){
        System.out.println("Please input the ID of the product you want to deliver");
        String value = input.getString();
        int id = Integer.parseInt(value);

        System.out.println("Please input the amount to deliver");
        String quantity = input.getString();
        int amount = Integer.parseInt(quantity);

        manager.delivery(id, amount);
    }

    /**
     * Execute the search method. 
     * Search a product based on their name and print the list. 
     */
    private void executeSearch(){
        System.out.println("Please input the name of the product you want to search");
        String name = input.getString();
        manager.findProductName(name);
    }

    /**
     * Execute the search method. 
     * Search a product based on their name and print the list. 
     */
    private void executeSell(){
        System.out.println("Please input the ID of the product you want to sell");
        String value = input.getString();
        int id = Integer.parseInt(value);

        System.out.println("Please input the amount to sell");
        String quantity = input.getString();
        int sell = Integer.parseInt(quantity);

        manager.sell(id, sell);
    }
}
