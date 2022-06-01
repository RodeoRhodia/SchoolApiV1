package schoolManagerV1.school.student;

import javax.persistence.*;

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
}

