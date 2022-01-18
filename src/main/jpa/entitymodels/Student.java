package entitymodels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "email")
    private String sEmail;
    @Basic
    @Column(name = "name")
    private String sName;
    @Basic
    @Column(name = "password")
    private String sPass;

    @ManyToMany
     @JoinTable(
            name = "Student_Course",
            joinColumns = @JoinColumn(name ="sEmail",referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name ="id",referencedColumnName = "id")
    )
    private List<Course> sCourses;

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String email) {
        this.sEmail = email;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String name) {
        this.sName = name;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String password) {
        this.sPass= password;
    }

    public List<Course> getsCourses(){return sCourses;}

    public void setsCourses(List<Course> courses){
        this.sCourses = courses;
    }
    //default constructor
   public Student(){
    }

    public Student(String email, String name, String password, List<Course> courses){
        setsEmail(email);
        setsName(name);
        setsPass(password);
        setsCourses(courses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sEmail!= null ? !sEmail.equals(student.sEmail) : student.sEmail != null) return false;
        if (sName != null ? !sName.equals(student.sName) : student.sName != null) return false;
        if (sPass!= null ? !sPass.equals(student.sPass) : student.sPass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sEmail != null ? sEmail.hashCode() : 0;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (sPass != null ? sPass.hashCode() : 0);
        return result;
    }



}
