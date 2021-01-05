/**
 * Class Item - a items in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Item" represents item in the room of the game. 
 * The item class contains the description of the item. 
 *
 * @author  Nerizza Flores
 * @version 2020.12.14 
 */
public class Item
{
    // instance variables of the item
    private String itemName;
    private String itemDescription;
    private int itemWeight;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        itemDescription ="";
        itemName ="";
        itemWeight = 0;
    }

    /**
     * Constructor for class Item 
     * @param description of the item
     * @param name of the item
     * @param weight of the item
     */
    public Item(String description, String name, int weight)
    {
        itemDescription = description;
        itemName = name;
        itemWeight = weight;
    }

    /**
     * Returns the description of the items 
     * @return info of the item including name, description and weight
     */
    public String getItemDescription()
    {
        String itemDes = "\t" + "Item Name: "; itemDes += this.itemName + "\n"; 
        itemDes+= "\t" + "Item Description: " + this.itemDescription + "\n";
        itemDes += "\t" + "Item Weight: " + this.itemWeight;
        return itemDes;
    }

    /**
     * @return the item name
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * @return the item description
     */
    public String getDescriptionofItem()
    {
        return itemDescription;
    }

    /**
     * @return the item weight
     */
    public int getWeight()
    {
        return itemWeight;
    }
}
