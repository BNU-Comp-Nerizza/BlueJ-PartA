/**
 * Write a description of class Module here.
 *
 * @Nerizza Flores
 * @15/10/2020
 */
public class Module
{
    // instance variables of the module code
    private String code;
    // instance variables of the module title
    private String title;
    // instance variable 
    private int mark; 
    //
    private int credits;

    /**
     * Create a new Course with code number and title of the course.
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code= code;
        this.title= title;
        credits = 0;
        mark = 0;
    }   
    
    public void addMark(int mark)
    {
        this.mark = mark;
    }
    
    public void addCredits()
    {
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
     * Return the code number of the module
     */
    public String getmoduleCode()
    {
        return code;
    }
    
    public int getCredits()
    {
       return credits;
    }
    
    public int getMark()
    {
       return mark;
    }
   
    /**
     * Return the title of the module
     */
    public String getmoduleTitle()
    {
        return title;
    }
    
    public void printModule()
    {
        System.out.println("Module code: " + code + ", Module Title: " + title + ", Module Mark: " + mark + "%");
    }

}
