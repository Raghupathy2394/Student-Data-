package com.example.Student.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Student.Dto.DtoPageStudent;
import com.example.Student.Entity.Student;
import com.example.Student.Repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImp {

	@Autowired
	StudentRepository studentRepo;
	
	///////////////*****************pagination using DTO******///////////////
	@Override
	public DtoPageStudent<Student> getStudents(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    Page<Student> page1 = studentRepo.findAll(pageable);
        DtoPageStudent<Student> student=new DtoPageStudent<Student>();
        student.setContent(page1.getContent());
        student.setPageSize(page1.getSize());
        student.setLast(page1.isLast());
        student.setTotalElements(page1.getNumberOfElements());
        student.setTotalPage(page1.getTotalPages());
        return student;     
	}
	
	///////////////****************sorting ********/////////////
	
	@Override
	public DtoPageStudent<Student> getStudentsort(int page, int size) {
		  Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
		    Page<Student> page1 = studentRepo.findAll(pageable);
	        DtoPageStudent<Student> student=new DtoPageStudent<Student>();
	        student.setContent(page1.getContent());
	        student.setPageSize(page1.getSize());
	        student.setLast(page1.isLast());
	        student.setTotalElements(page1.getNumberOfElements());
	        student.setTotalPage(page1.getTotalPages());
	        return student;     
	}
	////*******pagination using Entity********//////
	
	@Override
	public Page<Student> getpages(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return studentRepo.findAll(pageable);
	}
	
	
	
	@Override
	public Student create(Student student) {
		return studentRepo.save(student);
	}
	
	
}
