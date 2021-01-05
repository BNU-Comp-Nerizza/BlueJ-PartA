import java.util.*;
/**
 * Class Player - a player in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "player" represents player of the game. 
 * The player class contains the description of the player. 
 *
 * @author  Nerizza Flores
 * @version 2020.12.14
 */
public class Player
{
    // instance variables  of player
    private String playerName;
    private int score;
    private int energy;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        playerName ="";
        score = 0;
        energy = 0;
    }

    /**
     * Constructor for class player 
     * @param name of the player
     */
    public Player(String name)
    {
        this.playerName = name;
    }

    /**
     * @set the player name
     */
    public void setPlayerName(String user)
    {
        this.playerName = user;
    }

    /**
     * @return the player name
     */
    public String getPlayerName()
    {
        return this.playerName;
    }

    /**
     * Prints the player description
     */
    public void getPlayerDescription()
    {
        System.out.println("Player: " + playerName + " \n"  + "Score: " + getScore() + " \n" + "Energy: " + getEnergy()); 
    }

    /**
     * @return the player's score
     */
    public int getScore()
    {
        return score; 
    }

    /**
     * @return the player energy
     */
    public int getEnergy()
    {
        return this.energy = energy;
    }

    /**
     * @set the player score
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * @set the player energy
     */
    public void setEnergy(int energy)
    {
        this.energy = energy;
    }
}