import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Course here.
 *
 * @Nerizza Flores
 * @15/10/2020
 */
public class Course
{
    // instance variables of the course code
    private String code;
    // instance variables of the course title
    private String title;
    // instance variables of the course Credit
    private int finalCredit;
    // instance variables of the course Mark
    private int mark;
    // instance variables of the course final Mark
    private int finalMark;
    // instance variables of the course final Grade
    private char grade;
    // Array list for the class module
    private ArrayList<Module> modules;
    // instance variables of the module
    private Module module;

    /**
     * Create a new Course with code number and title of the course.
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code= code;
        this.title= title;
        modules = new ArrayList<Module>();
    }
    
        /**
     * Method for adding module to the course
     */
    public void addModule(Module newModule)
    {
       modules.add(newModule);
       System.out.println("Module (" + newModule.getmoduleTitle() + ") have been added.");
    }

     /**
     * Calculate the number of credit points this student has accumulated.
     */
    public void addfinalCredits()
    {
        for (Module module : modules)
        {
            finalCredit = finalCredit + module.getCredits();
        }
    }
    
         /**
     * Calculate the number of grade this student has accumulated.
     */
    public void addfinalGrade()
    {
        for (Module module : modules)
        {
          mark = mark + module.getMark();
          finalMark = mark / 4;
        if (mark >= 0 && mark <= 39)
        {
            grade = 'F';
        }
            else if (mark >=40 && mark <= 49)
           {
                grade = 'D';
            }
                else if (mark >=50 && mark <= 59)
                {
                    grade = 'C';
                }
                  else if (mark >=60 && mark <= 69)
                  {
                      grade = 'B';
                    }
                     else if (mark >=70 && mark <= 100)
                     {
                      grade = 'A';
                      }
        }     
    }
        
    /**
     * Return the code number of the course
     */
    public String getcodeNum()
    {
        return code;
    }
         
    /**
     * Return the code number of the course
     */
    public char getFinalGrade()
    {
        return grade;
    }
    
     /**
     * Return the final credits of the student
     */
    public int getFinalCredits()
    {
        return finalCredit;
    }
    
     /**
     * Return the final mark of the student
     */
    public int getFinalMark()
    {
        return finalMark;
    }
    
    /**
     * Return the title of the course
     */
    public String getcourseTitle()
    {
        return title;
    }
    
    /**
     * print out the course details and its module
     */
     public void printCourse()
    {
        System.out.println("course code: " + code + ", course title: " + title);
        System.out.println("List of the modules: " );
        {
         for (Module module : modules)
         {
             module.printModule();
            }   
        }
    }
}
