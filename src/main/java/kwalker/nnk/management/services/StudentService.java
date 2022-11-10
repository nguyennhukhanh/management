package kwalker.nnk.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kwalker.nnk.management.entities.Student;
import kwalker.nnk.management.enums.Message;
import kwalker.nnk.management.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;

	public List<Student> getAll() {
		return this.repo.findAll();
	}

	public String saveStudent(Student std) {
		this.repo.save(std);
		return Message.SAVE_SUCCESSFULLY;
	}

	public String deleteStudent(Integer id) {
		Student std = this.repo.findById(id).orElse(null);
		if (std != null) {
			this.repo.delete(std);
			return Message.DELETE_SUCCESSFULLY(std.getFullName());
		} else {
			return Message.DELETION_FAILED;
		}
	}

	public String deleteStudents() {
		this.repo.deleteAll();
		return Message.DELETED_ALL_SUCCESSFULLY;
	}

	public Student getStudent(Integer id) {
		Optional<Student> std = this.repo.findById(id);
		if (std.isPresent()) {
			return std.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, Message.NOT_FOUND);
		}
	}

	public Student updateStudent(Integer id, Student student) {
		Optional<Student> std = this.repo.findById(id);
		if (std.isPresent()) {
			return this.repo.save(student);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, Message.NOT_FOUND);
		}
	}
}
