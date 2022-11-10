package kwalker.nnk.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kwalker.nnk.management.entities.Student;
import kwalker.nnk.management.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("admin/get-students")
	public List<Student> getAll() {
		return this.service.getAll();
	}

	@PostMapping("admin/save-student")
	public String saveStudent(Student std) {
		return this.service.saveStudent(std);
	}

	@DeleteMapping("admin/delete-student")
	public String deleteStudent(@RequestParam("id") Integer id) {
		return this.service.deleteStudent(id);
	}

	@DeleteMapping("admin/delete-students")
	public String deleteStudents() {
		return this.service.deleteStudents();
	}

	@GetMapping("admin/search")
	public Student getStudent(@RequestParam("id") Integer id) {
		return this.service.getStudent(id);
	}

	@PatchMapping("admin/update-student")
	public Student updateStudent(@RequestParam("id") Integer id, Student std) {
		return this.service.updateStudent(id, std);
	}
}
