import entitymodels.Course;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import service.CourseService;

import java.util.List;
/*
@author John Crume
JUnit Testfor CourseService.java that test the
 */
public class CourseDAOTest {

    //create the course service and course variables
    private static CourseService courseDAO;
    private static Course c1;
    private static Course c2;
    private static Course c3;
    private static Course c4;
    private static Course c5;
    private static Course c6;

    //This method intializes the course service and course variables to be used in the test
    @BeforeAll
    public static void beforeAll(){
        courseDAO = new CourseService();
        c1 = new Course(1,"English","Anderea Scamaden");
        c2 = new Course(2,"Mathematics","Eustace Niemetz");
        c3 = new Course(3,"Anatomy","Reynolds Pastor");
        c4 = new Course(7,"Object Oriented Programming","Giselle Ardy");
        c5 = new Course(10,"Art","Kingsly Doxsey");
        c6 = new Course(11,"Astrology","Miss Cleo");
    }
    /*This method tests the get all courses method in CourseService class.
    It does this by matching comparing the returned courses list to the
    created courses as these are all known. This is done with the .hashoCode method that
     is overridden in the Course entity class.
    */
    @Test
    public void getAllCoursesTest(){
        //get the list of all courses by calling getAllCourses
        List<Course> allCourse = courseDAO.getAllCourses();
        //compare the courses
        boolean isEqual = allCourse.get(0).hashCode() == c1.hashCode() ? true:false ;
        boolean isEqual2 = allCourse.get(6).hashCode() == c4.hashCode() ? true:false;
        boolean isEqual3 = allCourse.get(9).hashCode() == c5.hashCode() ? true:false;
        boolean isNotEqual = allCourse.contains(c6);
        //run tests
        Assert.assertEquals(true, isEqual);
        Assert.assertEquals(true,isEqual2);
        Assert.assertEquals(true,isEqual3);
        Assert.assertNotEquals(true,isNotEqual);
    }

}
