package schoolManagerV1.school.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner studentCommandLineRunner(StudentRepository studentRepository) {
        return (args) -> {
            Student s1 = new Student("Johnny Depp");
            Student s2 = new Student("Sumire Hoxha");
            Student s3 = new Student("Angelina Clifton");

            studentRepository.saveAll(List.of(s1, s2, s3));
        };
    }
}