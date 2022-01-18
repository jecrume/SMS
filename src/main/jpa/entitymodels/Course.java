package entitymodels;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "course")
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int cId;
    @Basic
    @Column(name = "name")
    private String cName;
    @Basic
    @Column(name = "instructor")
    private String cInstructorName;

    public int getcId() {
        return cId;
    }

    public void setcId(int id) {
        this.cId = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String name) {
        this.cName = name;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String instructor) {
        this.cInstructorName = instructor;
    }

    public Course(){}

    public Course(int id, String name, String instructor){
        setcId(id);
        setcName(name);
        setcInstructorName(instructor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (cId != course.cId) return false;
        if (cName != null ? !cName.equals(course.cName) : course.cName != null) return false;
        if (cInstructorName != null ? !cInstructorName.equals(course.cInstructorName) : course.cInstructorName != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId;
        result = 31 * result + (cName != null ? cName.hashCode() : 0);
        result = (31 * result) + ((cInstructorName != null) ? cInstructorName.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "sCourses")
    private Collection<Student> student;

    public Collection<Student> getStudent() {
        return student;
    }

    public void setStudent(Collection<Student> student) {
        this.student = student;
    }

    @Override
    public String toString(){
        return "      "+this.cId+"    " + this.cName +"       "+ this.cInstructorName;
    }
}
