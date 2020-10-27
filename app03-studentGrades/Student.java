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
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
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
