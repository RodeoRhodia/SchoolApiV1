package schoolManagerV1.school.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner teacherCommandLineRunner(TeacherRepository teacherRepository) {
        return (args) -> {
            Teacher t1 = new Teacher("Fawzi");
            Teacher t2 = new Teacher("Grossman");
            Teacher t3 = new Teacher("Gulick");
            Teacher t4 = new Teacher("Allen");

            teacherRepository.saveAll(List.of(t1, t2, t3, t4));
        };
    }
}