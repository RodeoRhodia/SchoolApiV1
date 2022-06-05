package schoolManagerV1.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolManagerV1.school.student.Student;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
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
        subjectService.addNewService(subject);
    }

    @PutMapping("{subjectId}/enrollstudent/{studentId}")
    public void enrollStudentToSubject(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId) {
        subjectService.enrollStudentToSubject(subjectId, studentId);
    }

    @PutMapping("{subjectId}/withdrawstudent/{studentId}")
    public void withdrawStudentFromSubject(
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId) {
        subjectService.withdrawStudentFromSubject(subjectId, studentId);
    }
}