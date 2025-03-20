package gr.uom.demo1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gr.uom.demo1.models.Student;

@Service
public class StudentService {

	List<Student> list = new ArrayList<>();

	public void addStudents() {
		list.add(new Student("Nikos", "test 1", 22, "pass"));
		list.add(new Student("Maria", "test 1", 20, "pass"));
	}
	
	public List<Student> getAllStudents(){
		return list;
	}

	public Student delete(String name) {
		Optional<Student> s = list.stream().filter(student -> student.getName().equals(name)).findFirst();
		list = list.stream()
				.filter(student -> !student.getName().equals(name))
				.collect(Collectors.toList());

		return s.get();
	}

	public void update(String name, String address) {
		Optional<Student> s = list.stream().filter(student -> student.getName().equals(name)).findFirst();
		list = list.stream()
				.filter(student -> !student.getName().equals(name))
				.collect(Collectors.toList());
		list.add(s.get());
	}

	public void post(Student student) {
		list.add(student);
	}
}
