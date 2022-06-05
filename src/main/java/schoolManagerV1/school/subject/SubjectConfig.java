package schoolManagerV1.school.subject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubjectConfig {

    @Bean
    CommandLineRunner subjectCommandLineRunner(SubjectRepository subjectRepository) {
        return (args) -> {
            Subject s1 = new Subject("MATH141");
            Subject s2 = new Subject("RELS271");
            Subject s3 = new Subject("ENGL101");
            Subject s4 = new Subject("CMSC132");

            subjectRepository.saveAll(List.of(s1, s2, s3, s4));
        };
    }
}