package schoolManagerV1.school.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import schoolManagerV1.school.subject.Subject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "teacher")
@Table
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "teacher_sequence"
    )
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects =  new HashSet<>();

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {}

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

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
