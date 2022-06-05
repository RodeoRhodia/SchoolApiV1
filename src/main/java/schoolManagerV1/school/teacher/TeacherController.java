package schoolManagerV1.school.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolManagerV1.school.subject.Subject;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("{teacherId}/subjects")
    public Set<Subject> getSubjects(@PathVariable("teacherId") Long teacherId) {
        return teacherService.getSubjects(teacherId);
    }

    @PostMapping
    public void createTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }
}
