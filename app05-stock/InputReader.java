import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Nerizza Flores
 * @version    0.1 (15/11/2020)
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getString()
    {     
        String inputLine = "";
        while(inputLine.length() == 0)
        {        
            System.out.print("> ");         // print prompt
            inputLine = reader.nextLine();

            if(inputLine.length()==0)
                System.out.println("Invalid input. Cannot leave blank\n");
        }
        return inputLine;
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a int.
     *
     * @return  A int typed by the user.
     */
    public int getInt()
    {
        int inputID = 0;
        while(!reader.hasNextInt()){
            System.out.print("> ");         // print prompt
            inputID = reader.nextInt();
        }
        return inputID;
    }
}
