package mainrunner;


import java.util.List;
import java.util.Scanner;
import entitymodels.Course;
import entitymodels.Student;
import service.CourseService;
import service.StudentService;

/*@modified by: John Crume
AD - SBA - Core Java/JPA/JUnit
Student Management System Entry point

*/
public class SMSRunner {

    private Scanner sin;
    private StringBuilder sb;

    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    public SMSRunner(){
        sin = new Scanner(System.in);
        sb = new StringBuilder();
        courseService = new CourseService();
        studentService = new StudentService();
    }

    private void run(){

            switch (menu1()) {
                case 1:
                    if (studentLogin()) {
                        registerMenu();
                    }
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    break;
                default:

            }
    }

    private int menu1(){
        sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
        System.out.println(sb.toString());
        sb.delete(0,sb.length());
        try {
            int result = sin.nextInt();
            return result;
        }catch (Exception e){
            System.out.println("Invalid selection. Goodbye.");
            e.printStackTrace();
            return 2;
        }

    }

    private boolean studentLogin(){
        System.out.print("Enter your email address: ");
        String email = sin.next();
        System.out.print("Enter your password: ");
        String password = sin.next();
        try {
            boolean isValidStudent = studentService.validateStudent(email, password);

            if (isValidStudent) {
                currentStudent = studentService.getStudentByEmail(email);
                List<Course> courses = currentStudent.getsCourses();
                System.out.println("My Current Courses: ");
                for (Course course : courses) {
                    System.out.println(course);
                }
                return true;
            }


        }catch(Exception e){
            System.out.println("User Login failed. Goodbye!");
            e.printStackTrace();
            return false;
        }

        return false;
    }

    private void registerMenu(){
        sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
        System.out.print(sb.toString());
        sb.delete(0, sb.length());

        switch (sin.nextInt()){

            case 1:
                List <Course> allCourses = courseService.getAllCourses();
                List <Course> studentCourses = studentService.getStudentCourses(currentStudent.getsEmail());
                allCourses.removeAll(studentCourses);
                System.out.printf("%-10s%-50S%-50s\n", "ID","Course", "Instructor");
                for(Course course: allCourses){
                    System.out.printf("%-10s%-50S%-50s\n",course.getcId(),course.getcName(),course.getcInstructorName());
                }
                System.out.println("\n\n\n");
                System.out.println("Enter Course Number: ");
                int number = sin.nextInt();
                Course newCourse = courseService.getCourseById(number);
                if(newCourse !=null){
                    studentService.registerStudentToCourse(currentStudent.getsEmail(), number);
                    System.out.println("\n\nMy Courses: ");
                    for(Course course: currentStudent.getsCourses()){
                        System.out.println(course);
                    }
                }
                break;
            case 2:
            default:
                System.out.println("Goodbye");

        }
    }

    public static void main(String [] args){
        SMSRunner sms = new SMSRunner();
        sms.run();
    }
}
