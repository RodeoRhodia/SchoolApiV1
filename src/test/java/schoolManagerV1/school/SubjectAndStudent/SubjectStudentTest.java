package schoolManagerV1.school.SubjectAndStudent;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schoolManagerV1.school.student.Student;
import schoolManagerV1.school.student.StudentRepository;
import schoolManagerV1.school.subject.Subject;
import schoolManagerV1.school.subject.SubjectRepository;
import schoolManagerV1.school.subject.SubjectService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubjectStudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    private Student sampleStudent;
    private Subject sampleSubject;
    private SubjectService subjectService;

    @BeforeEach
    void initializeEntitiesAndRepos() {
        subjectService = new SubjectService(subjectRepository, studentRepository);

        sampleStudent = new Student("Johnny Depp");
        sampleSubject = new Subject("MATH141");

        studentRepository.save(sampleStudent);
        subjectRepository.save(sampleSubject);
    }

    @Test
    public void testManyToManyRelationship() {
        /* After enrolling student to a subject check to see if:
        * - the student can be found in "enrolledStudents" set
        * - the subject can be found in "subjects" set
        *
        * If both of these are true, then a Many To Many relationship has been established
        * */
        subjectService.enrollStudentToSubject(1L, 1L);

        Set<Student> enrolledStudents = sampleSubject.getEnrolledStudents();
        Set<Subject> subjects = sampleStudent.getSubjects();

        assertEquals(enrolledStudents.size(), 1);
        assertEquals(subjects.size(), 1);
        assertTrue(enrolledStudents.contains(sampleStudent));
        assertTrue(subjects.contains(sampleSubject));

        /* Withdrawing a student from a subject ensures that the subject's association to the student is removed,
        * and vice-versa. */
        subjectService.withdrawStudentFromSubject(1L, 1L);

        assertEquals(enrolledStudents.size(), 0);
        assertEquals(subjects.size(), 0);
        assertFalse(enrolledStudents.contains(sampleStudent));
        assertFalse(subjects.contains(sampleSubject));
    }
}