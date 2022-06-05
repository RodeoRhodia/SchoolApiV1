package schoolManagerV1.school.subject;

import org.hibernate.annotations.Cascade;
import schoolManagerV1.school.student.Student;
import schoolManagerV1.school.teacher.Teacher;

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
    @Column(name = "id")
    Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "subject_members",
            joinColumns = @JoinColumn(name = "fk_subject"),
            inverseJoinColumns = @JoinColumn(name = "fk_student")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_teacher", referencedColumnName = "id")
    private Teacher teacher;

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

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.addSubject(this);
    }

    public void unassignTeacher(Teacher teacher) {
        this.teacher = null;
        teacher.removeSubject(this);
    }

    public Teacher getTeacher() {
        return teacher;
    }
}