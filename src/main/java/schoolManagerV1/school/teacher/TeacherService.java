package schoolManagerV1.school.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolManagerV1.school.subject.Subject;

import java.util.List;
import java.util.Set;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers() {
       return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Set<Subject> getSubjects(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        return teacher.getSubjects();
    }
}
