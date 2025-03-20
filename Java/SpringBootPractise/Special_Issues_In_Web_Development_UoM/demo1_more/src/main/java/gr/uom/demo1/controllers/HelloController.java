package gr.uom.demo1.controllers;

import gr.uom.demo1.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Value("${gr.value}")
	private String value;

	@GetMapping()
	public String getHello() {
		return "Hello " + value + "!";
	}

	@GetMapping("/hello2")
	public String getHello2() {
		return "Hello 2!";
	}
	
	@GetMapping("/name/{name}")
	public String getHelloName(@PathVariable("name") String name) {
		return "Hello "+name;
	}
	
	@GetMapping("name2")
	public String getHelloName2(@RequestParam("name") String name) {
		return "Hello "+name;
	}


	// 1
	@GetMapping("/yolo")
	public ResponseEntity<String> yolo() {
		return new ResponseEntity<>("Not found", HttpStatus.BAD_REQUEST);
	}

	// 2
	@GetMapping("/yolo2")
	public String response2() {
		throw new ResponseStatusException(HttpStatus.OK, "Response not found");
	}

	// 3
	@GetMapping("/yolo3")
	public String response3(HttpServletResponse httpServletResponse) {
		httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return "No";
	}

	@DeleteMapping("/name2")
	public String delete(@RequestParam String email) {
		return "deleted";
	}

	@PutMapping("/name2")
	public String put(@RequestParam String email, @RequestParam(required = false) String name, @RequestParam(required = false) String address) {
		return "updated";
	}

	@PostMapping("/name2")
	public User post(@RequestBody User user) {
		return user;
	}

}
