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
    // the course of the student
    private Course course;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
    }
  
    /**
     * Return the course of the student including the code number and course title
     */
    public void enroll(Course course)
    {
        this.course= course;
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println("Student name: " + name + ", student ID: " + id);
        course.printCourse();
    }
    
     /**
     * Print the student final marks and grades to the output terminal
     */
    public void printFinalGrade()
    {
        System.out.println("Final Mark: " + course.getFinalMark());
        System.out.println("Final Grade: " + course.getFinalGrade());
        System.out.println("Final Credit: " + course.getFinalCredits());
    }
}
