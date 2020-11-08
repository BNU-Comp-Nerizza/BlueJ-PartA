/**
 * It holds the course details relevant in our context.
 *
 * @author Nerizza Flores
 * @version 30/SEP/2020
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
}
