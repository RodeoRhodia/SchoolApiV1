package schoolManagerV1.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
        studentRepository.deleteById(studentId);
    }
}
