package schoolManagerV1.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
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
}
