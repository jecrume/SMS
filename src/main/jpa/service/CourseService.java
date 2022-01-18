package service;

import dao.CourseDAO;
import entitymodels.Course;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/*
@author John Crume
Course DAO implementation of CourseDAO interface
 */

public class CourseService implements CourseDAO {

    //Create EntityManager
    private EntityManager em;

    //Course Service Constructor
    //Initializes EntityManager and EntityManagerFactory
    public CourseService(){
        //initialize entity Manager factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sms");
        //initialize EntityManager
        em = emf.createEntityManager();
    }

    /*
    This method takes no parameter and returns every Course in the course table.
     */
    @Override
    public List<Course> getAllCourses() {
        try{
            //create the sql query
            String sql = "SELECT * FROM course";
            //create the Native Query with sql string
            NativeQuery<Course> query = (NativeQuery<Course>) em.createNativeQuery(sql,Course.class);
            //execute the query and get the returned results as a List
            List<Course> allCourses = query.getResultList();
            //return the List of results as a list of Course
            return allCourses;

            //Handle NoResultException or other exception
        } catch(Exception e){
            System.out.println("No courses found."+" "+e);
            //e.printStackTrace();
            //return null List
            return null;
        }

    }
/*
This method gets the course by the given course id given as a parameter
 */
    public Course getCourseById(int id){
        try{
            //create the SQL query String
            String sql = "SELECT u FROM Course u WHERE u.cId = :id";
            //create a Typed query that will return acourse as a result
            TypedQuery<Course> query = em.createQuery(sql,Course.class);
            //set the id parameter of the query
            query.setParameter("id",id);
            //execute the query and get the result as a single course
            Course course = query.getSingleResult();
            //return the course that was found
            return course;
        }catch(Exception e){
            System.out.println("getCourseById: No course found for given course Id. " + e);
            //e.printStackTrace();
            //return null course
            return null;
        }
    }
}
