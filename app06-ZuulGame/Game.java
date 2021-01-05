import java.util.*;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Nerizza Flores 
 */

public class Game 
{
    private Parser parser;
    private Scanner reader;
    private Player player;
    private Room prevRoom;
    private Room roomStack[];
    private Room currentRoom;
    private Room finalRoom;
    private int top;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private static final String BATTERY = "battery";

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        reader = new Scanner (System.in);
        roomStack = new Room[100];
        top=-1;
    }

    /**
     * Create the player and sets the player name.
     */
    private void createPlayer()
    {
        System.out.println("Enter player name: ");
        String name = reader.nextLine();
        player.setPlayerName(name);
        createRooms();
    }

    /** 
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room staffRoom, storageRoom, navigationRoom, medicalBay, oxygenRoom, cafeteria, securityRoom, engineRoom;

        Item staffItem[] = {
                new Item("Just a pieace of clothes, No help at all.", "T-Shirt", 5),
                new Item("opened bag of chips","Chips", 5),
                new Item( "Helps rechared the engine", "Battery", 10)
            };

        Item storageItem[] = {
                new Item( "Dull kitchen knife for cutting foods","Knife",  10),
                new Item( "Used for working out","Dumbbell", 70),
                new Item( "Spare laptop in case of emergency", "Laptop", 8),
                new Item( "Helps rechared the engine", "Battery", 10)
            };

        Item navigationItem[] = {
                new Item( "A smartphone without any signal or battery.", "iPhone X",3),
                new Item( "Helps rechared the engine","Battery", 10),
                new Item( "Used to control the system cannot be carried", "Computer", 50),
                new Item( "Used to connect the computers", "Cables", 6)
            };

        Item medicalItem[] = {
                new Item( "Used for wounds", "Bandaid", 5),
                new Item( "just a simple old trash can. no use","Trash Can", 2),
                new Item( "Helps rechared the engine","Battery", 10),
                new Item( "Just a syringe","Syringe", 1)
            };

        Item oxygenItem[] = {
                new Item( "Store oxygen", "Oxygen Tank", 20),
                new Item( "Spare spacesuit for the crewmate","Spacesuit", 18),
            };    

        Item cafeteriaItem[] = {
                new Item("Fruits. That's all.","Apple",  3),
                new Item( "Fruits. That's all.","Banana", 3),
                new Item( "Fruits. That's all.","Orange", 3)
            };

        Item securityItem[] = {
                new Item( "Old Keys from Earth","Pair of Keys",1),
                new Item( "Helps rechared the engine","Battery", 10),
                new Item( "opened bag of chips","Chips", 2),
                new Item( "Just a pair of shoes","Shoes", 4)
            };

        Item engineItem[] = {
                new Item( "Main machine that runs the spaceship","Engine Machine", 20),
                new Item( "opened bag of chips","Chips", 2),
                new Item( "Just a pair of shoes","Shoes", 4)
            };

        // create the rooms
        staffRoom = new Room("in the Staff Room");
        storageRoom = new Room("in Storage Room");
        navigationRoom = new Room("in the Space Nagivation Room");
        medicalBay = new Room("in the Medical Bay");
        oxygenRoom = new Room("in the Oxygen Storage Room");
        cafeteria = new Room("in the Cafeteria");
        securityRoom = new Room("in the Space Security Room");
        engineRoom = new Room("in the Space Engine Room");

        staffRoom = addItemsToRoom(staffRoom, staffItem);
        storageRoom = addItemsToRoom(storageRoom, storageItem);
        navigationRoom = addItemsToRoom(navigationRoom, navigationItem);
        medicalBay = addItemsToRoom(medicalBay, medicalItem);
        oxygenRoom = addItemsToRoom(oxygenRoom, oxygenItem);
        cafeteria = addItemsToRoom(cafeteria, cafeteriaItem);
        securityRoom = addItemsToRoom(securityRoom, securityItem);
        engineRoom = addItemsToRoom(engineRoom, engineItem);

        // initialise room exits
        staffRoom.setExit("east", medicalBay);
        staffRoom.setExit("north", storageRoom);
        storageRoom.setExit("east", navigationRoom);
        storageRoom.setExit("south", staffRoom);
        medicalBay.setExit("west", staffRoom);
        medicalBay.setExit("north", navigationRoom);
        medicalBay.setExit("south", oxygenRoom);
        oxygenRoom.setExit("north", medicalBay);
        navigationRoom.setExit("west", storageRoom);
        navigationRoom.setExit("south", medicalBay);
        navigationRoom.setExit("east", cafeteria);
        cafeteria.setExit("west", navigationRoom);
        cafeteria.setExit("south", securityRoom);
        securityRoom.setExit("south", engineRoom);
        securityRoom.setExit("north", cafeteria);
        engineRoom.setExit("north", securityRoom);
        currentRoom = staffRoom;
        finalRoom = engineRoom;
        prevRoom = null;
    }

    /**
     * Add items to the room.
     */
    private Room addItemsToRoom(Room room, Item items[])
    {
        for (int i=0; i <items.length; i++)
        {
            room.addItem(items[i]);
        }
        return room;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        createPlayer();
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println("-----STORY-----");
        System.out.println("NASA have appointed you, " + player.getPlayerName() + " ,as the captain of the Jupiter Space Project \nOn the way to Jupiter, you encouter a huge meterorite that cause your spaceship \nto have an engine failure and landed into Mars. \n");

        System.out.println("-----OBJECTIVE-----");
        System.out.println("1. Find 5 batteries \n2. Use 5 Batteries to convert it as energy\n3. Once you find all batteries, go to the Engine Room. \n");

        System.out.println("-----PLAYER STATS-----");
        player.getPlayerDescription();

        System.out.println("-----COMMANDS-----");
        System.out.println("Type '" + CommandWord.HELP + "' to check the commands");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Calculates the score of the player when item is picked up
     */
    private int addScore()
    { 
        int score = 0;
        for (Item items: inventory)
        {
            score = score + items.getWeight();
        }
        player.setScore(score);
        System.out.println("Player Score: " + score);
        return score;
    }

    /**
     * Calculates the number of battery of the player within their inventory
     */
    private int countBattery()
    {
        int count = 0;
        for (Item items: inventory) {
            if (items.getItemName().compareToIgnoreCase("battery") == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Adds the current room to stack
     */
    private void push(Room room)
    {
        if(top == roomStack.length-1)
            System.out.println("Room stack is full");
        else
            roomStack[++top] = room;
    }

    /**
     * Deletes the room at the top of roomStack
     * @return Room if exists otherwise null.
     */
    private Room pop()
    {
        if(top < 0)
        {
            System.out.println("No previous room to go,");
            return null;
        }
        else
            return roomStack[top--];
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
            System.out.println("I don't know what you mean...");
            break;

            case HELP:
            printHelp();
            break;

            case GO:
            wantToQuit = goRoom(command);
            break;

            case LOOK:
            look();
            break;

            case BACK:
            backRoom();
            break;

            case INVENTORY:
            printInventory();
            break;

            case TAKE:
            takeItem(command);
            break;

            case DROP:
            dropItem(command);
            break;

            case USE:
            useItem(command);
            break;

            case STATS: 
            checkStats();
            break;

            case QUIT:
            wantToQuit = quit(command);
            break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the spaceship");
        System.out.println();
        System.out.println("-----OBJECTIVE-----");
        System.out.println("1. Find 5 batteries \n2. Use 5 Batteries to convert it as energy\n3. Once you find all batteries, go to the Engine Room. \n");
        System.out.println("-----COMMANDS-----");
        System.out.println("Your command words are:");
        System.out.println("\tGo (+ exit): \tGo will take you to your destination [i.e. 'go north' will take you to north exit]");
        System.out.println("\tQuit: \t\tit will directly end the game");
        System.out.println("\tHelp: \t\tit will print all the commands list");
        System.out.println("\tLook: \t\tit will look around the room and print all the list of items in the room");
        System.out.println("\tBack: \t\tit will take you back to the previous room");
        System.out.println("\tTake (+ item): \tit will take the items that you indicated");
        System.out.println("\tDrop (+item): \tit will drop the item that you indicated  within your inventory");
        System.out.println("\tInventory: \tcarries the list of the items that you have picked up");
        System.out.println("\tUse (+items): \tit will use the items that you have indicated. Note: using battery will convert as energy");
        System.out.println("\tStats: \t\tchecking the players stats including score and energy\n");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private boolean goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            push(currentRoom);
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            if (currentRoom == finalRoom && player.getEnergy() == 5)
            {
                System.out.println("Energy Full. System loading... Security on. Power on. Destination.. Jupiter.");
                System.out.println("Thank you for your hardwork, Captain " + player.getPlayerName());
                return true;
            }
        }
        return false;
    }

    /**
     * Print the details of the current room
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Player goes to the previos room and display its information
     */
    private void backRoom()
    {
        currentRoom = pop();
        if(currentRoom != null)
            System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Prints out the list of items that the player has taken
     */
    private void printInventory()
    {
        String output = "";
        for (int i=0; i < inventory.size(); i++)
        {
            output += inventory.get(i).getItemDescription() + "\n";            
        }
        System.out.println("-----INVENTORY-----");
        System.out.println("You are carrying: ");
        System.out.println(output);
        System.out.println("Total number of battery in your inventory: "+ countBattery());
    }

    /**
     * Take the items from the room
     * Add items to the player's inventory 
     */
    private void takeItem(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know what to pick...
            System.out.println("Get what?");
            return;
        }

        String item = command.getSecondWord();

        // get the item from the current room
        Item newItem = currentRoom.getRoomItem(item);

        if (newItem == null) {
            System.out.println("That item is not here!");
        }
        else {
            inventory.add(newItem);
            currentRoom.removeRoomItem(item);
            System.out.println("Picked up: " + item);
            addScore();
            System.out.println("Total number of battery in your inventory: "+ countBattery());
        }
    }

    /**
     * Drop items back to the room
     * Remove items to the player's inventory 
     */
    private void dropItem(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know what to dtop..
            System.out.println("Drop what?");
            return;
        }

        String item = command.getSecondWord();

        // get the item from the current room
        Item newItem = null;
        int index = 0;
        for(int i=0; i<inventory.size(); i++)
        {
            if(inventory.get(i).getItemName().equalsIgnoreCase(item))
            {
                newItem = inventory.get(i);
                index = i;
            }
        }

        if (newItem == null) {
            System.out.println("That item is not in your inventory!");
        }
        else {
            int count = countBattery();
            for (Item items: inventory)
            {
                if (items.getItemName().compareToIgnoreCase("battery")== 0) {
                    count = countBattery() - 1;
                }
            }            
            System.out.println("Dropped: " + item);
            inventory.remove(index);
            currentRoom.getRoomItem(item);
            System.out.println("Total batteries you are carrying: " + countBattery());
        }
    }

    /**
     * It allows player to use the items on their inventory
     */
    private boolean useItem(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know what to pick...
            System.out.println("use what?");
            printInventory();
            return false;
        }

        String item = command.getSecondWord();

        // get the item from the current room

        Item useItem = null;
        int index = 0;
        for(int i=0; i<inventory.size(); i++)
        {
            if(inventory.get(i).getItemName().equalsIgnoreCase(item))
            {
                useItem = inventory.get(i);
                index = i;
            }
        }

        if (useItem == null) {
            System.out.println("That item is not in your inventory! Product cannot be used.");
        }
        else {
            for (Item items : inventory){
                if (items.getItemName().equalsIgnoreCase("battery")){
                    useBattery();
                    return true;
                }
            }
        }
        System.out.println("Product cannot be used.");
        return false;
    }

    /**
     * Use battery item. Added player's energy
     * @return player's energy
     */
    private int useBattery()
    {
        int energy = 0;
        player.setEnergy(player.getEnergy() + 1);
        System.out.println("Battery Recharging..");
        System.out.println("Energy: " + player.getEnergy());
        return energy;
    }

    /**
     * Prints out the player's statss 
     */
    private void checkStats()
    {
        System.out.println("-----PLAYER STATS-----");
        player.getPlayerDescription();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord())
        {
            System.out.println("Quit what?");
            return false;
        }
        else
        {
            return true;  // signal that we want to quit
        }
    }
}