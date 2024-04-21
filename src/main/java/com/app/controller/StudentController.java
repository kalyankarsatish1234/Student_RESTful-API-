package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.enttity.Student;
import com.app.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
	
	//get all students
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return repo.findAll();
	}
	
	//add student
	@PostMapping("/student/add")
	public Student addStudnet(@RequestBody Student student){
		return repo.save(student);
	}
	
	//delete student by id
	@DeleteMapping("/student/delete/{id}")
	 void deleteStudent( @PathVariable int id) {
		repo.deleteById(id);
	}
	//put student
//	@PutMapping("/student/update/{id}")
//	public Student updateStudents(@PathVariable int id) {
//	   Student student = repo.findById(id).get();
//	   student.setName("poonam");
//	   student.setPercentage(92);
//	   repo.save(student);
//	   return student;
//		
//	}
	//put student
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student =repo.findById(id).get();
		student.setRollNo(100);
		student.setName("satish");
		student.setBranch("entc");
		student.setPercentage(70);
		repo.save(student);
		return student;
		}
	
	//get by id
	@GetMapping("students/{id}")
	public Student getStudent(@PathVariable int id) {
			Student student =  repo.findById(id).get();
			return student;
	}
	
	
	
	
	
}
