package schoolManagerV1.school.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import schoolManagerV1.school.subject.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "student")
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "student_sequence"
    )
    Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents", fetch = FetchType.LAZY)
    private Set<Subject> subjects = new HashSet<>();

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }
}