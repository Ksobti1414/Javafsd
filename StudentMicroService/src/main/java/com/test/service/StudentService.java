package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.entity.Student;
import com.test.repository.StudentRepository;

@Service
public class StudentService {
private StudentRepository repository;
public Student addStudent(Student std) {
	return repository.save(std);
}
public Student getStudentById(int id) {
	return repository.findById(id).get();
}
public Student updateStudentById(Student std) {
	return repository.save(std);
}
public List<Student>deleteStudentById(int id){
	repository.deleteById(id);
	return repository.findAll();
}
public List<Student>getAllStudents(){
	return repository.findAll();
}
}
