package dao;

import entitymodels.Course;

import java.util.List;

public interface CourseDAO {

/*
    This method takes no
    parameter and returns
    every Course in the
    table.
*/
public List<Course> getAllCourses();
}
