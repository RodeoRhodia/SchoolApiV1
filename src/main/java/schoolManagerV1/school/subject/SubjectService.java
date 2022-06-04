package schoolManagerV1.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolManagerV1.school.student.Student;
import schoolManagerV1.school.student.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public void addNewSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    public Set<Student> getEnrolledStudents(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).get();

        return subject.getEnrolledStudents();
    }

    @Transactional
    public void removeStudent(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();

        subject.removeStudent(student);
        student.removeSubject(subject);

        subjectRepository.save(subject);
        studentRepository.save(student);
    }
}
