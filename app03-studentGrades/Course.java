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
    private String codeNum;
    // instance variables of the course title
    private String courseTitle;
    //finalCredit
    private int finalCredit;
    //
    private int mark;
    //
    private int finalMark;
    //
    private char grade;
    //
    private ArrayList<Module> modules;
    //
    private Module module;
  
    
    /**
     * Create a new Course with code number and title of the course.
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        codeNum= code;
        courseTitle= title;
        modules = new ArrayList<Module>();
    }
    
    public void addModule(Module newModule)
    {
       modules.add(newModule);
       System.out.println("Module (" + newModule.getmoduleTitle() + ") have been added.");
    }

    public void addfinalCredits()
    {
        for (Module module : modules)
        {
            finalCredit = finalCredit + module.getCredits();
        }
    }
    
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
        return codeNum;
    }
         
    /**
     * Return the code number of the course
     */
    public char getFinalGrade()
    {
        return grade;
    }
    
    public int getFinalCredits()
    {
        return finalCredit;
    }
    
      public int getFinalMark()
    {
        return finalMark;
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
             module.printModule();
            }   
        }
    }
        
    
}
