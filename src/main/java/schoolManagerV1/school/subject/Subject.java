package schoolManagerV1.school.subject;

import javax.persistence.*;

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
}