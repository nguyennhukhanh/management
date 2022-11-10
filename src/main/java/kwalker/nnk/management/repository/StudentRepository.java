package kwalker.nnk.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kwalker.nnk.management.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
