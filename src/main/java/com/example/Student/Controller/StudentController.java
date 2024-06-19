package com.example.Student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Dto.DtoPageStudent;
import com.example.Student.Entity.Student;
import com.example.Student.Services.StudentServiceImp;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentServiceImp studentservice;

	
	     //////////////**** PagiNation using DTO ******/////////////////
	
	@GetMapping("/getstudents/{page}/{size}")    
public DtoPageStudent<Student>	getStudents(@PathVariable int page,@PathVariable int size){
		return studentservice.getStudents(page,size);
	} 
	//////////////**** sorting *****//////////
	
	@GetMapping("/getstudentsort/{page}/{size}")    
	public DtoPageStudent<Student>	getStudentsort(@PathVariable int page,@PathVariable int size ){
			return studentservice.getStudentsort(page,size);
		}
//////////////**** PagiNation using Entity ******/////////////////
	
	@GetMapping("/getstudentss/{page}/{size}")
	public Page<Student> getpages(@PathVariable int page,@PathVariable int size){
		return studentservice.getpages(page,size);
	}
	
	
   /////////////////**********************/////////////////////	

	@PostMapping("/post")
	public Student create(@RequestBody Student student) {
		return studentservice.create(student);
	}
}