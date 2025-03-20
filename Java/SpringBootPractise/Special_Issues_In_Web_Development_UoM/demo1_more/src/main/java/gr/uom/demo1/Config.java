package gr.uom.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gr.uom.demo1.services.CourseService;
import gr.uom.demo1.services.StudentService;

@Configuration
public class Config {

	@Bean
	public CommandLineRunner commandLineRunner(
			StudentService studentService,
			CourseService courseService) {
		return args -> {
			studentService.addStudents();
			courseService.addCourses();
		};
	}
}
