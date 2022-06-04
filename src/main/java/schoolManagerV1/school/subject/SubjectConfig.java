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
            Subject s1 = new Subject("Math");
            Subject s2 = new Subject("Art");
            Subject s3 = new Subject("Science");
            Subject s4 = new Subject("History");

            subjectRepository.saveAll(List.of(s1, s2, s3, s4));
        };
    }
}
