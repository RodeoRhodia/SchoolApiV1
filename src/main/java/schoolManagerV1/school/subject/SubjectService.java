package schoolManagerV1.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolManagerV1.school.student.Student;
import schoolManagerV1.school.student.StudentRepository;
import schoolManagerV1.school.teacher.Teacher;
import schoolManagerV1.school.teacher.TeacherRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SubjectService(
            SubjectRepository subjectRepository,
            StudentRepository studentRepository,
            TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public Teacher getTeacher(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        return subject.getTeacher();
    }

    public void addNewService(Subject subject) {
        subjectRepository.save(subject);
    }

    public Set<Student> getEnrolledStudents(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        return subject.getEnrolledStudents();
    }

    @Transactional
    public void enrollStudentToSubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();

        subject.enrollStudent(student);
        subjectRepository.save(subject);
    }

    public void withdrawStudentFromSubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();

        subject.withdrawStudent(student);
        subjectRepository.save(subject);
    }

    public void assignTeacherToSubject(Long subjectId, Long teacherId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();

        subject.assignTeacher(teacher);
        subjectRepository.save(subject);

    }

    public void unassignTeacherFromSubject(Long subjectId, Long teacherId) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Teacher teacher = teacherRepository.findById(teacherId).get();

        subject.unassignTeacher(teacher);
        subjectRepository.save(subject);
    }
}