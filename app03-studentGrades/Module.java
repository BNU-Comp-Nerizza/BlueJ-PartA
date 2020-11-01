/**
 * The Class Module holds/stores the information about the mdodule.
 *
 * @Nerizza Flores
 * @20/10/2020
 */
public class Module
{
    // instance variables of the module code
    private String code;
    // instance variables of the module title
    private String title;
    // instance variable of the module mark
    private int mark; 
    // instance variable of the module credits
    private int credits;

    /**
     * Constructor for a new Module with code number and title of the module.
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code= code;
        this.title= title;
        credits = 0;
        mark = 0;
    }   

    /**
     * Method for awarding mark to a module 
     * 
     */
    public void awardMark(int mark)
    {
        if((mark >= 0) && (mark <= 100))
        {
            this.mark = mark;
        }
        else 
        {
            System.out.println("mark is not valid");
        }
        //after adding mark it will automatically convert mark to credits
        addCredits();
    }

    /**
     * Method for calculating credits 
     */
    public void addCredits()
    {
        //if mark is greaten than or equals 39, student gets 15 credits
        if (mark >= 39)
        {
            credits = 15;
        }
        else if (mark < 39)
        {
            System.out.println("Not enough credits for this module");
        }
    }

    /**
     * Return the credits of the module
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Return the mark of the module
     */
    public int getMark()
    {
        return mark;
    }

    /**
     * Return the code number of the module
     */
    public String getmoduleCode()
    {
        return code;
    }

    /**
     * Return the title of the module
     */
    public String getmoduleTitle()
    {
        return title;
    }

    /**
     * Prints out the details for the module
     */
    public void printModule()
    {
        System.out.println("Module code: " + code + ", Module Title: " + title + ", Module Mark: " + mark + "%");
    }

}
