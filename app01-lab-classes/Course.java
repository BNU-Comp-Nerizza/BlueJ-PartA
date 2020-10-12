
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

    /**
     * Create a new Course with code number and title of the course.
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        codeNum= code;
        courseTitle= title;
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
    }
    
}
