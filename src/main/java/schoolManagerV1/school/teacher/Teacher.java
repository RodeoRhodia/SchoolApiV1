package schoolManagerV1.school.teacher;

import javax.persistence.*;

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
}
