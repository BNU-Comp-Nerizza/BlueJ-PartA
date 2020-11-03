import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Nerizza Flores
 * @version 30/10/2020
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
        for (Product product: stock)
        {
            if (product.getID() == id)
            {
                product.increaseQuantity(amount);
                product.printProductdetails();
            }
        }
    }

    /** Rename a product based on the ID
     */
    public void renameProduct(int id, String replaceName)
    {
        for (Product product: stock)
        {
            if (product.getID() == id)
            {
                product.setName(replaceName);
            }
            else if (product.getID() != id)
            {
                System.out.println("Product " + id + " is not on the list");
            }
        }
    }

    /** Remove a product based on the ID
     */
    public void removeProduct(int id) 
    {
        for(int i=0; i<stock.size(); i++) 
        {
            if(stock.get(i).getID() == id) 
            {
                stock.remove(i);
            }
            else if (stock.get(i).getID() != id)
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
                product.printProductdetails();
                return product;
            }
            else if (product.getID() != id)
            {
                System.out.println("Product " + id + " is not on the list");
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
        for (Product product: stock)
        {
            if (product.getID() == id)
            {
                return quantity;
            }
            else if (product.getID() != id)
            {
                return 0;
            }
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
            if(product.getName().startsWith(name))
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
}
