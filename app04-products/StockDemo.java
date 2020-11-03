/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Nerizza Flores
 * @version 30/10/2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(132, "Clock Radio"));
        manager.addProduct(new Product(37,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "Microwave Oven"));
        manager.addProduct(new Product(21, "TV"));
        manager.addProduct(new Product(20, "Speaker"));
        manager.addProduct(new Product(22, "Printer"));
        manager.addProduct(new Product(24, "Headphone"));
        manager.addProduct(new Product(25, "Tissue"));
        manager.addProduct(new Product(26, "Keyboard"));
        manager.addProduct(new Product(27, "Facemask"));
    }

    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        // Show details of all of the products.
        manager.printAllProduct();

        // Take delivery of 5 items of one of the products.
        manager.delivery(132, 10);
        manager.delivery(37, 5);
        manager.delivery(23, 23);
        manager.delivery(21, 30);
        manager.delivery(20, 15);
        manager.delivery(22, 7);
        manager.delivery(24, 28);
        manager.delivery(25, 32);
        manager.delivery(26, 12);
        manager.delivery(27, 50);

        manager.printAllProduct();
    }

    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);

        if(product != null) 
        {
            product.printProductdetails();
        }
    }

    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);

        if(product != null) 
        {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }

    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);

        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }

}
