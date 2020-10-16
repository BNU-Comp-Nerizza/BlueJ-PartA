
/**
 * Write a description of class Course here.
 *
 * @Nerizza Flores
 * @30/09/2020
 */
public class Module
{
    // instance variables of the course code
    private String moduleNum;
    // instance variables of the course title
    private String moduleTitle;
    // instance variable 
    private int moduleMark; 

    /**
     * Create a new Course with code number and title of the course.
     */
    public Module(String code, String title, int mark)
    {
        // initialise instance variables
        moduleNum= code;
        moduleTitle= title;
        moduleMark = mark;
    }
    
    public int printMark()
    {
       System.out.print("Module grade is " + moduleMark + " = ");
        
        if (moduleMark >= 0 && moduleMark <= 39)
        {
            System.out.print("F");
        }
         else if (moduleMark >=40 && moduleMark <= 49)
        {
            System.out.print("D");
        }
        else if (moduleMark >=50 && moduleMark <= 59)
        {
            System.out.print("C");
        }
                else if (moduleMark >=60 && moduleMark <= 69)
        {
            System.out.print("B");
        }
                else if (moduleMark >=70 && moduleMark <= 100)
        {
            System.out.print("A");
        }
                    return moduleMark; 
    }
    
    /**
     * Return the code number of the course
     */
    public String getmoduleNum()
    {
        return moduleNum;
    }
    
    /**
     * Return the title of the course
     */
    public String getmoduleTitle()
    {
        return moduleTitle;
    }
    
    public void print()
    {
        System.out.println("Module code: " + moduleNum + " Module Title: " + moduleTitle + " Module Mark: " + moduleMark);
       
    }

}
