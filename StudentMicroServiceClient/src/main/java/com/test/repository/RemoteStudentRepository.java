package com.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.test.entity.Student;

public class RemoteStudentRepository {
public static String STUDENT_URL="http://STUDENTMICROSERVICE";
@Autowired
private RestTemplate restTemplate;
public List<Student>getAllStudents(){
	List<Student>list=restTemplate.getForObject(STUDENT_URL+"/list", new ArrayList<Student>().getClass());
	return list;
}
public Student getStudentById(int id) {
	Student obj=restTemplate.getForObject(STUDENT_URL+"/{id}", Student.class,id);
	return obj;
}
public Student createStudent(Student obj) {
	obj=restTemplate.postForObject(STUDENT_URL+"/create", obj, Student.class);
	return obj;
}
public Student updateStudentById(Student obj,int id) {
	obj.setId(id);
	restTemplate.put(STUDENT_URL+"/update/{id}", obj,Student.class,id);
	return obj;
}
public List<Student>deleteStudentById(int id){
	restTemplate.delete(STUDENT_URL+"delete/{id}",Student.class,id);
	List<Student>list=restTemplate.getForObject(STUDENT_URL+"/list", new ArrayList<Student>().getClass());
	return list;
}
}
