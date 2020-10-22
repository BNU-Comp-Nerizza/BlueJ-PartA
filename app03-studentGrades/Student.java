import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Nerizza Flores
 * @version 30/SEP/2020
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;
    // the course of the student
    private Course newCourse;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }

     /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }
    
    /**
     * Return the course of the student including the code number and course title
     */
    public void enroll(Course fullCourse)
    {
        newCourse= fullCourse;
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);
        newCourse.printCourse();
        System.out.println("Final Mark: ");
        newCourse.getFinalMark();
        System.out.println("Final Grade: ");
        newCourse.getFinalGrade();
        System.out.println("Final Credit: ");
        newCourse.getFinalCredits();
    }
}
