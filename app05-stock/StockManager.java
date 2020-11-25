import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Nerizza Flores
 * @version 15/11/2020
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    private Product product;
    private int quantity;
    private String name;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        {
            if (product != null)
            {
                product.increaseQuantity(amount);
                product.printProductdetails();
            }
            else 
            {
                System.out.println("Product " + id + " is not on the list");
            }
        }
    }

    /**
     * Sell a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void sell(int id, int amount)
    {
        Product product = findProduct(id);
        {
            if (product != null)
            {
                if (amount < 0)
                {
                    System.out.println("The amount must be a positive number!");
                }
                else if (amount > 0) 
                {
                    product.sellMultiple(amount);
                }
            }
            else 
            {
                System.out.println("Product " + id + " is not on the list");
            }
        }
    }

    /** Rename a product based on the ID
     */
    public void renameProduct(int id, String replaceName)
    {
        Product product = findProduct(id);
        {
            if(product != null) 
            {
                product.setName(replaceName);
                System.out.println("Product " + product + " have been changed");
            }
            else 
            {
                System.out.println("Product " + id + " is not on the list");
            }
        }
    }

    /** Remove a product based on the ID
     */
    public void removeProduct(int id) 
    {
        Product product = findProduct(id);
        {
            if(product != null) 
            {
                stock.remove(product);
                System.out.println("Product " + product + " have been successfully removed");
            }
            else 
            {
                System.out.println("Product " + id + " is not on the list");
            }
        }
    } 

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {       
        for (Product product: stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }
        return null;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product product = findProduct(id);
        if(product != null) 
        {
            return quantity;
        } 
        else
        {
            System.out.println("Product " + id + " is not on the list");
        }
        return quantity;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }

    /**
     * Print details of all the products.
     */
    public void printAllProduct()
    {
        System.out.println();
        System.out.println("Peacock's Stock List");
        System.out.println("====================");
        System.out.println();

        for (Product product: stock)
        {
            if(product != null)
            {
                System.out.println(product.toString());
            }
        }

    }

    /**
     * Print a list of products based on part of the product name
     */
    public void findProductName(String name)
    {
        for (Product product: stock)
        {
            if(product.getName().contains(name))
            {
                product.printProductdetails();
            }
        }
    }

    /**
     * Print a list of products whose stock levels are low
     */
    public void findLowStock()
    {
        for (Product product: stock)
        {
            if(product.getQuantity() <= 5)
            {
                product.printProductdetails();
            }
        }
    }

    /**
     * Refill products whose stock levels are low
     */
    public void refillStock()
    {
        for (Product product: stock)
        {
            if(product.getQuantity() <= 5)
            {
                product.increaseQuantity(5);
                System.out.println("Products have been refilled");
            }
        }
    }

}