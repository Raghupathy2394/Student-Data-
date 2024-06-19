package com.example.Student.Services;


import org.springframework.data.domain.Page;

import com.example.Student.Dto.DtoPageStudent;

import com.example.Student.Entity.Student;

public interface StudentServiceImp {

	Student create(Student student);

	
	//////////////*********pagination****///////////
	
	DtoPageStudent<Student> getStudents(int page, int size);

	Page<Student> getpages(int page, int size);

	DtoPageStudent<Student> getStudentsort(int page, int size);

}
