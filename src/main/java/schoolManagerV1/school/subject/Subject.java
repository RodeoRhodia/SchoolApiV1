package schoolManagerV1.school.subject;

import schoolManagerV1.school.student.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "subject")
@Table
public class Subject {

    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "subject_sequence"
    )
    Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "subject_members",
            joinColumns = @JoinColumn(name = "fk_subject"),
            inverseJoinColumns = @JoinColumn(name = "fk_student")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.getSubjects().add(this);
    }

    public void withdrawStudent(Student student) {
        enrolledStudents.remove(student);
        student.getSubjects().remove(this);
    }
}