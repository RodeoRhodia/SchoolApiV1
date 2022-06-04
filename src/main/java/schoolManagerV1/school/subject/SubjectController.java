package schoolManagerV1.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolManagerV1.school.student.Student;
import schoolManagerV1.school.student.StudentService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final StudentService studentService;

    @Autowired
    public SubjectController(SubjectService subjectService, StudentService studentService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @GetMapping
    public List<Subject> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping("{subjectId}/enrolledstudents")
    public Set<Student> getEnrolledStudents(@PathVariable("subjectId") Long subjectId) {
        return subjectService.getEnrolledStudents(subjectId);
    }

    @PostMapping
    public void createSubject(@RequestBody Subject subject) {
        subjectService.addNewSubject(subject);
    }

    @PutMapping("{subjectId}/students/{studentId}")
    public void enrollStudentToSubject(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId) {
        /* do error handling, either if Subject or Student object does not exist */
        Subject subject = subjectService.getSubject(subjectId);
        Student student = studentService.getSubject(studentId);
        subject.enrollStudent(student);
        subjectService.addNewSubject(subject);
    }

    @DeleteMapping("{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }

}
