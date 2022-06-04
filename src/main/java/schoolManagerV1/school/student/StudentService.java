package schoolManagerV1.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolManagerV1.school.subject.Subject;
import schoolManagerV1.school.subject.SubjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.PreRemove;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getSubject(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        Set<Subject> subjects = student.getSubjects();
        for(Subject subject: student.getSubjects()) {
            student.removeSubject(subject);
            subject.removeStudent(student);
        }

        subjectRepository.saveAll(subjects);
        studentRepository.deleteById(studentId);
    }

}
