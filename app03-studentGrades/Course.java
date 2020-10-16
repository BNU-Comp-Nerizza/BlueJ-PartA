import java.util.*;
/**
 * Write a description of class Course here.
 *
 * @Nerizza Flores
 * @30/09/2020
 */
public class Course
{
    // instance variables of the course code
    private String codeNum;
    // instance variables of the course title
    private String courseTitle;
    
    private ArrayList<Module> modules;
    private int capacity;
    private int credits;

    /**
     * Create a new Course with code number and title of the course.
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        codeNum= code;
        courseTitle= title;
        
        modules = new ArrayList<Module>();
        capacity = 4;
        credits = 0;
    }
    
    public void addModule(Module newModule)
    {
        if(modules.size() == capacity)
           {
            System.out.println("You have enough module for this course");
           }
        else
           {
             modules.add(newModule);
             System.out.println("Module " + newModule.getmoduleTitle() + "  have been added");
           }
    }
    
     /**
     * Return the code number of the course
     */
    public String getcodeNum()
    {
        return codeNum;
    }
    
    /**
     * Return the title of the course
     */
    public String getcourseTitle()
    {
        return courseTitle;
    }
    
      /**
     * print out the course
     */
    public void printCourse()
    {
        System.out.println("course code: " + codeNum + ", course title: " + courseTitle);
        System.out.println("List of the modules: " );
        {
         for (Module module : modules)
         {
             module.print();
            }   
        }
    }
        
}
