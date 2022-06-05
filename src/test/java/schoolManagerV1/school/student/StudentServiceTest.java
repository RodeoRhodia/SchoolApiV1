package schoolManagerV1.school.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schoolManagerV1.school.subject.SubjectRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentServiceTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;


    @Test
    public void testCreateStudent() {
        StudentService studentService = new StudentService(studentRepository, subjectRepository);
        studentService.addNewStudent(new Student("Johnny Depp"));

        List<Student> listOfStudents = studentRepository.findAll();

        assertTrue(listOfStudents.size() == 1);
        assertTrue(listOfStudents.get(0).getName().equals("Johnny Depp"));
    }

}