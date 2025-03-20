package gr.uom.demo1.controllers;

import java.util.ArrayList;
import java.util.List;

import gr.uom.demo1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gr.uom.demo1.controllers.dto.StudentStripped;
import gr.uom.demo1.models.Student;
import gr.uom.demo1.services.CourseService;
import gr.uom.demo1.services.StudentService;

// http://localhost:8080/swagger-ui/index.html

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired StudentService studentService;

	
//	@GetMapping("/tmp")
//	public Student getTmpStudent() {
//		return new Student("Nikos", "Egnatia 156", 22);
//	}
//	
//	@GetMapping("/tmp2")
//	public ArrayList<Student> getTmpListStudent(){
//		ArrayList<Student> list = new ArrayList<>();
//		list.add(new Student("Nikos", "test 1", 22));
//		list.add(new Student("Maria", "test 1", 20));
//		
//		return list;
//	}
	
	@GetMapping("/addtmpstudents")
	public void addTmpStudents() {
		studentService.addStudents();
	}
	
	@GetMapping("/gettmpstudents")
	public List<StudentStripped> getTmpStudents(){
		List<Student> list= studentService.getAllStudents();
		List<StudentStripped> list2=new ArrayList<>();
		for(Student st: list) {
			list2.add(new StudentStripped(st.getName(),
					st.getAddress(), st.getYear()));
		}
		return list2;
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam String name) {
		studentService.delete(name);
		return "deleted";
	}

	@PutMapping("/name2")
	public String put(@RequestParam String name, @RequestParam(required = false) String address) {
		studentService.update(name, address);
		return "updated";
	}

	@PostMapping("/name2")
	public Student post(@RequestBody Student student) {
		studentService.post(student);
		return student;
	}
}
